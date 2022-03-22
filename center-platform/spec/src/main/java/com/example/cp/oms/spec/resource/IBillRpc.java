package com.example.cp.oms.spec.resource;

// 这是个RPC调用的示例
// Redis、JDBC、MQ等资源，infrastructure jar里封装实现
public interface IBillRpc {

    /**
     * 调用账单中心进行账单还款操作
     *
     * @param money
     * @return true if successful
     */
    boolean preRefund(Integer money);
}
