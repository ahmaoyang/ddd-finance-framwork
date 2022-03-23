package com.example.cp.oms.domain.model;

import com.maoyang.enforce.api.RequestProfile;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.domain.model.vo.OrderItemDelegateVO;
import com.example.cp.oms.spec.exception.OrderException;
import com.example.cp.oms.domain.model.vo.ProductDelegateVO;
import com.example.cp.oms.spec.model.IOrderMain;
import com.example.cp.oms.spec.model.vo.IOrderItemDelegate;
import com.example.cp.oms.spec.model.vo.IProductDelegate;

import javax.validation.constraints.NotNull;

/**
 * 注意：没有实现Serializable，因为它不会网络传递，也不会本地文件存储.
 */
@Getter // 注意：没有@Setter，是为了封装，包含订单一致性
@Slf4j
public class OrderMainModel implements IOrderMain {
    private Long id;

    private String source;
    private String customerNo;

    private String orderNo;

    private String externalNo;
    /**
     * API系统入参  (详细查看sdk)
     */
    private RequestProfile requestProfile;

    @Setter
    private String activity;

    @Setter
    private String step;

    private ProductDelegateVO productDelegateVO;
    private OrderItemDelegateVO orderItemDelegateVO;

    @Getter
    private String x1, x2;

    public static OrderMainModel createWith(@NotNull OrderModelCreatorModel creator) throws OrderException {
        log.debug("creating with {}", creator);
        return new OrderMainModel(creator).validate();
    }

    private OrderMainModel(OrderModelCreatorModel creator) {
        this.id = creator.getId();
        this.source = creator.getSource();
        this.customerNo = creator.getCustomerNo();
        this.externalNo = creator.getExternalNo();
        this.requestProfile = creator.getRequestProfile();

        this.productDelegateVO = ProductDelegateVO.createWith(creator);
        this.orderItemDelegateVO = OrderItemDelegateVO.createWith(creator);
    }

    private OrderMainModel validate() throws OrderException {
        // 模型本身的基础校验
        return this;
    }

    @Override
    public void assignOrderNo(Object who, String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String currentStep() {
        return step;
    }

    @Override
    public String currentActivity() {
        return activity;
    }

    @Override
    public boolean isColdChain() {
        return false;
    }

    @Override
    public boolean isB2B() {
        return false;
    }

    @Override
    public void setX1(String x1) {
        this.x1 = x1;
    }

    @Override
    public void setX2(String x2) {
        this.x2 = x2;
    }

    @Override
    public IProductDelegate productDelegate() {
        return productDelegateVO;
    }

    @Override
    public IOrderItemDelegate itemDelegate() {
        return orderItemDelegateVO;
    }

    @Override
    public RequestProfile requestProfile() {
        return requestProfile;
    }

    @Override
    public String customerProvidedOrderNo() {
        return externalNo;
    }

    public String label() {
        return "Order(source=" + source + ", customer=" + customerNo + ")";
    }
}
