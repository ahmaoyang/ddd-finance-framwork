package com.example.cp.oms.domain.activity;

import com.maoyang.enforce.step.IDomainStep;
import com.example.cp.oms.spec.exception.OrderException;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.example.cp.oms.spec.Steps;

public abstract class CancelOrderStep implements IDomainStep<OrderMainModel, OrderException> {

    @Override
    public String activityCode() {
        return Steps.CancelOrder.Activity;
    }

}
