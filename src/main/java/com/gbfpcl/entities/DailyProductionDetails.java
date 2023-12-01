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

import lombok.Data;

@Entity
@Data
@Table(name="daily_production_details")
public class DailyProductionDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@ManyToOne
	@JoinColumn(name="product_id")
	private ProductMaster productMaster;
	

}
