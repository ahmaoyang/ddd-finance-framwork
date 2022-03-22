package com.example.cp.oms.infra.dao;

import com.example.cp.oms.infra.po.OrderMainData;

public interface OrderMainDao {

    void insert(OrderMainData orderMainData);

    OrderMainData getById(Long id);
}
