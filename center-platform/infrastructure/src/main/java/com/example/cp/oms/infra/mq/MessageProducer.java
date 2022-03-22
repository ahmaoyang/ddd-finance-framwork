package com.example.cp.oms.infra.mq;

import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.domain.Interface.mq.IMessageProducer;
import com.example.cp.oms.domain.model.OrderMainModel;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * mq 消息生产者
 */
@Component
@Slf4j
public class MessageProducer implements IMessageProducer {

    @Override
    public void produce(@NotNull OrderMainModel orderModel) {
        log.info("已经发送给MQ：{}", orderModel);
    }
}
