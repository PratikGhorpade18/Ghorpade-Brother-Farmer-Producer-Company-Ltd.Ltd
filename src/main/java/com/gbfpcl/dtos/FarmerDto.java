package com.gbfpcl.dtos;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gbfpcl.entities.ImportDetails;

import lombok.Data;

@Data
public class FarmerDto {

	private int farmerId;
	@NotEmpty
	@Size(min = 4, message = "farmer name minimum of 4 characters")
	private String fullName;

	@NotEmpty
	@Size(min = 4, message = "address minimum of 4 characters")
	private String address;

	@NotNull
	@Digits(integer = 12, fraction = 0, message = "Please Enter Valid Adhar Number")
	private Long mobileNumber;
	private Long altMobileNumber;
	@NotNull
	@Digits(integer = 12, fraction = 0, message = "Please Enter Valid Adhar Number")
	private Long adharNumber;

	@JsonBackReference
	private List<ImportDetails> sugarcaneEntries;

}
