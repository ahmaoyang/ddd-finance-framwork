package com.example.cp.oms.domain.activity.cancelorder;

import com.example.cp.oms.domain.activity.CancelOrderStep;
import com.maoyang.enforce.annotation.Step;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.spec.exception.OrderException;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.example.cp.oms.spec.Steps;

import javax.validation.constraints.NotNull;

@Step(value = "cancelBasicStep")
@Slf4j
public class BasicStep extends CancelOrderStep {

    @Override
    public void execute(@NotNull OrderMainModel model) throws OrderException {
        System.out.println("*************execute****************");
    }

    @Override
    public String stepCode() {
        return Steps.CancelOrder.BasicStep;
    }
}
