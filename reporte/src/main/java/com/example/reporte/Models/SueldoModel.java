package com.example.reporte.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SueldoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String rut;
    private String nombreEmpleado;
    private Integer yearsOfService;
    private Integer sueldoFijoMensual;
    private double bonoYearsOfService;
    private double pagoHorasExtras;
    private double montoDescuentos;
    private double sueldoBruto;
    private double cotizacionPrevisional;
    private double cotizacionSalud;
    private Integer sueldoFinal;
}
