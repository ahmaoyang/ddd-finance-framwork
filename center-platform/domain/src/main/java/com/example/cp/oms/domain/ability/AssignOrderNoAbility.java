package com.example.cp.oms.domain.ability;

import com.maoyang.enforce.annotation.DomainAbility;
import com.maoyang.enforce.runtime.BaseDomainAbility;
import com.example.cp.oms.domain.CoreDomain;
import com.example.cp.oms.domain.ability.extension.DefaultAssignOrderNoExt;
import com.example.cp.oms.spec.ext.IAssignOrderNoExt;
import com.example.cp.oms.spec.model.IOrderMain;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 说明:能力继承扩展点 实现（所有的能力都是如此）
 */
@DomainAbility(domain = CoreDomain.CODE, name = "分配单号的能力")
public class AssignOrderNoAbility extends BaseDomainAbility<IOrderMain, IAssignOrderNoExt> {

    @Resource
    private DefaultAssignOrderNoExt defaultAssignOrderNoExt;

    public void assignOrderNo(@NotNull IOrderMain model) {
        firstExtension(model).assignOrderNo(model);
    }

    @Override
    public IAssignOrderNoExt defaultExtension(@NotNull IOrderMain model) {
        return defaultAssignOrderNoExt;
    }
}
