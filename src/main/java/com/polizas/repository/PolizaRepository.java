package com.polizas.repository;

import com.polizas.model.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PolizaRepository {
    List<Poliza> findByTipoAndEstado(String tipo, String estado);
}
