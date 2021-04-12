package cn.gatesma.desirefu.aop;

import cn.gatesma.desirefu.constants.ApiReturnCode;
import cn.gatesma.desirefu.service.processor.BatchSyncAccountToEsProcessor;
import cn.gatesma.desirefu.service.processor.BatchSyncOrganizeToEsProcessor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 *  此切面用于在一个方法执行结束后，同步accountId到ES
 */
@Aspect
@Component
public class SyncESAspect {

    private Logger LOG = LoggerFactory.getLogger(SyncESAspect.class);

    @Resource
    private BatchSyncAccountToEsProcessor syncAccountToEsProcessor;

    @Resource
    private BatchSyncOrganizeToEsProcessor syncOrganizeToEsProcessor;

    private boolean isRetOK(Object ret) {
        try {
            Method m = ret.getClass().getMethod("getCode");
            if ((int) m.invoke(ret) != ApiReturnCode.OK.code()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            LOG.error("isRetOK throws an exception! e = ", e);
        }
        return false;
    }



    /**
     *  取返回值中的accountId, 同步es
     */
    @AfterReturning(value = "@annotation(cn.gatesma.desirefu.annotation.NeedSyncAddNormalAnnotation)",
            returning = "response")
    public void doAfterAddNormalController(JoinPoint joinPoint, ResponseEntity response) {
        if (joinPoint.getArgs().length < 1) {
            return;
        }

        Object ret = response.getBody();
        if (ret == null) {
            return;
        }

        if (isRetOK(ret) == false) {
            return;
        }

        try {
            Method m = ret.getClass().getMethod("getData");
            Object data = m.invoke(ret);
            if (data != null) {
                m = data.getClass().getMethod("getAccountId");
                Long accountId = (Long) m.invoke(data);
                LOG.info("doAfterAddNormalController accountId: {}", accountId);
                syncAccountToEsProcessor.syncSubAccountToEs(Arrays.asList(accountId));
            }
        } catch (Exception e) {
            LOG.error("doAfterAddNormalController throws an exception! e = ", e);
        }
    }


    /**
     *  取返回值中的organize, 同步es
     */
    @AfterReturning(value = "@annotation(cn.gatesma.desirefu.annotation.NeedSyncAddOrganizeAnnotation)",
        returning = "response")
    public void doAfterAddOrganizeController(JoinPoint joinPoint, ResponseEntity response) {
        if (joinPoint.getArgs().length < 1) {
            return;
        }

        Object ret = response.getBody();
        if (ret == null) {
            return;
        }

        if (isRetOK(ret) == false) {
            return;
        }

        try {
            Method m = ret.getClass().getMethod("getData");
            Object data = m.invoke(ret);
            if (data != null) {
                m = data.getClass().getMethod("getOrganizeId");
                Long organizeId = (Long) m.invoke(data);
                LOG.info("doAfterAddOrganizeController organizeId: {}", organizeId);
                syncOrganizeToEsProcessor.syncSubOrganizeToEs(Arrays.asList(organizeId));
            }
        } catch (Exception e) {
            LOG.error("doAfterAddOrganizeController throws an exception! e = ", e);
        }
    }

}
