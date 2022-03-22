package com.example.cp.oms.domain.activity;

import com.maoyang.enforce.runtime.StepsExecTemplate;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.domain.model.OrderMainModel;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CancelBillOrderStepsExec extends StepsExecTemplate<CancelOrderStep, OrderMainModel> {

    @Override
    protected void beforeStep(CancelOrderStep step, OrderMainModel model) {
        log.info("step:{}.{} before:{}", step.activityCode(), step.stepCode(), model.label());
    }

    @Override
    protected void afterStep(CancelOrderStep step, OrderMainModel model) {
    }
}
