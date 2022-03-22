package com.example.cp.oms.domain.activity.submitorder;

import com.example.cp.oms.domain.activity.SubmitOrderStep;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.maoyang.enforce.annotation.Step;
import com.example.cp.oms.spec.exception.OrderException;
import com.example.cp.oms.domain.Interface.mq.IMessageProducer;
import com.example.cp.oms.spec.Steps;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 消息发送步骤
 */
@Step(value = "submitMqStep")
public class BroadcastStep extends SubmitOrderStep {

    @Resource
    private IMessageProducer messageProducer;

    @Override
    public void execute(@NotNull OrderMainModel model) throws OrderException {
        messageProducer.produce(model);
    }

    @Override
    public String stepCode() {
        return Steps.SubmitOrder.BroadcastStep;
    }
}
