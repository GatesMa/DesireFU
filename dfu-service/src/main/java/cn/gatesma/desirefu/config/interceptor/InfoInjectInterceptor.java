package cn.gatesma.desirefu.config.interceptor;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.constants.Global;
import cn.gatesma.desirefu.domain.ApiResult;
import cn.gatesma.desirefu.utils.ServiceEnv;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author gatesma
 * @date 2020/11/7
 * @desc 请求信息注入拦截器
 */
@Component
@Order
public class InfoInjectInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(InfoInjectInterceptor.class);


    @Resource
    private ServiceEnv env;

    /**
     * 验证GDT-Proxy返回信息逻辑
     *
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String controllerName = "UNKNOWN";
        String actionName = "UNKNOWN";

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            controllerName = handlerMethod.getBeanType().getName();
            actionName = handlerMethod.getMethod().getName();
        }
        request.setAttribute(Global.REQ_CONTROLLER_NAME, controllerName);
        request.setAttribute(Global.REQ_METHOD_NAME, actionName);

        return true;
    }

    private void handleException(HttpServletRequest request, HttpServletResponse response, ApiReturnCode retCode, String msg) {
        String url = request.getContextPath() + request.getServletPath();
        try {
            response.setHeader("Content-Type", "text/json;charset=UTF-8");
            response.getWriter().write(JSONObject.toJSONString(ApiResult.buildFailedResult(retCode, msg)));
        } catch (IOException ioe) {
            LOG.error("调用接口 {} 验证失败 {} 写入response异常", url, msg, ioe);
        }
    }
}
