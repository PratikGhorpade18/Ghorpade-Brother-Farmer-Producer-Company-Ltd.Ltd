package com.gbfpcl.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="customer_details")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private Integer customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="office_contact_number")
	private Long officeContactNumber;
	
	@Column(name="contact_person_name")
	private String  contactPersonName;
	
	@Column(name="contact_person_mobilenumber")
	private Long contactPersonMobileNubmber;
	
	@Column(name="email_id")
	private String emailId;
	
	
	@Column(name="address")
	private String address;
	
	@OneToMany(mappedBy = "customerDetails",cascade = CascadeType.ALL)
	private List<ExportDetails> expoerDetails;
	
	   
	
	

}
