package com.gbfpcl.service;

import java.util.List;

import javax.validation.Valid;

import com.gbfpcl.dtos.FarmerDto;
import com.gbfpcl.entities.Farmer;

public interface FarmerService {

	FarmerDto addFarmer( FarmerDto farmer);

	List<FarmerDto> getAllFarmer();

	FarmerDto updateFarmer(Integer farmerId, FarmerDto farmerDto);

	void deleteFarmer(Integer farmerId);

	Farmer getFarmerbyId(Integer farmerId);

}
