package com.marcio.casa.da.vedacao.reparo.apllication.api;

import com.marcio.casa.da.vedacao.reparo.domain.Reparo;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@ToString
public class ReparoResponse {

    @NotNull
    private String nome;
    private UUID idReparo;
    @NotNull
    private String codigo;
    @NotNull
    private String medidas;
    @NotNull
    private BigDecimal valorComprado;
    @NotNull
    private String local;

    public ReparoResponse(Reparo reparo) {
        this.idReparo = reparo.getIdReparo();
        this.nome = reparo.getNome();
        this.codigo = reparo.getCodigo();
        this.medidas = reparo.getMedidas();
        this.valorComprado = reparo.getValorComprado();
        this.local = reparo.getLocal();
    }
}
