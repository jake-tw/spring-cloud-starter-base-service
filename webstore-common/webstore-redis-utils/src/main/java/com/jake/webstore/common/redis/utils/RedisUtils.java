package com.jake.webstore.common.redis.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    public String get(String key) {
        Long a = get("a", Long.class);

        return redisTemplate.opsForValue().get(key);
    }

    public <T> T get(String key, Class<T> resultType) {
        return resultType.cast(redisTemplate.opsForValue().get(key));
    }

    public boolean delete(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    public boolean tryLock(String key, String uuid, long timeout) {
        return Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, TimeUnit.SECONDS));
    }

    public boolean unlock(String key, String uuid) {
        RedisScript<Long> script = RedisScript.of("""
                    if redis.call('get', KEYS[1]) == ARGV[1]
                    then
                      return redis.call('del', KEYS[1])
                    else
                      return 0
                    end
                """, Long.class);
        List<String> keys = Collections.singletonList(key);
        Object[] args = {uuid};
        return Objects.equals(redisTemplate.execute(script, keys, args), 1L);
    }
}