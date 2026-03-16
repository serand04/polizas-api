package com.polizas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Riesgo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long polizaId;
    private String estado;

    public Riesgo() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getPolizaId() {
        return polizaId;
    }

    public void setPolizaId(Long polizaId) {
        this.polizaId = polizaId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
