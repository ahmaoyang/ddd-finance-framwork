package com.example.cp.oms.infra.converter;

import com.maoyang.enforce.IBaseTranslator;
import com.example.cp.oms.infra.po.OrderMainData;
import com.example.cp.oms.domain.model.OrderMainModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        unmappedSourcePolicy = ReportingPolicy.WARN,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        typeConversionPolicy = ReportingPolicy.ERROR
)
public interface Model2Data extends IBaseTranslator<OrderMainModel, OrderMainData> {

    Model2Data instance = Mappers.getMapper(Model2Data.class);

    @Override
    OrderMainData translate(OrderMainModel orderModel);
}
