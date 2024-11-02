package com.sbravoc.erp.cars.repositories;

import com.sbravoc.erp.cars.entities.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
