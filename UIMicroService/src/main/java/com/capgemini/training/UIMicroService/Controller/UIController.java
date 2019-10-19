package com.capgemini.training.UIMicroService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.capgemini.training.UIMicroService.model.Customer;

//@RestController
@Controller
public class UIController {

	@Autowired
	RestTemplate restTemp;
	
	@Autowired
	Customer cust;
	
//	@GetMapping("/customers")
//	public Iterable<Customer> displayAll(){
//		cust = restTemp.getForEntity("http://localhost:9090/customers", Customer.class);
//		return (Iterable<Customer>) cust;
//	}
	
	@GetMapping("/")
	public String index(){
		return "index";
	}
	
//	@GetMapping("/customers/{id}")
//	public ResponseEntity<Customer> displayById(@PathVariable("id") int id){
//		return restTemp.getForEntity("http://localhost:9090/customers/" + id, Customer.class);
//	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> displayById(@PathVariable("id") int id){
		return restTemp.getForEntity("http://customerCRUD/customers/" + id, Customer.class);
	}
	
//	@GetMapping("/customers/")
//	public ResponseEntity<Customer[]> displayAll(){
//		return restTemp.getForEntity("http://localhost:9090/customers/" , Customer[].class);
//	}

//	@GetMapping("/customers/")
//	public String displayAll(Model model) {
//		Customer[] custArray = restTemp.getForObject("http://localhost:9090/customers/", Customer[].class);
//		model.addAttribute("customers", custArray);
//		return "customers";
//	}
	
	@GetMapping("/customers/")
	public String displayAll(Model model) {
		Customer[] custArray = restTemp.getForObject("http://customerCRUD/customers/", Customer[].class);
		model.addAttribute("customers", custArray);
		return "customers";
	}
	
	@DeleteMapping("/customers/{id}")
	public String delete(@PathVariable("id") int id){
		restTemp.delete("http://localhost:9090/customers/" + id);
		return "Deleted";
	}
}
