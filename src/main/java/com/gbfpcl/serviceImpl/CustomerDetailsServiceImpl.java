package com.gbfpcl.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbfpcl.entities.CustomerDetails;
import com.gbfpcl.exceptions.ResourceNotFoundException;
import com.gbfpcl.repositories.CustomerDetailsRepo;
import com.gbfpcl.service.CustomerDetailsService;
@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
@Autowired
 private CustomerDetailsRepo customerDetailsRepo;
	@Override
	public CustomerDetails addCustomer(CustomerDetails customerDetails) {
		return this.customerDetailsRepo.save(customerDetails);
	}
	@Override
	public List<CustomerDetails> getAllCustomers() {
		return this.customerDetailsRepo.findAll();
	}
	@Override
	public CustomerDetails updateCustomer(Integer customerID, CustomerDetails customerDetails) {
		CustomerDetails customerById = getCustomerById(customerID);
		customerById.setAddress(customerDetails.getAddress());
		customerById.setContactPersonMobileNubmber(customerDetails.getContactPersonMobileNubmber());
		customerById.setContactPersonName(customerDetails.getCustomerName());
		customerById.setCustomerName(customerDetails.getCustomerName());
		customerById.setEmailId(customerDetails.getEmailId());
		customerById.setOfficeContactNumber(customerDetails.getOfficeContactNumber());
		return addCustomer(customerById) ;
	}
	@Override
	public void deleteCustomer(Integer customerId) {
		this.customerDetailsRepo.deleteById(customerId);
	}
	@Override
	public CustomerDetails getCustomerById(Integer customerId) {
		return this.customerDetailsRepo.findById(customerId).orElseThrow(()->new ResourceNotFoundException("customer", "customerID", customerId));
	}

}
