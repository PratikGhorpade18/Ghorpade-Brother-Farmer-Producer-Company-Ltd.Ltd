package com.gbfpcl.controllers;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gbfpcl.dtos.ImportDetailsDto;
import com.gbfpcl.entities.ImportDetails;
import com.gbfpcl.service.ImportDetailsService;

@RestController
@RequestMapping("/Ghorpade-Brother/Entry/")
@CrossOrigin
public class ImportDetailsController {
	
	@Autowired
	private ImportDetailsService sugarcaneEntryService;
	
	@PostMapping(value="/addEntry")
	public ResponseEntity<ImportDetailsDto> addEntry(@Valid @RequestBody ImportDetailsDto sugarcaneEntryDto) {
		ImportDetailsDto addEntry = this.sugarcaneEntryService.addEntry(sugarcaneEntryDto);
		return new ResponseEntity<ImportDetailsDto>(addEntry,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/editEntry/{entryId}")
	public ResponseEntity<ImportDetailsDto> updateEntry(@Valid @RequestBody ImportDetailsDto sugarcaneEntryDto,@PathVariable("entryId")Integer entryId) {
		ImportDetailsDto update = this.sugarcaneEntryService.updateEntry(entryId,sugarcaneEntryDto);
		return new ResponseEntity<ImportDetailsDto>(update,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllEntries")
	public ResponseEntity<List<ImportDetailsDto>> getAllEntries(){
		 List<ImportDetailsDto> allEntries = this.sugarcaneEntryService.getAllEntries();
		return new ResponseEntity<>(allEntries,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteEntry/{entryId}")
	public ResponseEntity<?>deleteEntry(@PathVariable("entryId")Integer entryId){
		this.sugarcaneEntryService.deleteEntry(entryId);
		return  ResponseEntity.ok("Entry Deleted Sucessfully!!!");
	}
	
	@GetMapping(value="/getEntryById/{entryId}")
	public ResponseEntity<ImportDetailsDto> getEntryById(@PathVariable("entryId")Integer entryId){
		ImportDetailsDto entryById = this.sugarcaneEntryService.getEntryById(entryId);
		return new ResponseEntity<>(entryById,HttpStatus.OK);
	}
	
	@GetMapping(value="/getImportEntriesByDate")
	public ResponseEntity<List<ImportDetailsDto>> getImportEntriesByDate(@RequestParam("date") Date date){
		List<ImportDetailsDto> importEntriesByDate = this.sugarcaneEntryService.getImportEntriesByDate(date);
		return new ResponseEntity<>(importEntriesByDate,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllEntriesOfFarmer")
	public ResponseEntity<List<ImportDetailsDto>> getAllEntriesOfFamrer(@RequestParam("farmerId") Integer farmerId){
		List<ImportDetailsDto> importEntriesByFarmer= this.sugarcaneEntryService.getAllEntriesOfFamrer(farmerId);
		return new ResponseEntity<>(importEntriesByFarmer,HttpStatus.OK);
	}
	

}
