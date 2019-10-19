package com.capgemini.training.restDemo.CustController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.training.restDemo.model.Customer;
import com.capgemini.training.restDemo.repo.CustRepo;

@RestController
public class CustController {

	@Autowired
	Customer cust;

	@Autowired
	CustRepo repo;

	@GetMapping("/customers/{id}")
	public Optional<Customer> displayById(@PathVariable("id") long id) {
		return repo.findById(id);
	}

	@GetMapping("/customers")
	public Iterable<Customer> displayCustomers() {
		return repo.findAll();
	}
	
	//	or
//	@GetMapping("/customers/")
//	public List<Customer> displayAll(){
//		return (List<Customer>) repo.findAll();
//	}
	
	@PostMapping("/customers")
	public String add(@RequestBody Customer cust1) {
		repo.save(cust1);
		return "Record Added Successfully";
	}
	
	@PutMapping("/customers/{id}")
	public String update(@RequestBody Customer cust1, @PathVariable("id") long id) {
		cust1.setId(id);
		repo.save(cust1);
		return "Record Updated Successfully";
	}
	
	@DeleteMapping("/customers/{id}")
	public String delete(@PathVariable("id") long id) {
		repo.deleteById(id);
		return "Record deleted Successfully";
	}

}
