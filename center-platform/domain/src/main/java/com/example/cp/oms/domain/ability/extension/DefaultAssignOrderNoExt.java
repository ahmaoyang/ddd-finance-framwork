package com.example.cp.oms.domain.ability.extension;

import com.example.cp.oms.spec.exception.OrderErrorReason;
import com.example.cp.oms.spec.exception.OrderException;
import com.maoyang.enforce.annotation.Extension;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.domain.specification.ProductNotEmptySpec;
import com.example.cp.oms.spec.ext.IAssignOrderNoExt;
import com.example.cp.oms.spec.model.IOrderMain;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 扩展点 进行的产品验证
 */
@Extension(code = IAssignOrderNoExt.DefaultCode, value = "defaultAssignOrderNoExt")
@Slf4j
public class DefaultAssignOrderNoExt implements IAssignOrderNoExt {

    @Resource
    private ProductNotEmptySpec productNotEmptySpec;

    @Override
    public void assignOrderNo(@NotNull IOrderMain model) {
        if (!productNotEmptySpec.satisfiedBy(model)) {
            log.warn("Spec:{} not satisfied", productNotEmptySpec);
            throw new OrderException(OrderErrorReason.SubmitOrder.ProductEmpty);
        }

    }
}
