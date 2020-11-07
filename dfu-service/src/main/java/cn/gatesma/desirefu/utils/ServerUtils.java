package cn.gatesma.desirefu.utils;

import cn.gatesma.desirefu.constants.Global;
import cn.gatesma.desirefu.domain.trace.TraceContext;
import com.google.common.base.Strings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author gatesma
 * @date 2020/11/6
 * @desc
 */
public class ServerUtils {

    private static final String X_FORWARDED_FOR_HEADER = "X-Forwarded-For";
    private static final String TRACE_CONTEXT_ATTR = "TRACE_CONTEXT";

    // header name
    public static final String HEADER_TRACE_ID = "X-Trace-Id";
    public static final String HEADER_SPAN_ID = "X-Span-Id";




    /**
     * 获取/生成 TraceContext
     * @param request
     * @return
     */
    public static TraceContext getOrCreateTraceContext(HttpServletRequest request){
        if (request !=null && request.getAttribute(TRACE_CONTEXT_ATTR) != null) {
            return (TraceContext) request.getAttribute(TRACE_CONTEXT_ATTR);
        }

        TraceContext tc;
        if (request !=null &&
                request.getHeader(HEADER_TRACE_ID)!=null &&
                request.getHeader(HEADER_SPAN_ID)!=null) {
            try {
                // parse may fail if traceId or spanId invalid.
                tc = TraceContext.parse(request.getHeader(HEADER_TRACE_ID), request.getHeader(HEADER_SPAN_ID));
            } catch (Exception e) {
                tc = TraceContext.newRoot();
            }
        } else {
            tc = TraceContext.newRoot();
        }

        request.setAttribute(TRACE_CONTEXT_ATTR, tc);
        return tc;
    }

    /**
     * 获取调用端ip
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String ret = request.getHeader(X_FORWARDED_FOR_HEADER);
        if (Strings.isNullOrEmpty(ret)) {
            ret = StringUtils.trimToEmpty(request.getRemoteAddr());
        }

        return ret.split("[,]")[0];
    }

    /**
     * 返回服务端ip
     */
    public static String getServerIP() {
        try {
            return (HostUtils.getHostnameAndIp())[1];
        } catch (Exception e) {
            return "127.0.0.1";
        }
    }

    /**
     *
     * @param request
     * @return
     */
    public static String getClient(HttpServletRequest request){
        return request==null ? "UNKNOWN" : CommonUtils.safeGetStringFromObj(request.getHeader(Global.PROXY_CLIENT_ID), "UNKNOWN");
    }

    public static Long getClientId(HttpServletRequest request){
        String client = getClient(request);
        return NumberUtils.isParsable(client) ? Long.valueOf(client) : 0L;
    }

    public static String getModName(HttpServletRequest request){
        return request==null ? "-" : CommonUtils.safeGetStringFromObj(request.getAttribute(Global.REQ_CONTROLLER_NAME));
    }


    public static String getActName(HttpServletRequest request){
        return request==null ? "-" : CommonUtils.safeGetStringFromObj(request.getAttribute(Global.REQ_METHOD_NAME));
    }

}
