package com.capgemini.training.restDemo.repo;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.training.restDemo.model.Customer;

public interface CustRepo extends CrudRepository<Customer, Long> {

	
}
