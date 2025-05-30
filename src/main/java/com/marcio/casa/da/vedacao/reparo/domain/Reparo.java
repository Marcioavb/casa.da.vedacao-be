package com.marcio.casa.da.vedacao.reparo.domain;


import com.marcio.casa.da.vedacao.reparo.apllication.api.ReparoRequest;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"codigo", "medidas"}, name = "uk_codigo_medidas")
})
public class Reparo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idReparo;
    @NotNull
    private String codigo;
    @NotNull
    private String medidas;
    @NotNull
    private BigDecimal valorComprado;
    @NotNull
    private String local;
    private LocalDateTime dataCadastro;


    public Reparo(ReparoRequest reparoRequest) {

        this.codigo = reparoRequest.getCodigo();
        this.medidas = reparoRequest.getMedidas();
        this.valorComprado = reparoRequest.getValorComprado();
        this.local = reparoRequest.getLocal();
        this.dataCadastro = LocalDateTime.now();
    }

    public void setValorComprado(BigDecimal valorComprado) {
        this.valorComprado = valorComprado;
    }
        public void setLocal(String local) {
            this.local = local;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }
}
