package com.example.bp.oms.isv.extension;

import com.example.bp.oms.isv.IsvPartner;
import com.example.bp.oms.isv.aop.AutoLogger;
import com.maoyang.enforce.annotation.Extension;
import com.maoyang.enforce.ext.IDecideStepsExt;
import com.maoyang.enforce.model.IDomainModel;
import com.example.cp.oms.spec.Steps;
import com.example.cp.oms.spec.resource.IBillRpc;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 *
 */
@Extension(code = IsvPartner.CODE, name = "对操作所有流程的编排", value = "isvDecideStepsExt")
public class DecideStepsExt implements IDecideStepsExt {
    private static final List<String> emptySteps = Collections.emptyList();

    // 通过RPC调用账单服务
    @Resource
    private IBillRpc iBillRpc;

    @Override
    @AutoLogger
    public List<String> decideSteps(@NotNull IDomainModel model, @NotNull String activityCode) {
        iBillRpc.preRefund(89);
        List<String> steps = stepsRegistry.get(activityCode);
        if (steps == null) {
            return emptySteps;
        }
        return steps;
    }

    // 所有流程步骤注册表 {activityCode, stepCodeList}
    private static Map<String, List<String>> stepsRegistry = new HashMap<>();

    /**
     *前台对所有流程的编排 （目前举了两个例子 提交订单和取消订单）
     */
    static {

        //提交订单(例如：涉及提交订单的所有流程 编排 步骤 在此添加 )
        List<String> submitOrderSteps = new ArrayList<>();
        stepsRegistry.put(Steps.SubmitOrder.Activity, submitOrderSteps);
        submitOrderSteps.add(Steps.SubmitOrder.BasicStep);
        submitOrderSteps.add(Steps.SubmitOrder.PresortStep);
        submitOrderSteps.add(Steps.SubmitOrder.ProductStep);
        submitOrderSteps.add(Steps.SubmitOrder.QuotaStep);
        submitOrderSteps.add(Steps.SubmitOrder.PersistStep);
        submitOrderSteps.add(Steps.SubmitOrder.BroadcastStep);
        //取消订单
        List<String> cancelOrderSteps = new ArrayList<>();
        stepsRegistry.put(Steps.CancelOrder.Activity, cancelOrderSteps);
        cancelOrderSteps.add(Steps.CancelOrder.BasicStep);
        cancelOrderSteps.add(Steps.CancelOrder.StateStep);
    }
}
