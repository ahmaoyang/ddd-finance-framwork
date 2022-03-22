package com.example.cp.oms.domain.model.vo;

import com.example.cp.oms.domain.model.OrderModelCreatorModel;
import com.example.cp.oms.spec.model.vo.IOrderItem;
import com.example.cp.oms.spec.model.vo.IOrderItemDelegate;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDelegateVO implements IOrderItemDelegate {

    private List<OrderItemVO> items;

    private OrderItemDelegateVO() {}

    public static OrderItemDelegateVO createWith(@NotNull OrderModelCreatorModel creator) {
        OrderItemDelegateVO delegate = new OrderItemDelegateVO();
        delegate.items = new ArrayList<>();
        return delegate;
    }

    @Override
    public List<? extends IOrderItem> getItems() {
        return items;
    }
}
