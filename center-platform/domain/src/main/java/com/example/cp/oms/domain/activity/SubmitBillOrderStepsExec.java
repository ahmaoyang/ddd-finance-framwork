package com.example.cp.oms.domain.activity;

import com.maoyang.enforce.runtime.StepsExecTemplate;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.domain.model.OrderMainModel;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SubmitBillOrderStepsExec extends StepsExecTemplate<SubmitOrderStep, OrderMainModel> {
    /**
     * 前置操作
     *
     * @param step
     * @param model
     */
    @Override
    protected void beforeStep(SubmitOrderStep step, OrderMainModel model) {
        log.info("step:{}.{} before:{}", step.activityCode(), step.stepCode(), model.label());

        System.out.println("beforeStep*********");

    }

    /**
     * 后置操作
     *
     * @param step
     * @param model
     */
    @Override
    protected void afterStep(SubmitOrderStep step, OrderMainModel model) {

        System.out.println("afterStep*********");
    }
}
