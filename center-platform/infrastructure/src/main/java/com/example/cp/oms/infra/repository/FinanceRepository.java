package com.example.cp.oms.infra.repository;

import com.example.cp.oms.infra.dao.OrderItemDao;
import com.example.cp.oms.infra.manager.IOrderManager;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.domain.Interface.repository.IFinanceRepository;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.example.cp.oms.domain.model.OrderModelCreatorModel;
import com.example.cp.oms.infra.dao.OrderMainDao;
import com.example.cp.oms.infra.po.OrderItemData;
import com.example.cp.oms.infra.po.OrderMainData;
import com.example.cp.oms.infra.converter.Data2Model;
import com.example.cp.oms.infra.converter.Model2Data;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
@Slf4j
public class FinanceRepository implements IFinanceRepository {

    @Resource
    private IOrderManager orderManager;

    @Resource
    private OrderItemDao orderItemDao;

    @Resource
    private OrderMainDao orderMainDao;

    /**
     * 插入
     * @param orderModel
     */
    @Override
    public void insert(@NotNull OrderMainModel orderModel) {
        log.info("落库：{}", orderModel);

        if (true) {
            return;
        }

        OrderMainData orderMainData = Model2Data.instance.translate(orderModel);
        orderManager.insert(orderMainData);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderMainModel getOrder(@NotNull Long orderId) {
        // 数据库里拿出主档、明细档数据
        OrderMainData orderMainData = orderMainDao.getById(orderId);
        List<OrderItemData> orderItemDataList = orderItemDao.itemsOfOrder(orderId);

        // 通过MapStruct转换为creator这个契约对象，再创建领域模型
        OrderModelCreatorModel creator = Data2Model.instance.translate(orderMainData, orderItemDataList);
        return OrderMainModel.createWith(creator);
    }

}
