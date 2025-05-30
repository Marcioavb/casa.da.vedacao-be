package com.marcio.casa.da.vedacao.reparo.apllication.service;

import com.marcio.casa.da.vedacao.reparo.apllication.api.ReparoRequest;
import com.marcio.casa.da.vedacao.reparo.apllication.api.ReparoResponse;
import com.marcio.casa.da.vedacao.reparo.apllication.api.ReparoUpdateRequest;
import com.marcio.casa.da.vedacao.reparo.apllication.repository.ReparoRepository;
import com.marcio.casa.da.vedacao.reparo.domain.Reparo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log4j2
@Service
public class ReparoApllicationService implements ReparoService {
    private final ReparoRepository reparoRepository;
    @Override
    public ReparoResponse cadatraReparo(ReparoRequest reparoRequest) {
        log.info("[inicia] ReparoApllicationService - cadatraReparo");
        Reparo reparo = reparoRepository.salva(new Reparo(reparoRequest));
        log.info("[finaliza] ReparoApllicationService - cadatraReparo");
        return new ReparoResponse(reparo);
    }

    @Override
    public ReparoResponse buscaPorCodigo(String codigo) {
        log.info("[inicia] ReparoApllicationService - buscaPorCodigo");
        Reparo reparo = reparoRepository.buscaPorCodigo(codigo);
        log.info("[finaliza] ReparoApllicationService - buscaPorCodigo");
        return new ReparoResponse(reparo);
    }

    @Override
    public List<ReparoResponse> buscaPorMedidas(String medidas) {
        log.info("[inicia] ReparoApllicationService - buscaPorMedidas");
        List<Reparo> reparos = reparoRepository.buscaPorMedidas(medidas);
        log.info("[finaliza] ReparoApllicationService - buscaPorMedidas");
        return reparos.stream()
                .map(ReparoResponse::new)
                .collect(Collectors.toList());
    }

    @Override
    public ReparoResponse atualizaReparoPorCodigo(String codigo, ReparoUpdateRequest reparoUpdateRequest) {
        log.info("[inicia] ReparoApllicationService - atualizaReparoPorCodigo");

        // Busca o reparo existente
        Reparo reparo = reparoRepository.buscaPorCodigo(codigo);

        // Atualiza apenas os campos fornecidos
        if (reparoUpdateRequest.getValorComprado() != null) {
            reparo.setValorComprado(reparoUpdateRequest.getValorComprado());
        }

        if (reparoUpdateRequest.getLocal() != null) {
            reparo.setLocal(reparoUpdateRequest.getLocal());
        }

        // Adicione outros campos que podem ser atualizados
        if (reparoUpdateRequest.getMedidas() != null) {
            reparo.setMedidas(reparoUpdateRequest.getMedidas());
        }

        // Salva as alterações
        Reparo reparoAtualizado = reparoRepository.salva(reparo);

        log.info("[finaliza] ReparoApllicationService - atualizaReparoPorCodigo");
        return new ReparoResponse(reparoAtualizado);
    }

    @Override
    public void deletaReparoPorCodigo(String codigo) {
        log.info("[inicia] ReparoApllicationService - deletaReparoPorCodigo");
        Reparo reparo = reparoRepository.buscaPorCodigo(codigo);
        reparoRepository.deletaReparo(reparo);
        log.info("[finaliza] ReparoApllicationService - deletaReparoPorCodigo");
    }

}
