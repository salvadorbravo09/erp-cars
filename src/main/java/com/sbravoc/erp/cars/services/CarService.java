package com.sbravoc.erp.cars.services;

import com.sbravoc.erp.cars.entities.dtos.CarDTO;
import com.sbravoc.erp.cars.entities.models.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> getAllCars();

    Optional<Car> getCarById(Long id);

    Car saveCar(CarDTO carDTO);

    void deleteCar(Long id);
}
