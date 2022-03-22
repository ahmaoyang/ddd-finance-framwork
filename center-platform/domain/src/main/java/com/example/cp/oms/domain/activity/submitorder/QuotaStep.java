package com.example.cp.oms.domain.activity.submitorder;

import com.example.cp.oms.domain.activity.SubmitOrderStep;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.maoyang.enforce.annotation.Step;
import com.example.cp.oms.spec.Steps;
import com.example.cp.oms.spec.exception.OrderException;
import com.example.oms.d.quota.spec.service.IQuotaService;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 资金相关的步骤活动
 */
@Step(value = "quotaStep")
public class QuotaStep extends SubmitOrderStep {

    // 演示：通过资金额度支撑域来为订单核心域提供方便的服务
    @Resource
    private IQuotaService quotaService;

    @Override
    public void execute(@NotNull OrderMainModel model) throws OrderException {
        quotaService.occupyQuotaAmount(model);
    }

    @Override
    public String stepCode() {
        return Steps.SubmitOrder.QuotaStep;
    }
}
