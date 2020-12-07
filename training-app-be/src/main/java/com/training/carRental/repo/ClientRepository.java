package com.training.carRental.repo;


/*
ClientRepository is an interface extends CrudRepository,
will be autowired in CustomerController for implementing
repository methods and custom finder methods.
 */

import com.training.carRental.model.Client;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findById(int id);
}