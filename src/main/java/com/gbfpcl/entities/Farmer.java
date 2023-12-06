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

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="farmer")
public class Farmer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="farmer_id")
	private int farmerId;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="mobile_number")
	private Long mobileNumber;
	
	@Column(name="alt_mobile_number")
	private Long altMobileNumber;
	
	@Column(name="adhar_number")
	private Long adharNumber;
	
	 @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
	    private List<ImportDetails> sugarcaneEntries;

}
