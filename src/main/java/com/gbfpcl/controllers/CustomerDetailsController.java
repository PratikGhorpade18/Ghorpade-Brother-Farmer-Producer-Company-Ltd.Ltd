package com.gbfpcl.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbfpcl.entities.CustomerDetails;
import com.gbfpcl.service.CustomerDetailsService;
import com.gbfpcl.service.ExportDetailsService;

@RestController
@RequestMapping("/Ghorpade-Brother/Customer/")
@CrossOrigin
public class CustomerDetailsController {
	
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@PostMapping(value="/addCustomer")
	public ResponseEntity<CustomerDetails> addCustomer( @Valid @RequestBody CustomerDetails customerDetails){
		CustomerDetails created=this.customerDetailsService.addCustomer(customerDetails);
		return new ResponseEntity<CustomerDetails>(created,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getAllCustomers")
	public ResponseEntity<List<CustomerDetails>> getAllCustomers(){
		return new ResponseEntity<>(this.customerDetailsService.getAllCustomers(),HttpStatus.OK);
	}
	
	@PutMapping(value="/updateCustomer/{customerID}")
	public ResponseEntity<CustomerDetails> updateCustomer(@Valid @RequestBody CustomerDetails customerDetails,  @PathVariable(name="customerID")Integer customerID){
		CustomerDetails updatedcustomerDetails = this.customerDetailsService.updateCustomer(customerID,customerDetails);
		return new ResponseEntity<CustomerDetails>(updatedcustomerDetails,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteCustomer/{customerId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(name="customerId")Integer customerId){
		Map<String,String> map= new HashMap<>();
		this.customerDetailsService.deleteCustomer(customerId);
		map.put("message", "Customer deleted Sucessfully");
		return  ResponseEntity.ok(map);
	}
	
	@GetMapping(value="/getCustomerById/{customerId}")
	public ResponseEntity<CustomerDetails> getCustomerById(@PathVariable(name="customerId")Integer customerId){
		CustomerDetails customerDetails = this.customerDetailsService.getCustomerById(customerId);
		return new ResponseEntity<CustomerDetails>(customerDetails,HttpStatus.OK);
	}

}
