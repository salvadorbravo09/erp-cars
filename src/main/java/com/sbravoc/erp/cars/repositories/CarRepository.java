package com.sbravoc.erp.cars.repositories;

import com.sbravoc.erp.cars.entities.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
