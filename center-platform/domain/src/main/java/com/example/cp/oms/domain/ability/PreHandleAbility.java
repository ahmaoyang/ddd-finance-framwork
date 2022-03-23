package com.example.cp.oms.domain.ability;

import com.example.cp.oms.domain.CoreDomain;
import com.example.cp.oms.spec.ext.IPreHandleExt;
import com.example.cp.oms.spec.model.IOrderMain;
import com.maoyang.enforce.annotation.DomainAbility;
import com.maoyang.enforce.runtime.BaseDomainAbility;

import javax.validation.constraints.NotNull;

/**
 * @Author: maoyang
 * Date: 2022/3/23 14:34
 * @Version:
 * @Description:
 */
@DomainAbility(domain = CoreDomain.CODE, name = "预处理的能力")
public class PreHandleAbility extends BaseDomainAbility<IOrderMain, IPreHandleExt> {


    public void preHandle(@NotNull IOrderMain model) {
        firstExtension(model).preHandle(model);
    }

    @Override
    public IPreHandleExt defaultExtension(IOrderMain model) {
        return null;
    }
}
