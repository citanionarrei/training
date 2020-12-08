package com.training.carRental.repo;

/*
RentalRepository is an interface extends CrudRepository,
will be autowired in CustomerController for implementing
repository methods and custom finder methods.
 */

import com.training.carRental.model.Rental;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RentalRepository extends CrudRepository<Rental, Long> {
    List<Rental> findById(int id);
}
