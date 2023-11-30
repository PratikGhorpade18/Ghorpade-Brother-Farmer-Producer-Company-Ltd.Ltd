package com.gbfpcl.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbfpcl.dtos.FarmerDto;
import com.gbfpcl.entities.Farmer;
import com.gbfpcl.service.FarmerService;

@RestController
@RequestMapping("/Ghorpade-Brother/farmer/")
public class FarmerController {
	
	@Autowired
	FarmerService farmerService;
	
	@PostMapping(value="/addFarmer")
	public ResponseEntity<FarmerDto> addFarmer( @Valid @RequestBody FarmerDto farmer){
		FarmerDto created=this.farmerService.addFarmer(farmer);
		return new ResponseEntity<FarmerDto>(created,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getAllFarmer")
	public ResponseEntity<List<FarmerDto>> getAllFarmer(){
		return new ResponseEntity<>(this.farmerService.getAllFarmer(),HttpStatus.OK);
	}
	
	@PutMapping(value="/updateFramer/{farmerId}")
	public ResponseEntity<FarmerDto> updateFarmer(@Valid @RequestBody FarmerDto farmerDto,  @PathVariable(name="farmerId")Integer farmerId){
		FarmerDto updateFarmer = this.farmerService.updateFarmer(farmerId,farmerDto);
		return new ResponseEntity<FarmerDto>(updateFarmer,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteFarmer/{farmerId}")
	public ResponseEntity<?> deleteFarmerById(@PathVariable(name="farmerId")Integer farmerId){
		this.farmerService.deleteFarmer(farmerId);
		return  ResponseEntity.ok("Farmer Deleted Sucessfully!!!");
	}
	
	@GetMapping(value="/getFarmerById/{farmerId}")
	public ResponseEntity<Farmer> getFarmerbyId(@PathVariable(name="farmerId")Integer farmerId){
		Farmer farmer = this.farmerService.getFarmerbyId(farmerId);
		return new ResponseEntity<Farmer>(farmer,HttpStatus.OK);
	}

}
