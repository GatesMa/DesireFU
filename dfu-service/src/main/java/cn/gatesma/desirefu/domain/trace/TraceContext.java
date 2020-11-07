package cn.gatesma.desirefu.domain.trace;

import cn.gatesma.desirefu.utils.ValidateUtil;
import com.fasterxml.uuid.Generators;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gatesma
 * @date 2020/11/7
 * @desc 监控系统的上下文对象
 */
public class TraceContext {

    private String traceId;
    private String spanId;

    private TraceContext parent;

    /* 维护当前节点的子节点最大索引值*/
    private AtomicInteger maxChild = new AtomicInteger(0);

    /**
     * 返回root节点，即traceId为version 1的uuid，spanId为0
     *
     * @return
     */
    public static TraceContext newRoot() {
        return new TraceContext(traceId(), spanId());
    }

    /**
     * 接收外部id，生成TraceContext
     * @param traceId
     * @param spanId
     * @return
     */
    public static TraceContext parse(String traceId, String spanId) {
        if (!ValidateUtil.validateTraceId(traceId)) {
            throw new IllegalArgumentException("traceId非法");
        }

        if (!ValidateUtil.validateSpanId(spanId)) {
            throw new IllegalArgumentException("spanId非法");
        }
        return new TraceContext(traceId, spanId);
    }

    /**
     * 生成uuid
     * @return 一个例如e37b7e44142b11e7b627fb44f8adfbd8的32位长度字符串
     */
    private static String traceId() {
        UUID uuid = Generators.timeBasedGenerator().generate();
        return uuid.toString().replaceAll("-", "");
    }

    /**
     * 生成root spanId
     */
    private static String spanId() {
        return "0";
    }

    /**
     * 生成基于parentId的第n个子节点spanId
     * @return 如果parentId是0.1，childNum是2，返回0.1.2
     */
    private static String spanId(String parentId, int childId) {
        if (!ValidateUtil.validateSpanId(parentId)) {
            throw new IllegalArgumentException("parentId非法");
        }

        if (childId < 1) {
            throw new IllegalArgumentException("childId不能小于1");
        }

        return parentId + "." + childId;
    }

    private TraceContext(String traceId, String spanId) {
        this.traceId = traceId;
        this.spanId = spanId;
    }

    public String getTraceId() {
        return traceId;
    }

    public String getSpanId() {
        return spanId;
    }

    /**
     * 生成当前对象的子节点，如果当前对象：<br>
     * traceId = "AAA"<br>
     * spanId = "0.4"<br>
     * 且它已经有1，2，3，4，5个子节点，即maxChild = 5 <br>
     * 那么调用后返回新的context节点：<br>
     * traceId = "AAA"<br>
     * spanId = "0.4.6"<br>
     * 同时当前节点的maxChild = 6
     */
    public TraceContext nextChild() {
        String spanId = spanId(this.spanId, this.maxChild.incrementAndGet());

        TraceContext child = new TraceContext(this.traceId, spanId);
        child.parent = this;

        return child;
    }

    /**
     * 生成当前对象的下一个兄弟节点，如果当前对象：<br>
     * traceId = "AAA"<br>
     * spanId = "0.4"<br>
     * 那么调用后返回的新context节点：<br>
     * traceId = "AAA"<br>
     * spanId = "0.5"<br>
     * 同时当前节点的maxChild = 5
     */
    public TraceContext nextSibling() {
        if (this.parent == null) {
            throw new UnsupportedOperationException("不能在一个no-parent context对象上调用nextSibling");
        }

        return this.parent.nextChild();
    }

    @Override
    public String toString() {
        return "traceId = " + traceId + ", spanId = " + spanId;
    }

}
