package com.example.cp.oms.infra.manager;

public interface TransactionalService {

    void executeWithTransactional(Execute execute);

    <T>T executeWithNewTransactional(ExecuteWithReturn<T> execute);


    interface Execute{
        void doExecute();
    }

    interface ExecuteWithReturn <T>{
        T doExecute();
    }
}
