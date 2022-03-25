package com.example.cp.oms.infra.manager.impl;

import com.example.cp.oms.infra.manager.TransactionManager;
import com.example.cp.oms.infra.manager.TxCallable;
import com.example.cp.oms.infra.manager.TxRunnable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author lgy
 * @date 2020/03/03
 */
@Component("TransactionTemplate")
public class TransactionTemplateImpl implements TransactionManager {

    @Resource(name = "myTransactionTemplate")
    private TransactionTemplate myTransactionTemplate;

    @Override
    public TransactionTemplate getTransactionTemplate() {
        /*
         * TODO 当前默认返回oracle事务模板， 后面根据配置返回oracle还是mysql
         */
        return myTransactionTemplate;
    }

    @Override
    public void run(TxRunnable runnable) {
        myTransactionTemplate.execute(transactionStatus -> {
            runnable.run();
            return Boolean.TRUE;
        });
    }

    @Override
    public <T> T call(TxCallable<T> callable) {
        return myTransactionTemplate.execute(transactionStatus -> {
            return callable.call();
        });
    }

    @Override
    public void runInNewTx(TxRunnable runnable) {
        TransactionDefinition def = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        PlatformTransactionManager manager = myTransactionTemplate.getTransactionManager();
        TransactionStatus transactionStatus = manager.getTransaction(def);
        try {
            runnable.run();
            manager.commit(transactionStatus);
        } catch (Exception ex) {
            manager.rollback(transactionStatus);
            throw ex;
        }
    }

    @Override
    public <T> T callInNewTx(TxCallable<T> callable) {
        TransactionDefinition def = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        PlatformTransactionManager manager = myTransactionTemplate.getTransactionManager();
        TransactionStatus transactionStatus = manager.getTransaction(def);
        T result = null;
        try {
            result = callable.call();
            manager.commit(transactionStatus);
        } catch (Exception ex) {
            manager.rollback(transactionStatus);
            throw ex;
        }
        return result;
    }
}