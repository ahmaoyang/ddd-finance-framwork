package com.example.cp.oms.infra.converter;

import com.example.cp.oms.domain.model.OrderModelCreatorModel;
import com.example.cp.oms.infra.po.OrderItemData;
import com.example.cp.oms.infra.po.OrderMainData;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface Data2Model {

    Data2Model instance = Mappers.getMapper(Data2Model.class);

    OrderModelCreatorModel translate(OrderMainData orderMainData, @Context List<OrderItemData> orderItemData);
}
