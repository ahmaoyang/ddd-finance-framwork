package com.example.cp.oms.domain.activity.submitorder;

import com.example.cp.oms.domain.ability.AssignOrderNoAbility;
import com.example.cp.oms.domain.activity.SubmitOrderStep;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.maoyang.enforce.annotation.Step;
import com.maoyang.enforce.runtime.DDD;
import com.example.cp.oms.domain.ability.CustomModelAbility;
import com.example.cp.oms.spec.exception.OrderException;
import com.example.cp.oms.domain.Interface.repository.IFinanceRepository;
import com.example.cp.oms.spec.Steps;


import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
/**
 * 持久化
 */
@Step(value = "submitPersistStep")
public class PersistStep extends SubmitOrderStep {

    @Resource
    private IFinanceRepository orderRepository;
    
    @Override
    public void execute(@NotNull OrderMainModel model) throws OrderException {
        // 分配订单号：不同场景下，订单号规则不同
        DDD.findAbility(AssignOrderNoAbility.class).assignOrderNo(model);

        // 处理个性化字段
        DDD.findAbility(CustomModelAbility.class).explain(model);

        // 落库
        orderRepository.insert(model);
    }

    @Override
    public String stepCode() {
        return Steps.SubmitOrder.PersistStep;
    }

    @Override
    public String activityCode() {
        return super.activityCode();
    }
}
