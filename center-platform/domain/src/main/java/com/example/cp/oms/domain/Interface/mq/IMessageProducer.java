package com.example.cp.oms.domain.Interface.mq;

import com.example.cp.oms.domain.model.OrderMainModel;

import javax.validation.constraints.NotNull;

/**
 * MQ的使用方式通过接口形式定义在domain层，Infrastructure来实现.
 *
 * 一种依赖倒置模式
 * 这样，domain层才能主宰世界，成为系统的中心：它要求Infrastructure做到什么
 * 至于如何做到，domain层不关心：那是技术的事情，domain只负责业务逻辑
 */
public interface IMessageProducer {

    void produce(@NotNull OrderMainModel orderModel);
}
