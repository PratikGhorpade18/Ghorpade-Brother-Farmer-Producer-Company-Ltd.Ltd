package com.gbfpcl.controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.gbfpcl.dtos.ExportDetailDto;
import com.gbfpcl.entities.ExportDetails;
import com.gbfpcl.service.ExportDetailsService;

@RestController
@RequestMapping("/Ghorpade-Brother/Export/")
@CrossOrigin
public class ExportDetailsController {
	@Autowired
	private ExportDetailsService exportDetailsService;
	
	@PostMapping(value="addExportEntry",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExportDetailDto> addExportEntry(@Valid @RequestBody ExportDetailDto exportDetails) {
		ExportDetailDto addEntry = this.exportDetailsService.addExportEntry(exportDetails);
		return new ResponseEntity<>(addEntry,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/editExportEntry/{entryId}")
	public ResponseEntity<ExportDetails> editExportEntry(@Valid @RequestBody ExportDetails exportdetails,@PathVariable("entryId")Integer entryId) {
		ExportDetails update = this.exportDetailsService.editExportEntry(entryId,exportdetails);
		return new ResponseEntity<ExportDetails>(update,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllExportEntries")
	public ResponseEntity<List<ExportDetails>> getAllExportEntries(){
		 List<ExportDetails> allEntries = this.exportDetailsService.getAllExportEntries();
		return new ResponseEntity<>(allEntries,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteExportEntry/{entryId}")
	public ResponseEntity<?>deleteExportEntry(@PathVariable("entryId")Integer entryId){
		this.exportDetailsService.deleteExportEntry(entryId);
		Map<String,String> map= new HashMap<>();
		map.put("message", "Export Entry Deleted Sucessfully!!!");
		return  ResponseEntity.ok(map);
	}
	
	@GetMapping(value="/getExportEntryById/{entryId}")
	public ResponseEntity<ExportDetails> getExportEntryById(@PathVariable("entryId")Integer entryId){
		ExportDetails entryById = this.exportDetailsService.getExportEntryById(entryId);
		return new ResponseEntity<>(entryById,HttpStatus.OK);
	}
	
	@GetMapping(value="/getExportEntriesOndate")
	public ResponseEntity<List<ExportDetails>> getExportEntriesOndate(@RequestParam("exportDate")Date date){
		return new ResponseEntity<>(this.exportDetailsService.getExportEntriesOndate(date),HttpStatus.OK);
	}
	


}
