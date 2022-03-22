package com.example.cp.oms.domain.activity.submitorder;

import com.example.cp.oms.domain.activity.SubmitOrderStep;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.maoyang.enforce.annotation.Step;
import com.example.cp.oms.spec.Steps;
import com.example.cp.oms.spec.exception.OrderException;

import javax.validation.constraints.NotNull;

@Step(value = "submitPresortStep", name = "预处理步骤")
public class PreHandleStep extends SubmitOrderStep {

    @Override
    public void execute(@NotNull OrderMainModel model) throws OrderException {
        // TODO 在此添加预处理  代码

        System.out.println("*********执行预处理功能*********");
    }

    @Override
    public String stepCode() {
        return Steps.SubmitOrder.PresortStep;
    }
}
