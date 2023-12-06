package com.gbfpcl.dtos;

import java.sql.Timestamp;

import com.gbfpcl.entities.ProductMaster;

import lombok.Data;
@Data
public class DailyProductionDetailsDto {
	private Integer dailyReportId;
	private float productionQuantity;
	private float wasteProduct;
	private Timestamp productionDate;
	private float totalProduction;
	private float approxMaterialWeight;
	private ProductMaster productMaster;
}
