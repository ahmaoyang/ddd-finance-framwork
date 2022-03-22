package com.example.cp.oms.domain.activity.submitorder;

import com.example.cp.oms.domain.activity.SubmitOrderStep;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.maoyang.enforce.annotation.Step;
import com.maoyang.enforce.runtime.DDD;
import com.maoyang.enforce.step.ReviseStepsException;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.domain.ability.ReviseStepsAbility;
import com.example.cp.oms.spec.Steps;
import com.example.cp.oms.spec.exception.OrderException;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 提交步骤基础操作 （操作内容相对可以自定义 ，基本上与业务不相关的步骤 ,与业务相关的步骤 可多添加 业务执行步骤）
 */
@Step(value = "submitBasicStep")
@Slf4j
public class BasicStep extends SubmitOrderStep {

    @Override
    public void execute(@NotNull OrderMainModel model) throws OrderException {
        model.setStep(this.stepCode());

        // 动态决定后续步骤：决定后续步骤这个行为，也抽象为扩展点，不同场景进行实现，以实现动态步骤编排的业务多态性
        List<String> revisedSteps = DDD.findAbility(ReviseStepsAbility.class).revisedSteps(model);
        if (revisedSteps != null) {
            log.info("重新编排步骤：{}", revisedSteps);

            // 通过异常，来改变后续步骤
            throw new ReviseStepsException().withSubsequentSteps(revisedSteps);
        }

        log.info("presorting...");
        // DDD.findAbility(PresortAbility.class).presort(model);
    }

    @Override
    public void rollback(@NotNull OrderMainModel model, @NotNull OrderException cause) {
        log.info("will rollback now...");
    }

    @Override
    public String stepCode() {
        return Steps.SubmitOrder.BasicStep;
    }


}
