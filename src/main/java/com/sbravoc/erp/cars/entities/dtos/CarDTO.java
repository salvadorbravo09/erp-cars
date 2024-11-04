package com.sbravoc.erp.cars.entities.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {

    private String make;
    private String model;
    private int year;
    private String patent;
    private String color;
}
