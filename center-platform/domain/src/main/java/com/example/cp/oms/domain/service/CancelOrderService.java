package com.example.cp.oms.domain.service;

import com.example.cp.oms.domain.ability.DecideStepsAbility;
import com.example.cp.oms.domain.ability.SerializableIsolationAbility;
import com.example.cp.oms.domain.activity.CancelBillOrderStepsExec;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.maoyang.enforce.annotation.DomainService;
import com.maoyang.enforce.model.IDomainService;
import com.maoyang.enforce.runtime.DDD;
import com.example.cp.oms.domain.CoreDomain;
import com.example.cp.oms.spec.exception.OrderErrorReason;
import com.example.cp.oms.spec.exception.OrderException;

import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.spec.Steps;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.locks.Lock;

@DomainService(domain = CoreDomain.CODE)
@Slf4j
public class CancelOrderService implements IDomainService {

    @Resource
    private CancelBillOrderStepsExec cancelBillOrderStepsExec;

    public void submit(@NotNull OrderMainModel orderModel) throws OrderException {
        Lock lock = DDD.findAbility(SerializableIsolationAbility.class).acquireLock(orderModel);
        if (SerializableIsolationAbility.useLock(lock) && !lock.tryLock()) {
            // 存在并发
            throw new OrderException(OrderErrorReason.SubmitOrder.OrderConcurrentNotAllowed);
        }

        List<String> steps = DDD.findAbility(DecideStepsAbility.class).decideSteps(orderModel, Steps.CancelOrder.Activity);
        cancelBillOrderStepsExec.execute(Steps.CancelOrder.Activity, steps, orderModel);
    }
}
