package com.example.cp.oms.spec.model;

import com.maoyang.enforce.api.RequestProfile;
import com.maoyang.enforce.model.IDomainModel;
import com.example.cp.oms.spec.model.vo.IOrderItemDelegate;
import com.example.cp.oms.spec.model.vo.IProductDelegate;
import lombok.NonNull;

/**
 * 中台为业务前台输出的订单聚合根：以接口的方式控制visibility.
 *
 * 订单模型可能有N个方法，但只想输出给前台N-M个方法，通过这个机制就能容易地看到收益
 */
public interface IOrderMain extends IDomainModel {

    /**
     * 获取订单里包含的产品信息.
     */
    IProductDelegate productDelegate();

    IOrderItemDelegate itemDelegate();

    /**
     * 获取当前的请求参数.
     */
    RequestProfile requestProfile();

    /**
     * 获取订单来源.
     */
    String getSource();

    /**
     * 获取客户编号.
     */
    String getCustomerNo();

    /**
     * 客户提供的订单号.
     */
    String customerProvidedOrderNo();

    /**
     * 分配订单号.
     *
     * @param who
     * @param orderNo
     */
    void assignOrderNo(@NonNull Object who, String orderNo);

    String currentStep();

    String currentActivity();

    /**
     * 是否冷链业务.
     */
    boolean isColdChain();

    boolean isB2B();

    /**
     * 为预留字段x1赋值.
     */
    void setX1(String x1);

    /**
     * 为预留字段x2赋值.
     */
    void setX2(String x2);
}
