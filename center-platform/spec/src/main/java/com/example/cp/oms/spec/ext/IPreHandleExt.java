package com.example.cp.oms.spec.ext;

import com.example.cp.oms.spec.model.IOrderMain;
import com.maoyang.enforce.ext.IDomainExtension;

import javax.validation.constraints.NotNull;

/**
 *
 * @Author: maoyang
 * Date: 2022/3/23 14:35
 * @Version:
 * @Description:
 */
public interface IPreHandleExt extends IDomainExtension {
    void preHandle(@NotNull IOrderMain model);

}
