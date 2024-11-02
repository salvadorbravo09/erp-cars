package com.sbravoc.erp.cars.services;

import com.sbravoc.erp.cars.entities.models.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    Car getCarById(Long id);

    void saveCar(Car car);

    void deleteCar(Long id);
}
