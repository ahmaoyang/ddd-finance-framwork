package com.example.cp.oms.domain.model.vo;

import com.example.cp.oms.domain.model.OrderModelCreatorModel;
import com.example.cp.oms.spec.model.vo.IProduct;
import com.example.cp.oms.spec.model.vo.IProductDelegate;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ProductDelegateVO implements IProductDelegate {

    private List<ProductItemVO> productItemVOS;

    private ProductDelegateVO() {
    }

    public static ProductDelegateVO createWith(@NotNull OrderModelCreatorModel creator) {
        ProductDelegateVO delegate = new ProductDelegateVO();
        List<ProductItemVO> productItemVOList = new ArrayList<>();
        //在这模拟一个空产品对象做测试
        productItemVOList.add(new ProductItemVO());
        delegate.productItemVOS = productItemVOList;
        return delegate;
    }

    @Override
    public List<? extends IProduct> getProducts() {
        return productItemVOS;
    }
}
