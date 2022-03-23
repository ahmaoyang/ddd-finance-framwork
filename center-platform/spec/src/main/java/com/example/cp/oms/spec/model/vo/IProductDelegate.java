package com.example.cp.oms.spec.model.vo;

import java.util.List;

/**
 * 订单的服务产品管理器.
 *
 * 它管理某个订单的服务产品.
 * DDD里喜欢使用带有业务属性的VO，而不是直接使用Java primitive types，是很有道理的.
 */
public interface IProductDelegate {
    List<? extends IProduct> getProducts();
}
