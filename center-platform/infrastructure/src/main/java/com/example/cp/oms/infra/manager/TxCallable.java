package com.example.cp.oms.infra.manager;
/**
* @author jameszhang.zjj
* @version 创建时间：Mar 7, 2020 9:32:47 AM
* 
*/
public interface TxCallable<T> {

    T call();
}
