package com.gbfpcl.service;

import java.util.List;

import javax.validation.Valid;

import com.gbfpcl.entities.CustomerDetails;

public interface CustomerDetailsService {

	CustomerDetails addCustomer( CustomerDetails customerDetails);

	List<CustomerDetails> getAllCustomers();

	CustomerDetails updateCustomer(Integer customerID, CustomerDetails customerDetails);

	void deleteCustomer(Integer customerId);

	CustomerDetails getCustomerById(Integer customerId);

}
