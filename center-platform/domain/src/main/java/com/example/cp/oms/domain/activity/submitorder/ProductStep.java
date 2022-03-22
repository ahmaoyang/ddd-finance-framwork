package com.example.cp.oms.domain.activity.submitorder;

import com.example.cp.oms.domain.activity.SubmitOrderStep;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.maoyang.enforce.annotation.Step;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.spec.exception.OrderException;
import com.example.cp.oms.spec.Steps;

import javax.validation.constraints.NotNull;

@Step(value = "submitProductStep", name = "订单里产品校验", tags = Steps.Tags.Product)
@Slf4j
public class ProductStep extends SubmitOrderStep {

    @Override
    public void execute(@NotNull OrderMainModel model) throws OrderException {
        System.out.println("*****submitProductStep*****");
    }

    @Override
    public String stepCode() {
        return Steps.SubmitOrder.ProductStep;
    }
}
