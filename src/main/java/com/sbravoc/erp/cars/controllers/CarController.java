package com.sbravoc.erp.cars.controllers;

import com.sbravoc.erp.cars.entities.models.Car;
import com.sbravoc.erp.cars.repositories.CarRepository;
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

    private final CarRepository carRepository;

    // List all Cars
    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    // List Car by ID
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> searchCar = carRepository.findById(id);
        if (searchCar.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(searchCar.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Create new Car
    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody Car car) {
        Car newCar = carRepository.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCar);
    }

    // Delete car if exists
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id) {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
