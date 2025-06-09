package com.marcio.casa.da.vedacao.reparo.infra;

import com.marcio.casa.da.vedacao.handler.APIException;
import com.marcio.casa.da.vedacao.reparo.apllication.repository.ReparoRepository;
import com.marcio.casa.da.vedacao.reparo.domain.Reparo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Repository
@Log4j2
public class ReparoinfraRepository implements ReparoRepository {
    private final SpringDataJPARepository springDataJPARepository;

    @Override
    public Reparo salva(Reparo reparo) {
        log.info("[inicia] ReparoinfraRepository - salva");
        Reparo reparoSalvo = springDataJPARepository.save(reparo);
        log.info("[finaliza] ReparoinfraRepository - salva");
        return reparoSalvo;
    }

    @Override
    public Reparo buscaPorCodigo(String codigo) {
        log.info("[inicia] ReparoinfraRepository - buscaPorCodigo");
        String codigoLimpo = codigo.replaceAll("\\s+", "").trim();

        // 1. Tenta busca exata
        Optional<Reparo> reparoExato = springDataJPARepository.findByCodigo(codigoLimpo);
        if (reparoExato.isPresent()) {
            return reparoExato.get();
        }

        // 2. Busca por partes do código
        List<Reparo> reparos = springDataJPARepository.findByParteDoCodigo(codigoLimpo);

        // 3. Filtra para encontrar o registro onde a parte buscada aparece PRIMEIRO
        Reparo reparo = reparos.stream()
                .filter(r -> {
                    String[] partes = r.getCodigo().split("/");
                    String primeiraParte = partes[0].replaceAll("\\s+", "");
                    return primeiraParte.equals(codigoLimpo);
                })
                .findFirst()
                .orElse(reparos.stream().findFirst()
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,
                                "Nenhum reparo encontrado para o código: " + codigo)));

        log.info("[finaliza] ReparoinfraRepository - buscaPorCodigo");
        return reparo;
    }

    @Override
    public List<Reparo> buscaPorMedidas(String medidas) {
        log.info("[inicia] ReparoinfraRepository - buscaPorMedidas");
        // Busca contendo a medida em qualquer parte do texto
        List<Reparo> reparos = springDataJPARepository.findByMedidasContaining(medidas);

        if(reparos.isEmpty()) {
            throw APIException.build(HttpStatus.NOT_FOUND,
                    "Nenhum reparo encontrado contendo a medida: " + medidas);
        }

        log.info("[finaliza] ReparoinfraRepository - buscaPorMedidas");
        return reparos;
    }
    @Override
    public void deletaReparo(Reparo reparo) {
        log.info("[inicia] ReparoinfraRepository - deletaReparo");
        springDataJPARepository.delete(reparo);
        log.info("[finaliza] ReparoinfraRepository - deletaReparo");
    }

}
