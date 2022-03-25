package com.example.cp.oms.infra.manager;/**
 * @author maoyang
 * @date 2022/03/03
 */

import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author guangya.lgy@alibaba-inc.com
 * @date 2020-03-03
 **/
public interface TransactionManager {

    /**
     * 获取事务模板
     * @return
     */
    TransactionTemplate getTransactionTemplate();

    /**
     * 执行事务，无返回值
     * @param runnable
     */
    void run(TxRunnable runnable);
    /**
     * 执行事务，有返回值
     * @param <T>
     * @param callable
     * @return
     */
    <T> T call(TxCallable<T> callable);
    
    /**
     * 新建事务执行，采用PROPAGATION_REQUIRES_NEW
     * @param runnable
     */
    void runInNewTx(TxRunnable runnable);
    /**
     * 新建事务执行，采用PROPAGATION_REQUIRES_NEW
     *
     */
    <T> T callInNewTx(TxCallable<T> callable);
}