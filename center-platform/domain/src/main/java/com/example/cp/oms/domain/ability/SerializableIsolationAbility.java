package com.example.cp.oms.domain.ability;

import com.maoyang.enforce.annotation.DomainAbility;
import com.maoyang.enforce.runtime.BaseDomainAbility;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.domain.CoreDomain;
import com.example.cp.oms.domain.Interface.cache.IRedisClient;
import com.example.cp.oms.domain.Interface.lock.IRedisLockFactory;
import com.example.cp.oms.spec.ext.ISerializableIsolationExt;
import com.example.cp.oms.spec.model.IOrderMain;
import com.example.cp.oms.spec.model.vo.LockEntry;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.concurrent.locks.Lock;

@DomainAbility(domain = CoreDomain.CODE, name = "订单串行化隔离的能力")
@Slf4j
public class SerializableIsolationAbility extends BaseDomainAbility<IOrderMain, ISerializableIsolationExt> {
    private static final Lock withoutLock = null;

    @Resource
    private IRedisLockFactory redisLockFactory;

    @Resource
    private IRedisClient redisClient;

    public Lock acquireLock(@NotNull IOrderMain model) {
        LockEntry lockEntry = firstExtension(model).createLockEntry(model);
        if (lockEntry == null) {
            return withoutLock;
        }

        // 为了避免前台锁key冲突，中台统一加锁前缀，隔离不同的业务前台
        lockEntry.withPrefix(model.getCustomerNo());
        log.info("key:{} expires:{} {}", lockEntry.lockKey(), lockEntry.getLeaseTime(), lockEntry.getTimeUnit());
        return redisLockFactory.create(redisClient, lockEntry);
    }

    public static boolean useLock(Lock lock) {
        return lock != withoutLock;
    }

    @Override
    public ISerializableIsolationExt defaultExtension(@NotNull IOrderMain model) {
        // 默认不防并发
        return null;
    }
}
