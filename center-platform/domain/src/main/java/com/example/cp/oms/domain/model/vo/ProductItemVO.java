package com.example.cp.oms.domain.model.vo;

import lombok.Data;
import com.example.cp.oms.spec.model.vo.IProduct;

/**
 * 订单里包含的增值服务产品.
 */
@Data
public class ProductItemVO implements IProduct {
    private String code;

    void setCode(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return code;
    }
}
