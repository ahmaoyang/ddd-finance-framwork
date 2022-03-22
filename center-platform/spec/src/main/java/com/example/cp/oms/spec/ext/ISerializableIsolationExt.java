package com.example.cp.oms.spec.ext;

import com.maoyang.enforce.ext.IDomainExtension;
import com.example.cp.oms.spec.model.IOrderMain;
import com.example.cp.oms.spec.model.vo.LockEntry;

import javax.validation.constraints.NotNull;

/**
 * 订单串行化隔离的扩展点声明，即防并发锁（串行化功能是必须 必须添加串行化扩展点）
 */
public interface ISerializableIsolationExt extends IDomainExtension {

    /**
     * 获取防并发锁的信息.
     *
     * @param model
     * @return lock entry object. 如果对象为空, 不需要防并发
     */
    LockEntry createLockEntry(@NotNull IOrderMain model);

}
