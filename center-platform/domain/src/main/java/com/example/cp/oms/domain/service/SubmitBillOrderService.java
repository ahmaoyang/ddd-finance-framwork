package com.example.cp.oms.domain.service;

import com.example.cp.oms.domain.ability.DecideStepsAbility;
import com.example.cp.oms.domain.ability.PostPersistAbility;
import com.example.cp.oms.domain.ability.SerializableIsolationAbility;
import com.example.cp.oms.domain.activity.SubmitBillOrderStepsExec;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.maoyang.enforce.annotation.DomainService;
import com.maoyang.enforce.model.IDomainService;
import com.maoyang.enforce.runtime.DDD;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.domain.CoreDomain;
import com.example.cp.oms.spec.exception.OrderErrorReason;
import com.example.cp.oms.spec.exception.OrderException;
import com.example.cp.oms.spec.Steps;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.locks.Lock;

@DomainService(domain = CoreDomain.CODE)
@Slf4j
public class SubmitBillOrderService implements IDomainService {

    @Resource
    private SubmitBillOrderStepsExec submitBillOrderStepsExec;


    public void submit(@NotNull OrderMainModel orderModel) throws OrderException {

        // 先通过防并发扩展点防止一个订单多次处理：但防并发逻辑在不同场景下不同
        // 同时 注意扩展点不是绑定到领域步骤的，它可以在任何地方使用！
        Lock lock = DDD.findAbility(SerializableIsolationAbility.class).acquireLock(orderModel);
        if (!SerializableIsolationAbility.useLock(lock)) {
            log.info("will not use lock");
        } else if (!lock.tryLock()) {
            // 存在并发
            throw new OrderException(OrderErrorReason.SubmitOrder.OrderConcurrentNotAllowed);
        }

        // 不同场景下，执行步骤不同：通过扩展点实现业务的多态
        List<String> steps = DDD.findAbility(DecideStepsAbility.class).decideSteps(orderModel, Steps.SubmitOrder.Activity);
        log.info("steps {}", steps);

        if (steps != null && !steps.isEmpty()) {
            // 通过步骤编排的模板方法执行每一个步骤，其中涉及到：步骤回滚，步骤重新编排
            submitBillOrderStepsExec.execute(Steps.SubmitOrder.Activity, steps, orderModel);
        }

        DDD.findAbility(PostPersistAbility.class).afterPersist(orderModel);

        log.info("提交完毕！");
    }
}
