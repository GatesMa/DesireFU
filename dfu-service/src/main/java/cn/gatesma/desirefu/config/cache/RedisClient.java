package cn.gatesma.desirefu.config.cache;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * User: gatesma
 * Date: 2020/11/12
 * Desc:
 */
@Component
public class RedisClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisClient.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * [set] 添加元素
     */
    public void sadd(String key, String member) {
        stringRedisTemplate.opsForSet().add(key, member);
    }

    /**
     * [string] 写入redis缓存（不设置expire存活时间）
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            stringRedisTemplate.opsForValue().set(key, value);
            result = true;
        } catch (Exception e) {
            LOGGER.error("RedisClient set error happen：" + e.getMessage());
        }
        return result;
    }

    /**
     * [string] 写入redis缓存,并指定过期时间
     */
    public boolean set(final String key, String value, long expireTimeOut, TimeUnit unit) {
        try {
            stringRedisTemplate.opsForValue().set(key, value, expireTimeOut, unit);
        } catch (Exception e) {
            LOGGER.error("RedisClient set with expireTime error：" + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * [hash] 写入hash表
     */
    public boolean hset(String key, String field, String value) {
        try {
            stringRedisTemplate.opsForHash().put(key, field, value);
        } catch (Exception e) {
            LOGGER.error("RedisClient hset error：" + e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 获取key对应的值
     */
    public String get(final String key) {
        String result = null;
        try {
            result = stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            LOGGER.error("RedisClient get key:{}, error:{}", key, e.getMessage());
        }

        return result;
    }

    /**
     * 判断redis缓存中是否有对应的key
     */
    public boolean exists(final String key) {
        boolean result = false;
        try {
            result = stringRedisTemplate.hasKey(key);
        } catch (Exception e) {
            LOGGER.error("RedisClient judge exists key:{}, error:{}", key, e.getMessage());
        }
        return result;
    }

    /**
     * redis根据key删除对应的value
     */
    public boolean remove(final String key) {
        try {
            if (key != null && exists(key)) {
                stringRedisTemplate.delete(key);
            }
        } catch (Exception e) {
            LOGGER.error("RedisClient remove key={}, error:{}", key, e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * redis根据keys批量删除对应的value
     *
     * @param keys
     * @return
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    public boolean putIfNotExists(String key, String value, int expireAfterMilSec) {
        if (key == null || value == null || expireAfterMilSec <= 0) {
            throw new IllegalArgumentException("Illegal Arguments! putNXPX need key!=null value!=null and expireAfterMilSec>0");
        }
        return stringRedisTemplate.execute((RedisCallback<Boolean>) connection -> {
            RedisSerializer valueSerializer = stringRedisTemplate.getValueSerializer();
            RedisSerializer keySerializer = stringRedisTemplate.getKeySerializer();
            Object obj = connection.execute("set", keySerializer.serialize(key),
                    valueSerializer.serialize(value),
                    "NX".getBytes(StandardCharsets.UTF_8),
                    "PX".getBytes(StandardCharsets.UTF_8),
                    String.valueOf(expireAfterMilSec).getBytes(StandardCharsets.UTF_8));
            return obj != null && "OK".equalsIgnoreCase(new String((byte[]) obj));
        });
    }

    public <T> T execute(RedisScript<T> script, List<String> keys, Object... args) {
        return stringRedisTemplate.execute(script, keys, args);
    }

}
