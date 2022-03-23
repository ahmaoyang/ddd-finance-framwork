package com.example.cp.oms.domain.specification;

import com.maoyang.enforce.annotation.Specification;
import com.maoyang.enforce.specification.ISpecification;
import com.maoyang.enforce.specification.Notification;
import com.example.cp.oms.spec.model.IOrderMain;

/***
 * 约束类（注意：这里只是举一个例子，对于不同的约束可以创建不同的类）
 */
@Specification("产品项不能空")
public class ProductNotEmptySpec implements ISpecification<IOrderMain> {

    @Override
    public boolean satisfiedBy(IOrderMain candidate, Notification notification) {
        if (candidate.productDelegate() == null || candidate.productDelegate().getProducts() == null || candidate.productDelegate().getProducts().isEmpty()) {
            return false;
        }

        return true;
    }
}
