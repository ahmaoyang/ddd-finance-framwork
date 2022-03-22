package com.example.cp.oms.domain.ability;


import com.example.cp.oms.domain.model.OrderMainModel;
import com.maoyang.enforce.annotation.DomainAbility;
import com.maoyang.enforce.runtime.BaseDomainAbility;
import com.example.cp.oms.domain.CoreDomain;
import com.example.cp.oms.spec.ext.IReviseStepsExt;

import javax.validation.constraints.NotNull;
import java.util.List;

@DomainAbility(domain = CoreDomain.CODE)
public class ReviseStepsAbility extends BaseDomainAbility<OrderMainModel, IReviseStepsExt> {

    public List<String> revisedSteps(@NotNull OrderMainModel model) {
        //300ms 作为执行的超时时间
        return firstExtension(model, 300).reviseSteps(model);
    }

    @Override
    public IReviseStepsExt defaultExtension(@NotNull OrderMainModel model) {
        return null;
    }
}
