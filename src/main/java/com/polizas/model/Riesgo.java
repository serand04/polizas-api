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
}
