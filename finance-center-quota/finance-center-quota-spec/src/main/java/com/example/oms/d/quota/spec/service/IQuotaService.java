package com.example.oms.d.quota.spec.service;

import com.maoyang.enforce.model.IDomainService;
import com.example.cp.oms.spec.model.IOrderMain;

// 资金额度相关的服务，都收敛在资金额度支撑域，通过领域服务提供给订单核心域调用：JVM内调用, not RPC
public interface IQuotaService extends IDomainService {

    /**
     * 预占.
     *
     * @param orderMain core domain提供的领域模型聚合根
     */
    void occupyQuotaAmount(IOrderMain orderMain);

}
