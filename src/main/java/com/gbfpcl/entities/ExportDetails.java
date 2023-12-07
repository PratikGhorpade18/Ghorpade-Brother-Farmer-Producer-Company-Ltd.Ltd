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
@Table(name="export_details")
public class ExportDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="export_id")
	private Integer exportId;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="rate_per_kg")
	private float ratePerkg;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="export_payment_status")
	private String paymentStatus;
	
	@Column(name="export_date")
	private Timestamp exportDate;
	
	@Column(name="payment_date")
	private Timestamp paymentDate;
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="product_id")
	private ProductMaster productMaster;
	
	@Transient
	private String unitofProduct;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private CustomerDetails customerDetails;
	

}
