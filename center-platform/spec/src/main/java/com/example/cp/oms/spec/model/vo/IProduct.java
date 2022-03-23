package com.example.cp.oms.spec.model.vo;

/**
 * 订单包含的服务产品信息.
 *
 * 例如：仓内加工，货到付款，保价等，都是额外的服务产品.
 */
public interface IProduct {

    /**
     * 产品标识码.
     */
    String code();
}
