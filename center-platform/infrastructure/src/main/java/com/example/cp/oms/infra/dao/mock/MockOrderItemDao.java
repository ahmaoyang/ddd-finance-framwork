package com.example.cp.oms.infra.dao.mock;

import com.example.cp.oms.infra.dao.OrderItemDao;
import com.example.cp.oms.infra.po.OrderItemData;
import org.springframework.stereotype.Component;

import java.util.List;

// 实际项目，可以使用MyBatis（这里只是做个模拟）
@Component
public class MockOrderItemDao implements OrderItemDao {

    @Override
    public List<OrderItemData> itemsOfOrder(Long orderId) {
        return null;
    }
}
