package com.example.cp.oms.domain.Interface.repository;

import com.example.cp.oms.domain.model.OrderMainModel;

import javax.validation.constraints.NotNull;

public interface IFinanceRepository {
    /**
     * 持久化
     *
     * @param orderModel
     */
    void insert(@NotNull OrderMainModel orderModel);

    /**
     * 通过订单Id 获取订单
     *
     * @param orderId
     * @return
     */
    OrderMainModel getOrder(@NotNull Long orderId);
}
