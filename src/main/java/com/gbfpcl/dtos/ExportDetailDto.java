package com.gbfpcl.dtos;

import java.sql.Timestamp;

import com.gbfpcl.entities.CustomerDetails;
import com.gbfpcl.entities.ProductMaster;

import lombok.Data;

@Data
public class ExportDetailDto {
private Integer exportId;
	private Integer quantity;
	private float ratePerkg;
	private float amount;
	private String comment;
	private String paymentStatus;
	private Timestamp exportDate;
	private Timestamp paymentDate;
	private ProductMaster productMaster;
	private CustomerDetails customerDetails;
}
