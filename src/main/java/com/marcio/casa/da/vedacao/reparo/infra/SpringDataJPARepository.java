package com.marcio.casa.da.vedacao.reparo.infra;

import com.marcio.casa.da.vedacao.reparo.domain.Reparo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpringDataJPARepository extends JpaRepository <Reparo, UUID> {
    Optional<Reparo> findByCodigo(String codigo);
    List<Reparo> findByMedidasContaining(String medidas);
}
