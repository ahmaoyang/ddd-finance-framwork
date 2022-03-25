package com.example.oms.d.quota.domain.service;

import com.example.oms.d.quota.domain.facade.rpc.IRemoteQuotaRpc;
import com.maoyang.enforce.annotation.DomainService;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.spec.model.IOrderMain;
import com.example.cp.oms.spec.model.vo.IOrderItem;
import com.example.oms.d.quota.spec.QuotaDomain;
import com.example.oms.d.quota.spec.service.IQuotaService;

import javax.annotation.Resource;

@DomainService(domain = QuotaDomain.CODE)
@Slf4j
public class QuotaService implements IQuotaService {

    @Resource
    private IRemoteQuotaRpc remoteQuotaRpc;

    @Override
    public void occupyQuotaAmount(IOrderMain orderMain) {
        log.info("会通过infrastructure层调用资金额度中心的RPC接口，执行预占资金额度动作");
        log.info("这里的逻辑，主要是根据不同业务场景组织资金额度中心RPC的入参，并对返回结果进行处理");

        for (IOrderItem item : orderMain.itemDelegate().getItems()) {
            // 生产环境，看到会批量调用，这里只是演示
            /// rpc  //
            remoteQuotaRpc.doOccupy(item.getItem(), item.getQuantity());
        }
    }
}
