package cn.gatesma.desirefu.domain.trace;

import cn.gatesma.desirefu.utils.ValidateUtil;

import java.util.Objects;

/**
 * @author gatesma
 * @date 2020/11/7
 * @desc 定义了打印到监控日志里消息体的各个属性
 */
public class Message {
    // 用空格代替\t
    private final static char TAB = ' ';

    private String version;
    private TraceContext context;
    private String appName;
    private String client;
    private String callee;
    private String modName;
    private String actName;
    private String clientIp;
    private String serverIp;
    private Long duration;
    private Long errorCode;
    private String errorMessage;
    private String reqMethod;
    private Long respCode;
    private String reqUrl;
    private String reqBody;
    private String respBody;

    public Message version(String version) {
        this.version = version;
        return this;
    }

    public Message context(TraceContext context) {
        this.context = context;
        return this;
    }

    public Message appName(String appName) {
        this.appName = appName;
        return this;
    }

    public Message client(String client) {
        this.client = client;
        return this;
    }

    public Message callee(String callee) {
        this.callee = callee;
        return this;
    }

    public Message modName(String modName) {
        this.modName = modName;
        return this;
    }

    public Message actName(String actName) {
        this.actName = actName;
        return this;
    }

    public Message clientIp(String clientIp) {
        this.clientIp = clientIp;
        return this;
    }

    public Message serverIp(String serverIp) {
        this.serverIp = serverIp;
        return this;
    }

    public Message duration(Long duration) {
        this.duration = duration;
        return this;
    }

    public Message errorCode(Long errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public Message errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public Message reqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
        return this;
    }

    public Message respCode(Long respCode) {
        this.respCode = respCode;
        return this;
    }

    public Message reqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
        return this;
    }

    public Message reqBody(String reqBody) {
        this.reqBody = reqBody;
        return this;
    }

    public Message respBody(String respBody) {
        this.respBody = respBody;
        return this;
    }

    public Message validate() {
        if (!ValidateUtil.validateTraceId(context.getTraceId())) {
            throw new IllegalArgumentException("traceId非法");
        }

        if (!ValidateUtil.validateSpanId(context.getSpanId())) {
            throw new IllegalArgumentException("spanId非法");
        }

        version = Objects.toString(version, "1");
        appName = Objects.toString(appName, "");
        client = Objects.toString(client, "");
        callee = Objects.toString(callee, "");

        if (clientIp == null) {
            throw new IllegalArgumentException("clientIp不能为空");
        }

        if (serverIp == null) {
            throw new IllegalArgumentException("serverIp不能为空");
        }

        if (duration == null) {
            throw new IllegalArgumentException("执行时长不能为空");
        }

        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        tab(sb, version);
        tab(sb, context.getTraceId());
        tab(sb, context.getSpanId());
        tab(sb, appName);
        tab(sb, client);
        tab(sb, callee);
        tab(sb, modName);
        tab(sb, actName);
        tab(sb, clientIp);
        tab(sb, serverIp);
        tab(sb, duration);
        tab(sb, errorCode);
        tab(sb, errorMessage);
        tab(sb, reqMethod);
        tab(sb, respCode);
        tab(sb, reqUrl);
        tab(sb, reqBody);
        tab(sb, respBody);

        return sb.toString();
    }

    private void tab(StringBuilder sb, Long l) {
        if (l != null) {
            sb.append(l);
        }
        sb.append(TAB);
    }

    private static void tab(StringBuilder sb, String s) {
        if (s != null) {
            sb.append(s);
        }
        sb.append(TAB);
    }
}
