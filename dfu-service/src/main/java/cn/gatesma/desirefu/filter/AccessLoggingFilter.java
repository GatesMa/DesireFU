package cn.gatesma.desirefu.filter;

import static cn.gatesma.desirefu.utils.ServerUtils.*;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.domain.trace.Message;
import cn.gatesma.desirefu.domain.trace.TraceContext;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;
import org.springframework.web.util.WebUtils;

@Component
public class AccessLoggingFilter extends OncePerRequestFilter {

    @Value("${server.port}")
    private String moduleName;

    // for trace log
    private static final Logger LOG = LoggerFactory.getLogger("access");

    // only for this class
    private static final Logger LOGGER = LoggerFactory.getLogger("AccessLoggingFilter");

    // 日志上报，appender
    private final static Marker ACCESS = MarkerFactory.getMarker("ACCESS");

    /**
     * 请求开始时间，单位微秒。
     */
    private static final String START_TIME_IN_MICRO = "startTimeInMicro";

    /**
     * 请求结束时间，单位微秒。
     */
    private static final String END_TIME_IN_MICRO = "endTimeInMicro";

    private static final String MODULE_NAME = "desire_fu";

    private static final String REQUEST_CALLEE = "desire_fu";


    // 不用打log的路径
    private static final String IGNORE_PATH_REGEX = "^.*\\/(webjars|api-docs|swagger-(resources|ui)|doc|favicon).*$";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // swagger、静态文件请求不进行trace日志收集
        String path = request.getServletPath();

        boolean ignore = path.matches(IGNORE_PATH_REGEX);



        if (ignore) {
            filterChain.doFilter(request, response);
        } else {

            LOGGER.debug("start doing trace log filter...");

            if (!isAsyncDispatch(request)) {
                request.setAttribute(START_TIME_IN_MICRO, System.currentTimeMillis());
            }
            HttpServletRequest requestToUse = request;
            HttpServletResponse responseToUse = response;

            if (!(request instanceof ContentCachingRequestWrapper)) {
                requestToUse = new ContentCachingRequestWrapper(request);
            }

            if (!(response instanceof ContentCachingResponseWrapper)) {
                responseToUse = new ContentCachingResponseWrapper(response);
            }

            try {
                filterChain.doFilter(requestToUse, responseToUse);
            } catch (Exception ex) {
                LOGGER.error("filter error ", ex);
            } finally {
                if (!isAsyncStarted(request)) {
                    request.setAttribute(END_TIME_IN_MICRO, System.currentTimeMillis());
                    try {
                        monitor((ContentCachingRequestWrapper) requestToUse,
                                (ContentCachingResponseWrapper) responseToUse);
                        LOGGER.debug("complete do monitor filter.");
                    } catch (Exception e) {
                        LOGGER.error("add monitor error ", e);
                    }
                    ((ContentCachingResponseWrapper) responseToUse).copyBodyToResponse();
                }
            }
        }
    }

    @Override
    protected boolean shouldNotFilterAsyncDispatch() {
        return false;
    }

    /**
     * 监控 TraceLog
     */
    private void monitor(ContentCachingRequestWrapper request, ContentCachingResponseWrapper response) {

        // 去掉两边空格
        String requestBody = StringUtils.trimToEmpty(getRequestBody(request));
        String responseBody = StringUtils.trimToEmpty(getResponseBody(response));

        LOGGER.info("Receive request: path: {}, param: {}", request.getServletPath(), requestBody);


        int responseCode = response.getStatusCode();
        int apiCode = ApiReturnCode.OK.code();
        String apiMsg = "";
        try {
            JSONObject jsonObject = JSONObject.parseObject(responseBody);
            if (jsonObject != null) {
                Integer code = jsonObject.getInteger("code");
                String message = jsonObject.getString("message");
                // 解析 code 和 message
                if (code != null) {
                    apiCode = code;
                }
                if (StringUtils.isNotBlank(message)) {
                    apiMsg = message;
                }
            }
        } catch (Exception e) {
            LOGGER.error("解析response {} 异常 ", responseBody, e);
        }

        // 过滤request和response中的折行
        requestBody = requestBody.replaceAll("\n|\r|\t", "");
        responseBody = responseBody.replaceAll("\n|\r|\t", "");

        // 打TraceLog
        addTraceLog(request, requestBody, responseBody, apiCode, apiMsg, responseCode);
    }

    /**
     * 生成trace log
     *
     * @param request
     */
    private void addTraceLog(ContentCachingRequestWrapper request, String requestBody,
                             String responseBody, int apiCode, String apiMsg, int responseCode) {


        TraceContext tc = getOrCreateTraceContext(request);

        String actName = getActName(request);
        String modName = getModName(request);

        Message message = new Message()
                .version("1")
                .context(tc)
                .appName(MODULE_NAME)
                .client(getClient(request))
                .callee(REQUEST_CALLEE)
                .modName(StringUtils.isBlank(modName) ? "-" : modName)
                .actName(StringUtils.isBlank(actName) ? "-" : actName)
                .clientIp(getClientIp(request))
                .serverIp(getServerIP())
                .duration((Long) request.getAttribute(END_TIME_IN_MICRO) - (Long) request.getAttribute(START_TIME_IN_MICRO))
                .errorCode((long) apiCode)
                .errorMessage(apiMsg)
                .reqMethod(StringUtils.trimToEmpty(request.getMethod()))
                .respCode((long) responseCode)
                .reqUrl(request.getRequestURI())
                .reqBody(StringUtils.isBlank(requestBody) ? "{}" : requestBody)
                .respBody(responseBody);

        try {
            // 打印者一条消息到日志文件里
            LOG.info(ACCESS, message.toString());
            LOGGER.info("request over: {}", message.toString());
        } catch (Exception e) {
            LOGGER.error("api {} 生成Trace Log 异常 ", modName, e);
        }
    }

    /**
     * 获取request body
     *
     * @param request
     * @return
     */
    private String getRequestBody(final HttpServletRequest request) {
        try {
            String requestBody = null;
            ContentCachingRequestWrapper wrapper = WebUtils.getNativeRequest(request, ContentCachingRequestWrapper.class);
            if (wrapper != null) {
                byte[] buf = wrapper.getContentAsByteArray();
                if (buf.length > 0) {
                    requestBody = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                }
            }
            // requestBody == null 表示可能没有读取过request的body
            if (null == requestBody) {
                requestBody = IOUtils.toString(wrapper.getInputStream(), request.getCharacterEncoding());
            }
            return requestBody;
        } catch (Exception e) {
            LOGGER.error("fail to get requestBody", e);
            return null;
        }
    }

    /**
     * 获取response body
     *
     * @param response
     * @return
     */
    private String getResponseBody(final HttpServletResponse response) {
        try {
            String responseBody = null;
            ContentCachingResponseWrapper wrapper = WebUtils.getNativeResponse(response, ContentCachingResponseWrapper.class);
            if (wrapper != null) {
                byte[] buf = wrapper.getContentAsByteArray();
                if (buf.length > 0) {
                    responseBody = new String(buf, 0, buf.length, wrapper.getCharacterEncoding());
                }
            }

            if (null == responseBody) {
                responseBody = IOUtils.toString(wrapper.getContentInputStream(), response.getCharacterEncoding());
            }
            return responseBody;
        } catch (Exception e) {
            LOGGER.error("fail to get responseBody", e);
            return null;
        }
    }
}
