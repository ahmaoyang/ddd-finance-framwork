package com.example.cp.oms.infra.manager.impl;

import com.example.cp.oms.infra.manager.TransactionManager;
import com.example.cp.oms.infra.manager.TransactionalService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

public class TransactionalServiceImpl implements TransactionalService {

    @Resource
    private TransactionManager transactionManager;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
    public void executeWithTransactional(Execute execute) {
        transactionManager.runInNewTx(()->execute.doExecute());

    }

    @Override
    public <T> T executeWithNewTransactional(ExecuteWithReturn<T> execute) {
        return execute.doExecute();
    }
}
