package com.example.cp.oms.infra.dao;

import com.example.cp.oms.infra.po.OrderItemData;

import java.util.List;

public interface OrderItemDao {

    List<OrderItemData> itemsOfOrder(Long orderId);
}
