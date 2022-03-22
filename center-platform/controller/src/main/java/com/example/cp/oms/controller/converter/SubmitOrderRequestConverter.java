package com.example.cp.oms.controller.converter;

import com.example.cp.oms.controller.dto.SubmitOrderRequestDTO;
import com.maoyang.enforce.IBaseTranslator;
import com.example.cp.oms.domain.model.OrderModelCreatorModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubmitOrderRequestConverter extends IBaseTranslator<SubmitOrderRequestDTO, OrderModelCreatorModel> {
    SubmitOrderRequestConverter instance = Mappers.getMapper(SubmitOrderRequestConverter.class);
}
