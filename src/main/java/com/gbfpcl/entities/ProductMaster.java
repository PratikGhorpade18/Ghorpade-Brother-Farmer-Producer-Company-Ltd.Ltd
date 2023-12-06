package com.gbfpcl.entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="product_master")
public class ProductMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="created_date")
	private Timestamp createdDate;
	
	public ProductMaster() {
        this.createdDate = Timestamp.valueOf(LocalDateTime.now());
    }
	
@JsonIgnore
	@OneToMany(mappedBy = "productMaster",cascade = CascadeType.ALL)
	private List<ExportDetails> exportEntries;
	
    @JsonIgnore
	@OneToMany(mappedBy = "productMaster",cascade = CascadeType.ALL)
	private List<DailyProductionDetails> dailyProductionDetails;
	
	
	

}
