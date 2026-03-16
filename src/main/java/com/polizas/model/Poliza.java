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
}
