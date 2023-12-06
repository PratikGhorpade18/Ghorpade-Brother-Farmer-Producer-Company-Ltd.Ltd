package com.gbfpcl.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbfpcl.dtos.DailyProductionDetailsDto;
import com.gbfpcl.entities.DailyProductionDetails;
import com.gbfpcl.entities.ProductMaster;
import com.gbfpcl.exceptions.ResourceNotFoundException;
import com.gbfpcl.repositories.DailyReportRepo;
import com.gbfpcl.repositories.ProductRepo;
import com.gbfpcl.service.DailyReportService;
import com.gbfpcl.service.ProductService;

@Service
public class DailyReportServiceImpl  implements DailyReportService{

	@Autowired
	private DailyReportRepo dailyReportRepo;
	
	@Autowired 
	private ProductRepo productRepo;
	
	ModelMapper mapper =new ModelMapper();
	
	
	@Override
	public DailyProductionDetailsDto addDailyReportl( DailyProductionDetailsDto dailyProductionDetails) {
		ProductMaster orElseThrow = this.productRepo.findById(dailyProductionDetails.getProductMaster().getProductId()).orElseThrow(()-> new ResourceNotFoundException("Product", "productId", dailyProductionDetails.getProductMaster().getProductId()));
		dailyProductionDetails.setProductMaster(orElseThrow);
		dailyProductionDetails.setTotalProduction(dailyProductionDetails.getProductionQuantity()+dailyProductionDetails.getWasteProduct());
		DailyProductionDetails save = this.dailyReportRepo.save(this.mapper.map(dailyProductionDetails, DailyProductionDetails.class));
		return this.mapper.map(save, DailyProductionDetailsDto.class);
	}

	

	@Override
	public DailyProductionDetails updateDailyReport(Integer dailyReportId,
			DailyProductionDetails dailyProductionDetails) {
	        DailyProductionDetails dailyReportId2 = getDailyReportId(dailyReportId);
	        
	        dailyReportId2.setProductionQuantity(dailyProductionDetails.getProductionQuantity());
	        dailyReportId2.setWasteProduct(dailyProductionDetails.getWasteProduct());
	        dailyReportId2.setProductionDate(dailyProductionDetails.getProductionDate());
	        dailyReportId2.setApproxMaterialWeight(dailyProductionDetails.getApproxMaterialWeight());
	        dailyReportId2.setProductMaster(this.productRepo.findById(dailyProductionDetails.getProductMaster().getProductId()).orElseThrow(()-> new ResourceNotFoundException("Product", "productId",dailyProductionDetails.getProductMaster().getProductId() )));
	        dailyReportId2.setTotalProduction(dailyProductionDetails.getProductionQuantity()+dailyProductionDetails.getWasteProduct());
	        
		return this.dailyReportRepo.save(dailyReportId2);
	}

	@Override
	public void deleteDailyReport(Integer dailyReportId) {
		this.dailyReportRepo.deleteById(dailyReportId);
	}

	@Override
	public DailyProductionDetails getDailyReportId(Integer dailyReportId) {
		DailyProductionDetails orElseThrow = this.dailyReportRepo.findById(dailyReportId).orElseThrow(()-> new ResourceNotFoundException("DailyProductionDetails", "dailyReportId", dailyReportId));
		return orElseThrow;
	}

	@Override
	public List<DailyProductionDetails> getAll() {
		return this.dailyReportRepo.findAll();
	}

}
