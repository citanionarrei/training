package com.training.carRental.repo;

/*
CarRepository is an interface extends CrudRepository,
ill be autowired in CustomerController for implementing
repository methods and custom finder methods.
 */

import com.training.carRental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findById(int id);
}

