package com.itranlin.basic.common.util;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author itranlin
 */
public class RedisUtil {

    private static final StringRedisTemplate STRING_REDIS_TEMPLATE = SpringUtils.getBean(StringRedisTemplate.class);

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return 设置是否成功
     */
    public static boolean expire(String key, long time) {
        try {
            if (time > 0) {
                RedisUtil.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     * @return 设置是否成功
     */
    public static boolean expire(String key, long time, TimeUnit unit) {
        try {
            if (time > 0) {
                STRING_REDIS_TEMPLATE.expire(key, time, unit);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return 时间(秒) 返回0代表为永久有效
     */
    public static long getExpire(String key) {
        Long result = STRING_REDIS_TEMPLATE.getExpire(key, TimeUnit.SECONDS);
        if (result == null) {
            result = 0L;
        }
        return result;
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true 存在 false不存在
     */
    public static boolean hasKey(String key) {
        Boolean result = STRING_REDIS_TEMPLATE.hasKey(key);
        if (result == null) {
            result = false;
        }
        return result;
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    public static void del(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                STRING_REDIS_TEMPLATE.delete(key[0]);
            } else {
                STRING_REDIS_TEMPLATE.delete(Arrays.asList(key));
            }
        }
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public static String get(String key) {
        return key == null ? null : STRING_REDIS_TEMPLATE.opsForValue().get(key);
    }

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public static Set<String> getKeys(String key) {
        return key == null ? null : STRING_REDIS_TEMPLATE.keys(key);
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false失败
     */
    public static boolean set(String key, String value) {
        try {
            STRING_REDIS_TEMPLATE.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 普通缓存放入并设置时间
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    public static boolean set(String key, String value, long time) {
        try {
            if (time > 0) {
                STRING_REDIS_TEMPLATE.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
