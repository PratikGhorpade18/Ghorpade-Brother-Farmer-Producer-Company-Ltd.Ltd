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

import com.gbfpcl.dtos.SugarcaneEntryDto;
import com.gbfpcl.service.SugarcaneEntryService;

@RestController
@RequestMapping("/Ghorpade-Brother/Entry/")
public class SugarcaneEntryController {
	
	@Autowired
	private SugarcaneEntryService sugarcaneEntryService;
	
	@PostMapping(value="/addEntry/{farmerId}")
	public ResponseEntity<SugarcaneEntryDto> addEntry(@Valid @RequestBody SugarcaneEntryDto sugarcaneEntryDto,@PathVariable("farmerId")Integer farmerId) {
		SugarcaneEntryDto addEntry = this.sugarcaneEntryService.addEntry(sugarcaneEntryDto,farmerId);
		return new ResponseEntity<SugarcaneEntryDto>(addEntry,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/editEntry/{entryId}/{farmerId}")
	public ResponseEntity<SugarcaneEntryDto> updateEntry(@Valid @RequestBody SugarcaneEntryDto sugarcaneEntryDto,@PathVariable("entryId")Integer entryId,@PathVariable("farmerId")Integer farmerId) {
		SugarcaneEntryDto update = this.sugarcaneEntryService.updateEntry(entryId,sugarcaneEntryDto,farmerId);
		return new ResponseEntity<SugarcaneEntryDto>(update,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllEntries")
	public ResponseEntity<List<SugarcaneEntryDto>> getAllEntries(){
		 List<SugarcaneEntryDto> allEntries = this.sugarcaneEntryService.getAllEntries();
		return new ResponseEntity<>(allEntries,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteEntry/{entryId}")
	public ResponseEntity<?>deleteEntry(@PathVariable("entryId")Integer entryId){
		this.sugarcaneEntryService.deleteEntry(entryId);
		return  ResponseEntity.ok("Entry Deleted Sucessfully!!!");
	}
	
	@GetMapping(value="/getEntryById/{entryId}")
	public ResponseEntity<SugarcaneEntryDto> getEntryById(@PathVariable("entryId")Integer entryId){
		SugarcaneEntryDto entryById = this.sugarcaneEntryService.getEntryById(entryId);
		return new ResponseEntity<>(entryById,HttpStatus.OK);
	}
	
	
	

}
