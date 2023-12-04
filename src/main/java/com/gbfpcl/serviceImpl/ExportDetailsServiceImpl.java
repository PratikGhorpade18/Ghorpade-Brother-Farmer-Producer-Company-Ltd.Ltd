package com.gbfpcl.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbfpcl.entities.ExportDetails;
import com.gbfpcl.exceptions.ResourceNotFoundException;
import com.gbfpcl.repositories.ExportDetailsRepo;
import com.gbfpcl.service.ExportDetailsService;
@Service
public class ExportDetailsServiceImpl implements ExportDetailsService{
@Autowired
private ExportDetailsRepo exportDetailsRepo;
	@Override
	public ExportDetails addExportEntry(ExportDetails exportDetails) {
		return this.exportDetailsRepo.save(exportDetails);
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
		
		exportEntryById.setAmount(exportdetails.getAmount());
		exportEntryById.setComment(exportdetails.getComment());
		//exportEntryById.setCustomerDetails(exportdetails.getCustomerDetails());
		exportEntryById.setExportDate(exportdetails.getExportDate());
		exportEntryById.setPaymentDate(exportdetails.getPaymentDate());
		exportEntryById.setPaymentStatus(exportdetails.getPaymentStatus());
		exportEntryById.setProductMaster(exportdetails.getProductMaster());
		exportEntryById.setQuantity(exportdetails.getQuantity());
		//exportEntryById.setRatePerkg(exportdetails.getRatePerkg());
		
		return this.exportDetailsRepo.save(exportEntryById);
	}

}
