package com.example.cp.oms.spec.ext;

import com.maoyang.enforce.ext.IDomainExtension;
import com.example.cp.oms.spec.model.IOrderMain;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface IReviseStepsExt extends IDomainExtension {

    List<String> reviseSteps(@NotNull IOrderMain model);

}
