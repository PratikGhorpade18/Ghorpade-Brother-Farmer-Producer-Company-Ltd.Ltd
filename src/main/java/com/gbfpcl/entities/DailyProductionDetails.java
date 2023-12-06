package com.gbfpcl.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="daily_production_details")
public class DailyProductionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="daily_report_id")
	private Integer dailyReportId;
	
	@Column(name="production_quantity")
	private float productionQuantity;
	
	@Column(name="waste_product")
	private float wasteProduct;
	
	@Column(name="production_date")
	private Timestamp productionDate;
	
	@Column(name="total_production")
	private float totalProduction;
	
	@Column(name="approx_material_weight")
	private float approxMaterialWeight;

	@ManyToOne(cascade = CascadeType.MERGE,fetch  = FetchType.LAZY)
	@JoinColumn(name="product_id")
	@JsonBackReference
	private ProductMaster productMaster;


}
