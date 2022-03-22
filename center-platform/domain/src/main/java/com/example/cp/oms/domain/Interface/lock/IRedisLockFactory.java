package com.example.cp.oms.domain.Interface.lock;

import com.example.cp.oms.domain.Interface.cache.IRedisClient;
import com.example.cp.oms.spec.model.vo.LockEntry;

import java.util.concurrent.locks.Lock;

public interface IRedisLockFactory {

    /**
     * Create a mutex lock.
     */
    Lock create(IRedisClient redisClient, LockEntry lockEntry);
}
