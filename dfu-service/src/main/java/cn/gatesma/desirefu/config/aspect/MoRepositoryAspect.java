
package cn.gatesma.desirefu.config.aspect;

import cn.gatesma.desirefu.config.aspect.annotation.DIAccessMo;
import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.LinkedList;


@Aspect
@Component
public class MoRepositoryAspect {

  private static final Logger logger = LoggerFactory.getLogger(MoRepositoryAspect.class);
  

  private ThreadLocal<LinkedList<Elapse>> context = new ThreadLocal<>();

  @Pointcut("@annotation(cn.gatesma.desirefu.config.aspect.annotation.DIAccessMo)")
  public void certRepositoryPoint() {}

  
  @Before("certRepositoryPoint()&&@annotation(dIAccessMo)")
  public void doBefore(JoinPoint joinPoint, DIAccessMo dIAccessMo) {
    try {
      if (context.get() == null) {
        context.set(new LinkedList<Elapse>());
      }
      context.get()
        .add(new Elapse()
          .method(joinPoint.getSignature().getName())
          .params(Arrays.toString(joinPoint.getArgs()))
          .time(System.currentTimeMillis())
          .mo(dIAccessMo));
    } catch (Throwable e) {
      context.remove();
      logger.error("error!", e);
    }
  }

  
  @AfterReturning(returning = "ret", pointcut = "certRepositoryPoint()")
  public void doAfterReturning(Object ret) {
    report();
  }
  
  @AfterThrowing(pointcut = "certRepositoryPoint()",throwing="ex")
  public void doAfterThrowing(Exception ex) {
    report();
  }

  private void report() {
    try {
      LinkedList<Elapse> elapseChan = context.get();
      if(CollectionUtils.isNotEmpty(elapseChan)) {
        int layer = elapseChan.size();
        Elapse elapse = elapseChan.removeLast();
        if(elapse!=null) {
          DIAccessMo mo=elapse.getMo();
          String method= elapse.getMethod();
          String params= elapse.getParams();
          String db=mo==null?"unknown":mo.db();
          long duration=System.currentTimeMillis() - elapse.getTime();
          logger.info("elapse='{},'db='{}',layer='{}',method='{}',parameter='{}'",duration,db,layer,method,params);
        }
      }
    } catch (Throwable e) {
      context.remove();
      logger.error("error!", e);
    }
  }

  private static class Elapse {
    private String method;
    private String params;
    private long time;
    private DIAccessMo mo;
    

    public String getMethod() {

      return method;
    }

    public long getTime() {

      return time;
    }

    public String getParams() {
    
      return params;
    }

    public Elapse method(String method) {
      this.method = method;
      return this;
    }

    public Elapse time(long time) {
      this.time = time;
      return this;
    }

    public Elapse params(String params) {
      this.params=params;
      return this;
    }

    public DIAccessMo getMo() {
    
      return mo;
    }

    public Elapse mo(DIAccessMo mo) {
    
      this.mo = mo;
      return this;
    }
    
  }

}

