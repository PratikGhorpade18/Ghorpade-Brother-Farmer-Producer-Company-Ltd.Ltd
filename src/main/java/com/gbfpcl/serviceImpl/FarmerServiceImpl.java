package com.gbfpcl.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbfpcl.dtos.FarmerDto;
import com.gbfpcl.entities.Farmer;
import com.gbfpcl.exceptions.ResourceNotFoundException;
import com.gbfpcl.repositories.FarmerRepo;
import com.gbfpcl.service.FarmerService;
@Service
public class FarmerServiceImpl implements FarmerService{
@Autowired
FarmerRepo farmerRepo;
	ModelMapper mapper=new ModelMapper();
	
	@Override
	public FarmerDto addFarmer( FarmerDto farmer) {
		Farmer save = farmerRepo.save(this.mapper.map(farmer, Farmer.class));
		return this.mapper.map( save,FarmerDto.class);
	}

	@Override
	public List<FarmerDto> getAllFarmer() {
		List<Farmer> findAll = this.farmerRepo.findAll();
		List<FarmerDto> allList =new ArrayList<>();
		findAll.forEach(e->{
			FarmerDto map = this.mapper.map(e, FarmerDto.class);
			allList.add(map);
		});
		return allList;
	}

	@Override
	public FarmerDto updateFarmer(Integer farmerId,FarmerDto farmerDto) {
		Farmer updatedFarmer = this.farmerRepo.findById(farmerId).orElseThrow(()->new ResourceNotFoundException("Farmer", "farmerId", farmerId));
		updatedFarmer.setFullName(farmerDto.getFullName());
		updatedFarmer.setAddress(farmerDto.getAddress());
		updatedFarmer.setAdharNumber(farmerDto.getAdharNumber());
		updatedFarmer.setMobileNumber(farmerDto.getAltMobileNumber());
		updatedFarmer.setAltMobileNumber(farmerDto.getAltMobileNumber());
		this.farmerRepo.save(updatedFarmer);
		return this.mapper.map(updatedFarmer, FarmerDto.class);
	}

	@Override
	public void deleteFarmer(Integer farmerId) {
           this.farmerRepo.deleteById(farmerId);		
	}

	@Override
	public Farmer getFarmerbyId(Integer farmerId) {
		Farmer farmer=this.farmerRepo.findById(farmerId).orElseThrow(()->new ResourceNotFoundException("Farmer", "farmerId", farmerId));
		return farmer;
	}
	
	

}
