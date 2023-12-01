package com.gbfpcl.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="import_details")
public class ImportDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="entry_id")
	private Integer entryId;
	
	
	 @ManyToOne
	    @JoinColumn(name="farmer_id")
	    private Farmer farmer;
	
	@Column(name="entry_time")
	private Timestamp entryDateTime;
	
	@Column(name="weight")
	private float weight;
	
	@Column(name="cast")
	private String cast;
	
	@Column(name="recovery")
	private float recovery;
	
	@Column(name="rate_per_tonnage")
	private float ratePerTonnage;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="vehical_number")
	private String vehicalNumber;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="comment")
	private String comment;

}
