package com.polizas.repository;

import com.polizas.model.Poliza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolizaRepository extends JpaRepository<Poliza, Long> {
    List<Poliza> findByTipoAndEstado(String tipo, String estado);
}
