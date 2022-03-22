package com.example.bp.oms.isv;

import com.maoyang.enforce.annotation.Partner;
import com.maoyang.enforce.ext.IIdentityResolver;
import lombok.extern.slf4j.Slf4j;
import com.example.cp.oms.spec.model.IOrderMain;

import org.springframework.beans.factory.DisposableBean;

/**
 * 业务前台（中台模块以外的处理）
 */
@Partner(code = IsvPartner.CODE, name = "ISV业务前台")
@Slf4j
public class IsvPartner implements IIdentityResolver<IOrderMain>, DisposableBean {
    public static final String CODE = "ISV";

    public IsvPartner() {
        log.info("ISV new instanced, cl:{}", this.getClass().getClassLoader());
    }

    @Override
    public boolean match(IOrderMain model) {
        if (model.getSource() == null) {
            return false;
        }

        return model.getSource().equalsIgnoreCase(CODE);
    }

    @Override
    public void destroy() throws Exception {
        log.warn("IsvPartner destroyed");
    }
}
