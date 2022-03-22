package com.example.cp.oms.controller;

import com.example.cp.oms.controller.converter.SubmitOrderRequestConverter;
import com.example.cp.oms.controller.dto.SubmitOrderRequestDTO;
import com.maoyang.enforce.api.RequestProfile;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.domain.model.OrderMainModel;
import com.example.cp.oms.domain.model.OrderModelCreatorModel;
import com.example.cp.oms.domain.service.SubmitBillOrderService;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class financeController {

    @Autowired
    private SubmitBillOrderService submitBillOrderService;

    // 测试
    // curl -XPOST localhost:9090/billOrder?type=isv
    @RequestMapping(value = "/billOrder", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String submitOrder(@RequestParam(required = false) String type) {
        if (type == null) {
            type = "ISV"; // ISV by default
        }

        log.info("type={}", type);

        // DTO 转换为 domain model，通过creator保护、封装domain model
        // 具体项目使用MapStruct会更方便,为了测试 手写了
        RequestProfile requestProfile = new RequestProfile();
        requestProfile.setTraceId(String.valueOf(System.nanoTime()));

        // 联系人号码是前台场景才会需要的字段需要在这里添加
        requestProfile.getExt().put("contact_no", "139100988343");
        MDC.put("tid", requestProfile.getTraceId()); // session scope log identifier

        // 这里手工创建一个模拟下单的请求
        OrderModelCreatorModel creator = new OrderModelCreatorModel();
        creator.setRequestProfile(requestProfile);
        creator.setSource(type);
        creator.setCustomerNo("carZoon0012");
        creator.setExternalNo("20200987655");
        OrderMainModel model = OrderMainModel.createWith(creator);
        // 调用domain service完成该
        submitBillOrderService.submit(model);
        // 业务前台的下单执行步骤：
        // SerializableIsolationExt -> DecideStepsExt -> BasicStep(PresortExt) -> PersistStep(AssignOrderNoExt, CustomModelAbility) -> BroadcastStep
        return "Order finished!";
    }

}
