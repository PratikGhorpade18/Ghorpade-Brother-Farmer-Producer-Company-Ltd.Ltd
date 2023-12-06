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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="customer_details")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@JsonBackReference
	@OneToMany(mappedBy = "customerDetails")
	private List<ExportDetails> expoerDetails;
	
	   
	
	

}
