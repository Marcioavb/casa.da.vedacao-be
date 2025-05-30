package com.marcio.casa.da.vedacao.reparo.apllication.repository;

import com.marcio.casa.da.vedacao.reparo.domain.Reparo;

import java.util.List;

public interface ReparoRepository {
    Reparo salva(Reparo reparo);
    Reparo buscaPorCodigo(String codigo);

    List<Reparo> buscaPorMedidas(String medidas);
    void deletaReparo(Reparo reparo);
}
