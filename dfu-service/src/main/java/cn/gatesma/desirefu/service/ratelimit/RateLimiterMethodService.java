package cn.gatesma.desirefu.service.ratelimit;

import cn.gatesma.desirefu.annotation.DistributedRateLimit;
import cn.gatesma.desirefu.constant.RateLimitKey;
import org.springframework.stereotype.Service;

/**
 * 由于一个类内调用本类的方法，注解不生效，为了让分布式限流注解生效，单独提供一个类来增加方法使得注解生效。
 */
@Service
public class RateLimiterMethodService {

    @DistributedRateLimit(keyOfConfigCenter = RateLimitKey.SELECT_API_QUERY_LIMIT_KEY, unitSeconds = 1, defaulCount = 10, noticeMsg = "该接口当前被限流，请求传入过多accountIds时会被限流")
    public void rateLimitQuery(int rate) {
        //不需要实现，主要是为了让注解生效
    }

}
