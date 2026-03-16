package com.polizas.service;

import com.polizas.model.Poliza;
import com.polizas.model.Riesgo;
import com.polizas.repository.PolizaRepository;
import com.polizas.repository.RiesgoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolizaService {
    private final PolizaRepository polizaRepository;
    private final RiesgoRepository riesgoRepository;

    public PolizaService(PolizaRepository polizaRepository, RiesgoRepository riesgoRepository) {
        this.polizaRepository = polizaRepository;
        this.riesgoRepository = riesgoRepository;
    }

    public Poliza crear(Poliza poliza) {
        if(poliza.getEstado() == null) {
            poliza.setEstado("ACTIVA");
        }
        return polizaRepository.save(poliza);
    }

    public List<Poliza> listar(String tipo, String estado) {
        return polizaRepository.findByTipoAndEstado(tipo, estado);
    }

    public Poliza renovar(Long id) {
        Poliza poliza = polizaRepository.findById(id).orElseThrow();

        if(poliza.getEstado().equals("CANCELADA")) {
            throw new RuntimeException("No se puede renovar una póliza cancelada");
        }

        double ipc = 0.10;

        poliza.setCanonMensual(poliza.getCanonMensual() * (1 + ipc));
        poliza.setPrima(poliza.getPrima() * (1 + ipc));

        poliza.setEstado("RENOVADA");

        enviarEventoCore(poliza.getId());

        return polizaRepository.save(poliza);
    }

    public void cancelar(Long id) {
        Poliza poliza = polizaRepository.findById(id).orElseThrow();
        poliza.setEstado("CANCELADA");
        List<Riesgo> riesgos = riesgoRepository.findByPolizaId(id);

        for(Riesgo r : riesgos) {
            r.setEstado("CANCELAD0");
        }
        riesgoRepository.saveAll(riesgos);
        polizaRepository.save(poliza);

        enviarEventoCore(poliza.getId());
    }

    private void enviarEventoCore(Long polizaId) {
        System.out.println("Evento enviado al CORE para poliza: " + polizaId);
    }
}
