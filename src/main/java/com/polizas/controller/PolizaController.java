package com.polizas.controller;

import com.polizas.model.Poliza;
import com.polizas.service.PolizaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polizas")
public class PolizaController {

    private final PolizaService polizaService;

    public PolizaController(PolizaService polizaService) {
        this.polizaService = polizaService;
    }

    @GetMapping
    public List<Poliza> listar(@RequestParam String tipo, @RequestParam String estado) {
        return polizaService.listar(tipo, estado);
    }

    @PostMapping
    public Poliza crearPoliza(@RequestBody Poliza poliza) {
        return polizaService.crear(poliza);
    }

    @PostMapping("/{id}/renovar")
    public Poliza renovar(@PathVariable Long id) {
        return polizaService.renovar(id);
    }

    @PostMapping("/{id}/cancelar")
    public void cancelar(@PathVariable Long id) {
        polizaService.cancelar(id);
    }
}
