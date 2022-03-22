package com.example.oms.d.quota.infra.rpc;

import com.example.oms.d.quota.domain.facade.rpc.IRemoteQuotaRpc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RemoteQuotaRpc implements IRemoteQuotaRpc {

    @Override
    public void doOccupy(String item, Integer quantity) {
        log.info("RPC调用资金额度中心系统，返回值是OK!"+"item:{},quantity:{}",item,quantity);
    }
}
