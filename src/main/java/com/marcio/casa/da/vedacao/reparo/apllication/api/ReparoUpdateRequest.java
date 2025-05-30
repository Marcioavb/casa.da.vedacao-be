package com.marcio.casa.da.vedacao.reparo.apllication.api;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@Getter
public class ReparoUpdateRequest {
    private BigDecimal valorComprado;
    private String local;
    private String medidas;
}
