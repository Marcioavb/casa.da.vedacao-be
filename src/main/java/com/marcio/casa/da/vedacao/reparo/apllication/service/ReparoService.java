package com.marcio.casa.da.vedacao.reparo.apllication.service;

import com.marcio.casa.da.vedacao.reparo.apllication.api.ReparoRequest;
import com.marcio.casa.da.vedacao.reparo.apllication.api.ReparoResponse;
import com.marcio.casa.da.vedacao.reparo.apllication.api.ReparoUpdateRequest;

import java.util.List;

public interface ReparoService {
    ReparoResponse cadatraReparo(ReparoRequest reparoRequest);
    ReparoResponse buscaPorCodigo(String codigo);

    List<ReparoResponse> buscaPorMedidas(String medidas);
    void deletaReparoPorCodigo(String codigo);
    ReparoResponse atualizaReparoPorCodigo(String codigo, ReparoUpdateRequest reparoRequest);
}
