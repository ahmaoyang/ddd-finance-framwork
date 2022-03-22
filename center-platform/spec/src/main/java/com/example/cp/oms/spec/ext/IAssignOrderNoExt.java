package com.example.cp.oms.spec.ext;

import com.maoyang.enforce.ext.IDomainExtension;
import com.example.cp.oms.spec.model.IOrderMain;

import javax.validation.constraints.NotNull;

/**
 * 生成、分配订单号扩展点.
 */
public interface IAssignOrderNoExt extends IDomainExtension {

    void assignOrderNo(@NotNull IOrderMain model);

}
