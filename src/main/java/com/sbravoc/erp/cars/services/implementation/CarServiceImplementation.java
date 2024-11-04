package com.sbravoc.erp.cars.services.implementation;

import com.sbravoc.erp.cars.entities.dtos.CarDTO;
import com.sbravoc.erp.cars.entities.models.Car;
import com.sbravoc.erp.cars.repositories.CarRepository;
import com.sbravoc.erp.cars.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImplementation implements CarService {

    private final CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car saveCar(CarDTO carDTO) {
        return saveOrUpdateCar(new Car(), carDTO);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    private Car saveOrUpdateCar(Car car, CarDTO carDTO) {
        car.setColor(carDTO.getColor());
        car.setMake(carDTO.getMake());
        car.setYear(carDTO.getYear());
        car.setPatent(carDTO.getPatent());
        car.setModel(carDTO.getModel());
        return carRepository.save(car);
    }
}
