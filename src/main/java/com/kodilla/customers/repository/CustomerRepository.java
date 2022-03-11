package com.kodilla.customers.repository;

import com.kodilla.customers.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
