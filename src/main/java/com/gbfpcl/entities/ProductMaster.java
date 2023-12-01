package com.gbfpcl.entities;

import java.sql.Timestamp;
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
@Table(name="product_master")
public class ProductMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	@OneToMany(mappedBy = "productMaster",cascade = CascadeType.ALL)
	private List<ExportDetails> exportEntries;
	
	@OneToMany(mappedBy = "productMaster",cascade = CascadeType.ALL)
	private List<DailyProductionDetails> dailyProductionDetails;
	
	
	

}
