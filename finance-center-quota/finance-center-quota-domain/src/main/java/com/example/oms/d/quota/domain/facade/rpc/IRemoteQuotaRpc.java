package com.example.oms.d.quota.domain.facade.rpc;

public interface IRemoteQuotaRpc {

    void doOccupy(String item, Integer quantity);
}
