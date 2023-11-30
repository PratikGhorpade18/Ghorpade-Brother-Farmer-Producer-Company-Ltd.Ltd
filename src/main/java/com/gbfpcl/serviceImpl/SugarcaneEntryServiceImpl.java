package com.gbfpcl.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbfpcl.dtos.FarmerDto;
import com.gbfpcl.dtos.SugarcaneEntryDto;
import com.gbfpcl.entities.Farmer;
import com.gbfpcl.entities.SugarcaneEntry;
import com.gbfpcl.exceptions.ResourceNotFoundException;
import com.gbfpcl.repositories.FarmerRepo;
import com.gbfpcl.repositories.SugarcaneEntryRepo;
import com.gbfpcl.service.SugarcaneEntryService;
@Service
public class SugarcaneEntryServiceImpl implements SugarcaneEntryService {
	@Autowired
	private SugarcaneEntryRepo sugarcaneEntryRepo;
	
	@Autowired
	private FarmerRepo farmerRepo;
	
	
		ModelMapper mapper=new ModelMapper();
		
		

	@Override
	public SugarcaneEntryDto addEntry(SugarcaneEntryDto sugarcaneEntryDto,Integer farmerId) {
		sugarcaneEntryDto.setAmount(sugarcaneEntryDto.getRatePerTonnage()*sugarcaneEntryDto.getWeight());
		Farmer farmer = this.farmerRepo.findById(farmerId).orElseThrow(()->new ResourceNotFoundException("Farmer", "farmerId", farmerId));
		FarmerDto map = this.mapper.map(farmer, FarmerDto.class);
		sugarcaneEntryDto.setFarmer(map);
		SugarcaneEntry save = this.sugarcaneEntryRepo.save(this.mapper.map(sugarcaneEntryDto, SugarcaneEntry.class));
		return this.mapper.map(save, SugarcaneEntryDto.class);
	}

	@Override
	public SugarcaneEntryDto updateEntry(Integer entryId,SugarcaneEntryDto sugarcaneEntryDto,Integer farmerId) {
		SugarcaneEntry save = this.sugarcaneEntryRepo.findById(entryId).orElseThrow(()->new ResourceNotFoundException("Sugarcane Entry", "entryId", entryId));
		save.setAmount(sugarcaneEntryDto.getRatePerTonnage()*sugarcaneEntryDto.getWeight());
		save.setCast(sugarcaneEntryDto.getCast());
		save.setEntryDateTime(sugarcaneEntryDto.getEntryDateTime());
		save.setRatePerTonnage(sugarcaneEntryDto.getRatePerTonnage());
		save.setRecovery(sugarcaneEntryDto.getRecovery());
		save.setVehicalNumber(sugarcaneEntryDto.getVehicalNumber());
		save.setWeight(sugarcaneEntryDto.getWeight());
		Farmer farmer = this.farmerRepo.findById(farmerId).orElseThrow(()->new ResourceNotFoundException("Farmer", "farmerId", farmerId));
		save.setFarmer(farmer);
		SugarcaneEntry updated = this.sugarcaneEntryRepo.save(save);
		return this.mapper.map(updated, SugarcaneEntryDto.class);
	}

	@Override
	public List<SugarcaneEntryDto> getAllEntries() {
		List<SugarcaneEntryDto> entryList= new ArrayList<>();
		this.sugarcaneEntryRepo.findAll().forEach(e->{
			entryList.add(this.mapper.map(e, SugarcaneEntryDto.class));
		});
		return entryList;
	}

	@Override
	public void deleteEntry(Integer entryId) {
		this.sugarcaneEntryRepo.deleteById(entryId);
	}

	@Override
	public SugarcaneEntryDto getEntryById(Integer entryId) {
		SugarcaneEntry save = this.sugarcaneEntryRepo.findById(entryId).orElseThrow(()->new ResourceNotFoundException("Sugarcane Entry", "entryId", entryId));
		return this.mapper.map(save, SugarcaneEntryDto.class);
	}
	
	

}
