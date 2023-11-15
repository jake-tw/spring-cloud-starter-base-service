package com.jake.webstore.cloud.base.component;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class RedisService {

    private final ConcurrentHashMap<String, String> mockRedisTemplate = new ConcurrentHashMap<>();

    private final Lock lock = new ReentrantLock();

    public void set(String key, String value) {
        mockRedisTemplate.put(key, value);
    }

    public void set(String key, String value, long timeout) {
        mockRedisTemplate.put(key, value);
    }

    public String get(String key) {
        return mockRedisTemplate.get(key);
    }

    public <T> T get(String key, Class<T> resultType) {
        return resultType.cast(mockRedisTemplate.get(key));
    }

    public boolean delete(String key) {
        return mockRedisTemplate.remove(key) != null;
    }

    public boolean tryLock(String key, String uuid, long timeout) {
        return lock.tryLock();
    }

    public boolean unlock(String key, String uuid) {
        lock.unlock();
        return true;
    }
}