package com.marcio.casa.da.vedacao.reparo.infra;

import com.marcio.casa.da.vedacao.reparo.domain.Reparo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpringDataJPARepository extends JpaRepository <Reparo, UUID> {
    // Busca por partes do código usando função nativa do PostgreSQL
    @Query(value = "SELECT * FROM reparo r WHERE " +
            ":codigo = ANY(STRING_TO_ARRAY(REGEXP_REPLACE(r.codigo, '\\s+', '', 'g'), '/'))",
            nativeQuery = true)
    List<Reparo> findByParteDoCodigo(@Param("codigo") String codigo);

    Optional<Reparo> findByCodigo(String codigo);
    List<Reparo> findByMedidasContaining(String medidas);
}
