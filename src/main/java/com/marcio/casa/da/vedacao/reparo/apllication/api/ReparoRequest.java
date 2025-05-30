package com.marcio.casa.da.vedacao.reparo.apllication.api;

import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@ToString
public class ReparoRequest {
    @NotNull
    private String codigo;
    @NotNull
    private String medidas;
    @NotNull
    private BigDecimal valorComprado;
    @NotNull
    private String local;
}
