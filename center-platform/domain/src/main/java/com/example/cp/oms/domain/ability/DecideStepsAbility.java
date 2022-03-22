package com.example.cp.oms.domain.ability;

import com.maoyang.enforce.annotation.DomainAbility;
import com.maoyang.enforce.runtime.BaseDecideStepsAbility;
import com.example.cp.oms.domain.CoreDomain;
import com.example.cp.oms.spec.DomainAbilities;
import com.example.cp.oms.spec.model.IOrderMain;

@DomainAbility(domain = CoreDomain.CODE, name = "动态决定领域步骤的能力", tags = DomainAbilities.decideSteps)
public class DecideStepsAbility extends BaseDecideStepsAbility<IOrderMain> {
}
