package com.example.cp.oms.domain.model;

import com.maoyang.enforce.api.RequestProfile;
import com.maoyang.enforce.model.IDomainModelCreator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.example.cp.oms.domain.model.vo.OrderItemVO;
import com.example.cp.oms.domain.model.vo.ProductItemVO;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderModelCreatorModel implements IDomainModelCreator {
    private Long id;

    private RequestProfile requestProfile;

    /**
     * 账单来源
     */
    private String source;

    /**
     * 客户编号.
     */
    private String customerNo;

    /**
     * 客户携带的外部单号.
     */
    private String externalNo;

    private List<OrderItemVO> orderItemVOS;

    private List<ProductItemVO> productItemVOS;
}
