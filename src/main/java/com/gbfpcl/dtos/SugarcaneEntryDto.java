package com.gbfpcl.dtos;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class SugarcaneEntryDto {
	
	private Integer entryId;
	//private Farmer farmer;
	  private FarmerDto farmer;

	@NotNull
	private Timestamp entryDateTime;
	public SugarcaneEntryDto() {
        this.entryDateTime = Timestamp.valueOf(LocalDateTime.now());
    }
	@NotNull
	private float weight;
	
	private String cast;
	private float recovery;
	
	private float ratePerTonnage;
	private float amount;
	@NotNull
	private String vehicalNumber;
	
	private String paymentStatus;
	
	private String comment;
	
	public void setFarmer(FarmerDto farmerDto) {
	    this.farmer = farmerDto;
	}

}
