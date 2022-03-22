package com.example.cp.oms.infra.resource;

import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.spec.resource.IBillRpc;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BillRpc implements IBillRpc {
    @Override
    public boolean preRefund(Integer money) {
        // 这里仅仅是mock

        //真实条件下这里调用 rpc 接口
        log.info("预还款：{}", money);
        return true;
    }
}
