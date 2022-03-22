package com.example.cp.oms.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CancelOrderRequestDTO implements Serializable {
    private static final long serialVersionUID = 870061998490977022L;

    @NotNull
    private String orderNo;
}
