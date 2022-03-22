package com.example.cp.oms.domain.ability;


import com.maoyang.enforce.annotation.DomainAbility;
import com.maoyang.enforce.ext.IModelAttachmentExt;
import com.maoyang.enforce.runtime.BaseDomainAbility;
import com.example.cp.oms.domain.CoreDomain;
import com.example.cp.oms.spec.model.IOrderMain;

import javax.validation.constraints.NotNull;

@DomainAbility(domain = CoreDomain.CODE)
public class CustomModelAbility extends BaseDomainAbility<IOrderMain, IModelAttachmentExt> {

    public void explain(@NotNull IOrderMain model) {
        firstExtension(model).explain(model.requestProfile(), model);
    }

    @Override
    public IModelAttachmentExt defaultExtension(IOrderMain model) {
        return null;
    }
}
