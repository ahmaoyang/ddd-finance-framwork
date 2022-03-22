package com.example.cp.oms.spec.ext;

import com.maoyang.enforce.ext.IDomainExtension;
import com.example.cp.oms.spec.model.IOrderMain;

import javax.validation.constraints.NotNull;

/**
 * 敏感词信息获取.
 */
public interface ISensitiveWordsExt extends IDomainExtension {

    String[] extract(@NotNull IOrderMain model);
}
