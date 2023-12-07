package com.gbfpcl.serviceImpl;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbfpcl.dtos.ExportDetailDto;
import com.gbfpcl.entities.ExportDetails;
import com.gbfpcl.exceptions.ResourceNotFoundException;
import com.gbfpcl.repositories.CustomerDetailsRepo;
import com.gbfpcl.repositories.ExportDetailsRepo;
import com.gbfpcl.repositories.ProductRepo;
import com.gbfpcl.service.ExportDetailsService;
@Service
public class ExportDetailsServiceImpl implements ExportDetailsService{
@Autowired
private ExportDetailsRepo exportDetailsRepo;

@Autowired
private CustomerDetailsRepo customerDetailsRepo;

@Autowired
private ProductRepo productRepo;

ModelMapper mapper=new ModelMapper();

	@Override
	public ExportDetailDto addExportEntry(ExportDetailDto exportDetails) {
		if(exportDetails.getUnitofProduct().equalsIgnoreCase("t")) {
			exportDetails.setQuantity(exportDetails.getQuantity()*1000);
		}
		exportDetails.setAmount(exportDetails.getRatePerkg()*exportDetails.getQuantity());
		exportDetails.setCustomerDetails(this.customerDetailsRepo.findById(exportDetails.getCustomerDetails().getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Customer", "customerId", exportDetails.getCustomerDetails().getCustomerId())));
		exportDetails.setProductMaster(this.productRepo.findById(exportDetails.getProductMaster().getProductId()).orElseThrow(()->new ResourceNotFoundException("Product", "roductId", exportDetails.getProductMaster().getProductId())));
		ExportDetails save = this.exportDetailsRepo.save(this.mapper.map(exportDetails, ExportDetails.class));
		return this.mapper.map(save, ExportDetailDto.class);
	}

	@Override
	public List<ExportDetails> getAllExportEntries() {
		return this.exportDetailsRepo.findAll();
	}

	@Override
	public void deleteExportEntry(Integer entryId) {
		this.exportDetailsRepo.deleteById(entryId);
	}

	@Override
	public ExportDetails getExportEntryById(Integer entryId) {
		return this.exportDetailsRepo.findById(entryId).orElseThrow(()-> new ResourceNotFoundException("Export Entry", "entryId", entryId));
	}

	@Override
	public ExportDetails editExportEntry(Integer entryId, ExportDetails exportdetails) {
		ExportDetails exportEntryById = getExportEntryById(entryId);
		if(exportdetails.getUnitofProduct().equalsIgnoreCase("t")) {
			exportEntryById.setQuantity(exportdetails.getQuantity()*1000);
		}
		exportEntryById.setAmount(exportdetails.getRatePerkg()*exportdetails.getQuantity());
		exportEntryById.setComment(exportdetails.getComment());
		exportEntryById.setExportDate(exportdetails.getExportDate());
		exportEntryById.setPaymentDate(exportdetails.getPaymentDate());
		exportEntryById.setPaymentStatus(exportdetails.getPaymentStatus());
		exportEntryById.setQuantity(exportdetails.getQuantity());
		exportEntryById.setRatePerkg(exportdetails.getRatePerkg());
		exportEntryById.setCustomerDetails(this.customerDetailsRepo.findById(exportdetails.getCustomerDetails().getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Customer", "customerId", exportdetails.getCustomerDetails().getCustomerId())));
		exportEntryById.setProductMaster(this.productRepo.findById(exportdetails.getProductMaster().getProductId()).orElseThrow(()->new ResourceNotFoundException("Product", "roductId", exportdetails.getProductMaster().getProductId())));
		return this.exportDetailsRepo.save(exportEntryById);
	}

	@Override
	public List<ExportDetails> getExportEntriesOndate(Date date) {
		return this.exportDetailsRepo.findExportEntriesOnDate(date);
	}

	@Override
	public Map<String, Integer> getExportedProductWise() {
		List<ExportDetails> all = getAllExportEntries();
		Map<String, Integer> productMap=all.stream().collect(groupingBy(e -> e.getProductMaster().getProductName(),summingInt(ExportDetails::getQuantity)));
		return productMap;
	}

}
