package com.polizas.repository;

import com.polizas.model.Riesgo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RiesgoRepository {
    List<Riesgo> findByPolizaId(Long polizaId);
    long countByPolizaId(Long polizaId);
}
