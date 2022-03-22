package com.example.bp.oms.isv.extension;

import com.example.bp.oms.isv.IsvPartner;
import com.maoyang.enforce.annotation.Extension;
import com.example.cp.oms.spec.ext.ISerializableIsolationExt;
import com.example.cp.oms.spec.model.IOrderMain;
import com.example.cp.oms.spec.model.vo.LockEntry;

import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

/**
 * 订单串行化隔离的扩展点
 */
@Extension(code = IsvPartner.CODE, value = "isvSerializableIsolationExt", name = "场景的订单锁机制")
public class SerializableIsolationExt implements ISerializableIsolationExt {

    @Override
    public LockEntry createLockEntry(@NotNull IOrderMain model) {
        return new LockEntry(model.customerProvidedOrderNo(), 50, TimeUnit.MINUTES);
    }
}
