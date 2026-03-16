package com.polizas.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Poliza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String estado;
    private Double canonMensual;
    private Double prima;

    public Poliza() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getCanonMensual() {
        return canonMensual;
    }

    public void setCanonMensual(Double canonMensual) {
        this.canonMensual = canonMensual;
    }

    public Double getPrima() {
        return prima;
    }

    public void setPrima(Double prima) {
        this.prima = prima;
    }
}
