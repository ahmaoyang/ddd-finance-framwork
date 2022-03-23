package com.example.cp.oms.domain.model.vo;

import com.example.cp.oms.domain.model.OrderMainModel;
import lombok.Data;
import com.example.cp.oms.spec.model.vo.IOrderItem;

/**
 * 订单项.
 *
 * 每个{@link OrderMainModel}包含多个订单项.
 */
@Data
public class OrderItemVO implements IOrderItem {
    private String item;
    private Integer quantity;
    private String orderLine;

}
