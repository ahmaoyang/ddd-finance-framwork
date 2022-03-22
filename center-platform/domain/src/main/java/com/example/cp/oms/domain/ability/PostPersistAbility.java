package com.example.cp.oms.domain.ability;


import com.maoyang.enforce.annotation.DomainAbility;
import com.maoyang.enforce.runtime.BaseDomainAbility;
import com.example.cp.oms.domain.CoreDomain;
import com.example.cp.oms.spec.ext.IPostPersistExt;
import com.example.cp.oms.spec.model.IOrderMain;

import javax.validation.constraints.NotNull;

/**
 * 落库后的扩展 能力点
 */
@DomainAbility(domain = CoreDomain.CODE, name = "落库后的扩展能力")
public class PostPersistAbility extends BaseDomainAbility<IOrderMain, IPostPersistExt> {

    public void afterPersist(@NotNull IOrderMain model) {
        firstExtension(model).afterPersist(model);
    }

    @Override
    public IPostPersistExt defaultExtension(@NotNull IOrderMain model) {
        return null;
    }
}
