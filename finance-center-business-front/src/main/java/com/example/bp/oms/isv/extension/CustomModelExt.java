package com.example.bp.oms.isv.extension;

import com.example.bp.oms.isv.IsvPartner;
import com.example.bp.oms.isv.aop.AutoLogger;
import com.maoyang.enforce.annotation.Extension;
import com.maoyang.enforce.api.ApiResult;
import com.maoyang.enforce.api.RequestProfile;
import com.maoyang.enforce.ext.IModelAttachmentExt;
import lombok.extern.slf4j.Slf4j;

import com.example.cp.oms.spec.exception.OrderErrorReason;
import com.example.cp.oms.spec.exception.OrderException;
import com.example.cp.oms.spec.model.IOrderMain;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * 在业务模块自定义的扩展点
 */
@Slf4j
@Extension(code = IsvPartner.CODE, value = "isvCustomModel", name = "前台的订单个性化字段处理逻辑")
public class CustomModelExt implements IModelAttachmentExt<IOrderMain> {
    private static final String KEY_STATION_NO = "contact_no";

    @Override
    @AutoLogger
    public void explain(@NotNull RequestProfile source, @NotNull IOrderMain target) {
        // 入参里预留了扩展属性
        Map<String, String> ext = source.getExt();
        //联系人号码，是个性化字段，中台只存储，不负责逻辑：前台来处理逻辑，并告诉中台存储到哪些已预留的字段
        String contactNo = ext.get(KEY_STATION_NO);
        if (contactNo == null || contactNo.length() < 5) {
            // 针对该字段的特有业务逻辑
            throw new OrderException(OrderErrorReason.Custom.Custom).withCustom("109");
        }

        // 落到预留字段上,把它保存到x2字段
        // 注意：预留字段也可能保存复杂对象,例如json
        log.info("账单联系人号码：{}，保存到x2字段", contactNo);
        target.setX2(contactNo);
    }

    @Override
    public void explain(@NotNull IOrderMain model) {
    }

    @Override
    public void render(@NotNull IOrderMain source, @NotNull ApiResult target) {
    }
}
