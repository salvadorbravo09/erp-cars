package com.sbravoc.erp.cars.controllers;

import com.sbravoc.erp.cars.entities.dtos.CarDTO;
import com.sbravoc.erp.cars.entities.models.Car;
import com.sbravoc.erp.cars.repositories.CarRepository;
import com.sbravoc.erp.cars.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    // List all Cars
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // List Car by ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> searchCar = carService.getCarById(id);
        if (searchCar.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(searchCar.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Create new Car
    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody CarDTO carDTO) {
        Car newCar = carService.saveCar(carDTO);
        if (newCar != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Delete car if exists
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        Optional<Car> car = carService.getCarById(id);
        if (car.isPresent()) {
            carService.deleteCar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
