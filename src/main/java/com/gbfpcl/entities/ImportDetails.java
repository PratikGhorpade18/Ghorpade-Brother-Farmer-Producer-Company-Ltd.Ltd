package com.gbfpcl.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name="import_details")
public class ImportDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="entry_id")
	private Integer entryId;
	
	@JsonBackReference
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
	
	@Transient
	private String unitofProduct;

}
