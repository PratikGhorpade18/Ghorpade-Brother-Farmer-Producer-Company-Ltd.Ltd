package com.gbfpcl.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import com.gbfpcl.entities.DailyProductionDetails;
import com.gbfpcl.entities.Farmer;
import com.gbfpcl.service.DailyReportService;

@RestController
@RequestMapping("/Ghorpade-Brother/DailyReport/")
public class DailyProductionController {
	
	@Autowired
	private DailyReportService dailyReportService;
	
	
	@PostMapping(value="/addDailyReport/{productId}")
	public ResponseEntity<DailyProductionDetails> addDailyReport( @Valid @RequestBody DailyProductionDetails dailyProductionDetails,@PathVariable("productId")Integer productId){
		DailyProductionDetails created=this.dailyReportService.addDailyReportl(dailyProductionDetails,productId);
		return new ResponseEntity<DailyProductionDetails>(created,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getAllDailyReport")
	public ResponseEntity<List<DailyProductionDetails>> getAllDailyReport(){
		return new ResponseEntity<List<DailyProductionDetails>>	(this.dailyReportService.getAll(),HttpStatus.OK);
	}
	
	@PutMapping(value="/updateDailyReport/{dailyReportId}")
	public ResponseEntity<DailyProductionDetails> updateDailyReport(@Valid @RequestBody DailyProductionDetails dailyProductionDetails,  @PathVariable(name="dailyReportId")Integer dailyReportId,HttpServletRequest request){
		DailyProductionDetails updateDailyReport = this.dailyReportService.updateDailyReport(dailyReportId,dailyProductionDetails);
		return new ResponseEntity<DailyProductionDetails>(updateDailyReport,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteDailyReport/{dailyReportId}")
	public ResponseEntity<?> deleteFarmerById(@PathVariable(name="dailyReportId")Integer dailyReportId){
		this.dailyReportService.deleteDailyReport(dailyReportId);
		return  ResponseEntity.ok("Report Deleted Sucessfully!!!");
	}
	
	@GetMapping(value="/getDailyReportId/{dailyReportId}")
	public ResponseEntity<DailyProductionDetails> getDailyReportId(@PathVariable(name="dailyReportId")Integer dailyReportId){
		DailyProductionDetails dailyProductionDetails = this.dailyReportService.getDailyReportId(dailyReportId);
		return new ResponseEntity<DailyProductionDetails>(dailyProductionDetails,HttpStatus.OK);
	}
	

}
