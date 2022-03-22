package com.example.cp.oms.domain.activity;

import com.maoyang.enforce.step.IRevokableDomainStep;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.example.cp.oms.spec.exception.OrderException;
import com.example.cp.oms.spec.Steps;

import javax.validation.constraints.NotNull;

public abstract class SubmitOrderStep implements IRevokableDomainStep<OrderMainModel, OrderException> {

    @Override
    public String activityCode() {
        return Steps.SubmitOrder.Activity;
    }

    @Override
    public void rollback(@NotNull OrderMainModel model, @NotNull OrderException cause) {
        // 回滚能操作在这里完成
        System.out.println("默认不回滚,子类可以通过覆盖实现对应步骤的回滚逻辑");
    }
}
