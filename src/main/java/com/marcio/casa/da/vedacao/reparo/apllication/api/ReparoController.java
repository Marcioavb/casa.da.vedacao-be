package com.marcio.casa.da.vedacao.reparo.apllication.api;

import com.marcio.casa.da.vedacao.reparo.apllication.service.ReparoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Log4j2
@RestController
public class ReparoController implements ReparoApi {
    private final ReparoService reparoService;

    @Override
    public ReparoResponse cadastraReparo(ReparoRequest reparoRequest) {
        log.info("[inicia] ReparoController - cadastraReparo");
        ReparoResponse reparoCadastrado = reparoService.cadatraReparo(reparoRequest);
        log.info("[finaliza] ReparoController - cadastraReparo");
        return reparoCadastrado;
    }

    @Override
    public ReparoResponse buscaPorCodigo(String codigo) {
        log.info("[inicia] ReparoController - buscaPorCodigo");
        ReparoResponse reparo = reparoService.buscaPorCodigo(codigo);
        log.info("[finaliza] ReparoController - buscaPorCodigo");
        return reparo;
    }

    @Override
    public List<ReparoResponse> buscaPorMedidas(@RequestParam String medidas) {
        log.info("[inicia] ReparoController - buscaPorMedidas");
        List<ReparoResponse> reparos = reparoService.buscaPorMedidas(medidas);
        log.info("[finaliza] ReparoController - buscaPorMedidas");
        return reparos;
    }
    @Override
    public ReparoResponse atualizaReparoPorCodigo(String codigo, ReparoUpdateRequest reparoUpdateRequest) {
        log.info("[inicia] ReparoController - atualizaReparoPorCodigo");
        ReparoResponse response = reparoService.atualizaReparoPorCodigo(codigo, reparoUpdateRequest);
        log.info("[finaliza] ReparoController - atualizaReparoPorCodigo");
        return response;
    }

    @Override
    public void deletaReparoPorCodigo(String codigo) {
        log.info("[inicia] ReparoController - deletaReparoPorCodigo");
        reparoService.deletaReparoPorCodigo(codigo);
        log.info("[finaliza] ReparoController - deletaReparoPorCodigo");
    }

}
