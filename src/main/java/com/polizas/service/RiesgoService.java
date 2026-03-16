package com.polizas.service;

import com.polizas.model.Poliza;
import com.polizas.model.Riesgo;
import com.polizas.repository.PolizaRepository;
import com.polizas.repository.RiesgoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiesgoService {
    private final RiesgoRepository riesgoRepository;
    private final PolizaRepository polizaRepository;

    public RiesgoService(RiesgoRepository riesgoRepository, PolizaRepository polizaRepository) {
        this.riesgoRepository = riesgoRepository;
        this.polizaRepository = polizaRepository;
    }

    public List<Riesgo> obtenerRiesgos(Long polizaId) {
        return riesgoRepository.findByPolizaId(polizaId);
    }

    public Riesgo agregarRiesgo(Long polizaId) {
        Poliza poliza = polizaRepository.findById(polizaId).orElseThrow();

        if(poliza.getTipo().equals("INDIVIDUAL") && riesgoRepository.countByPolizaId(polizaId) >= 1) {
            throw new RuntimeException("La póliza individual solo puede tener un riesgo");
        }
        Riesgo riesgo = new Riesgo();
        riesgo.setPolizaId(polizaId);
        riesgo.setEstado("ACTIVO");

        return riesgoRepository.save(riesgo);
    }

    public void cancelarRiesgo(Long riesgoId) {
        Riesgo riesgo = riesgoRepository.findById(riesgoId).orElseThrow();
        riesgo.setEstado("CANCELADO");
        riesgoRepository.save(riesgo);
    }
}
