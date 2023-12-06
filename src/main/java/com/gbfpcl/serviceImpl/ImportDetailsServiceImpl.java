package com.gbfpcl.serviceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbfpcl.dtos.ExportDetailDto;
import com.gbfpcl.dtos.FarmerDto;
import com.gbfpcl.dtos.ImportDetailsDto;
import com.gbfpcl.entities.Farmer;
import com.gbfpcl.entities.ImportDetails;
import com.gbfpcl.exceptions.ResourceNotFoundException;
import com.gbfpcl.repositories.FarmerRepo;
import com.gbfpcl.repositories.ImportDetailsRepo;
import com.gbfpcl.service.ImportDetailsService;
@Service
public class ImportDetailsServiceImpl implements ImportDetailsService {
	@Autowired
	private ImportDetailsRepo sugarcaneEntryRepo;
	
	@Autowired
	private FarmerRepo farmerRepo;
	
	
		ModelMapper mapper=new ModelMapper();
		
		

	@Override
	public ImportDetailsDto addEntry(ImportDetailsDto sugarcaneEntryDto) {
		sugarcaneEntryDto.setAmount(sugarcaneEntryDto.getRatePerTonnage()*sugarcaneEntryDto.getWeight());
		Farmer farmer = this.farmerRepo.findById(sugarcaneEntryDto.getFarmer().getFarmerId()).orElseThrow(()->new ResourceNotFoundException("Farmer", "farmerId", sugarcaneEntryDto.getFarmer().getFarmerId()));
		FarmerDto map = this.mapper.map(farmer, FarmerDto.class);
		sugarcaneEntryDto.setFarmer(map);
		ImportDetails save = this.sugarcaneEntryRepo.save(this.mapper.map(sugarcaneEntryDto, ImportDetails.class));
		return this.mapper.map(save, ImportDetailsDto.class);
	}

	@Override
	public ImportDetailsDto updateEntry(Integer entryId,ImportDetailsDto sugarcaneEntryDto) {
		ImportDetails save = this.sugarcaneEntryRepo.findById(entryId).orElseThrow(()->new ResourceNotFoundException("Sugarcane Entry", "entryId", entryId));
		save.setAmount(sugarcaneEntryDto.getRatePerTonnage()*sugarcaneEntryDto.getWeight());
		save.setCast(sugarcaneEntryDto.getCast());
		save.setEntryDateTime(sugarcaneEntryDto.getEntryDateTime());
		save.setRatePerTonnage(sugarcaneEntryDto.getRatePerTonnage());
		save.setRecovery(sugarcaneEntryDto.getRecovery());
		save.setVehicalNumber(sugarcaneEntryDto.getVehicalNumber());
		save.setWeight(sugarcaneEntryDto.getWeight());
		Farmer farmer = this.farmerRepo.findById(sugarcaneEntryDto.getFarmer().getFarmerId()).orElseThrow(()->new ResourceNotFoundException("Farmer", "farmerId", sugarcaneEntryDto.getFarmer().getFarmerId()));
		save.setFarmer(farmer);
		save.setComment(sugarcaneEntryDto.getComment());
		save.setPaymentStatus(sugarcaneEntryDto.getPaymentStatus());
		ImportDetails updated = this.sugarcaneEntryRepo.save(save);
		return this.mapper.map(updated, ImportDetailsDto.class);
	}

	@Override
	public List<ImportDetailsDto> getAllEntries() {
		List<ImportDetailsDto> entryList= new ArrayList<>();
		this.sugarcaneEntryRepo.findAll().forEach(e->{
			entryList.add(this.mapper.map(e, ImportDetailsDto.class));
		});
		return entryList;
	}

	@Override
	public void deleteEntry(Integer entryId) {
		this.sugarcaneEntryRepo.deleteById(entryId);
	}

	@Override
	public ImportDetailsDto getEntryById(Integer entryId) {
		ImportDetails save = this.sugarcaneEntryRepo.findById(entryId).orElseThrow(()->new ResourceNotFoundException("Sugarcane Entry", "entryId", entryId));
		return this.mapper.map(save, ImportDetailsDto.class);
	}

	@Override
	public List<ImportDetailsDto> getImportEntriesByDate(Date date) {
		List<ImportDetails> findByEntryDateTime = this.sugarcaneEntryRepo.findByEntryDateTime(date);
		List<ImportDetailsDto> listAsPerDate = new ArrayList<>();
		findByEntryDateTime.forEach(e->{
			listAsPerDate.add(this.mapper.map(e, ImportDetailsDto.class));
		});
		return listAsPerDate;
	}
	
	

}
