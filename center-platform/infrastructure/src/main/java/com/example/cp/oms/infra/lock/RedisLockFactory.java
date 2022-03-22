package com.example.cp.oms.infra.lock;

import com.example.cp.oms.domain.Interface.cache.IRedisClient;
import com.example.cp.oms.domain.Interface.lock.IRedisLockFactory;
import com.example.cp.oms.spec.model.vo.LockEntry;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;

@Component
public class RedisLockFactory implements IRedisLockFactory {

    @Override
    public Lock create(IRedisClient redisClient, LockEntry lockEntry) {
        return new RedisLock(redisClient, lockEntry);
    }
}
