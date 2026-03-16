package com.polizas.controller;

import com.polizas.model.Riesgo;
import com.polizas.service.RiesgoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RiesgoController {
    private final RiesgoService riesgoService;

    public RiesgoController(RiesgoService riesgoService) {
        this.riesgoService = riesgoService;
    }

    @GetMapping("/polizas/{id}/riesgos")
    public List<Riesgo> obtenerRiesgos(@PathVariable Long id) {
        return riesgoService.obtenerRiesgos(id);
    }

    @PostMapping("/polizas/{id}/riesgos")
    public Riesgo agregarRiesgo(@PathVariable Long id) {
        return riesgoService.agregarRiesgo(id);
    }

    @PostMapping("/riesgos/{id}/cancelar")
    public void cancelarRiesgo(@PathVariable Long id) {
        riesgoService.cancelarRiesgo(id);
    }
}
