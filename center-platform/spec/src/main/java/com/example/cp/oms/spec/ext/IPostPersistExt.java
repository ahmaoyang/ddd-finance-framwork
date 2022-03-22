package com.example.cp.oms.spec.ext;

import com.maoyang.enforce.ext.IDomainExtension;
import com.example.cp.oms.spec.model.IOrderMain;

import javax.validation.constraints.NotNull;

/**
 * 落库后的处理扩展点.
 */
public interface IPostPersistExt extends IDomainExtension {

    void afterPersist(@NotNull IOrderMain model);
}
