package com.sbravoc.erp.cars.entities.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "make")
    @NotBlank(message = "La marca no puede estar vacía")
    private String make;

    @Column(name = "model")
    @NotBlank(message = "El modelo no puede estar vacío")
    private String model;

    @Column(name = "year")
    @Min(value = 1886, message = "El año debe ser válido.")
    private int year;

    @Column(name = "patent", unique = true)
    @NotBlank(message = "La patente no puede estar vacía")
    private String patent;

    @Column(name = "color")
    @NotBlank(message = "El color no puede estar vacío")
    private String color;
}
