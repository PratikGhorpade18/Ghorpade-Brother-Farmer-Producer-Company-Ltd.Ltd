package com.gbfpcl.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gbfpcl.dtos.DailyProductionDetailsDto;
import com.gbfpcl.dtos.FarmerDto;
import com.gbfpcl.entities.DailyProductionDetails;
import com.gbfpcl.entities.Farmer;
import com.gbfpcl.entities.ProductMaster;
import com.gbfpcl.service.DailyReportService;
import com.gbfpcl.service.ExportDetailsService;

@RestController
@RequestMapping("/Ghorpade-Brother/DailyReport")
@CrossOrigin
public class DailyProductionController {
	
	@Autowired
	private DailyReportService dailyReportService;
	
	@Autowired
	private ExportDetailsService exportDetailsService;
	
	
	@PostMapping(value="/addDailyReport")
	@ResponseBody public ResponseEntity<DailyProductionDetailsDto> addDailyReport( @Valid @RequestBody DailyProductionDetailsDto dailyProductionDetails){
		DailyProductionDetailsDto created=this.dailyReportService.addDailyReportl(dailyProductionDetails);
		return new ResponseEntity<DailyProductionDetailsDto>(created,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getAllDailyReport")
	public ResponseEntity<List<DailyProductionDetails>> getAllDailyReport(){
		return new ResponseEntity<List<DailyProductionDetails>>	(this.dailyReportService.getAll(),HttpStatus.OK);
	}
	
	@PutMapping(value="/updateDailyReport/{dailyReportId}")
	public ResponseEntity<DailyProductionDetails> updateDailyReport(@Valid @RequestBody DailyProductionDetails dailyProductionDetails,  @PathVariable(name="dailyReportId")Integer dailyReportId){
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
	
	@GetMapping(value="/getAllStockData")
	public ResponseEntity<Map<String,Map<String,Integer>>> getAllStockData()
	{
		Map<String,Map<String,Integer>> resultMap =new HashMap<>();
		
		Map<String, Integer> availableMap = new HashMap<>();
		Map<String, Integer> exportedMap =this.exportDetailsService.getExportedProductWise();
		Map<String, Integer> totalMap = this.dailyReportService.getTotalProductionProductWise();
		
		availableMap=totalMap.entrySet().stream()
         .collect(HashMap::new,
                 (map, entry) -> map.put(entry.getKey(), entry.getValue() - exportedMap.getOrDefault(entry.getKey(), 0)),
                 HashMap::putAll);
		
		resultMap.put("Exported ",exportedMap );
		resultMap.put("Total Production",totalMap );
		resultMap.put("Avilable",availableMap );
		
		return new ResponseEntity<>(resultMap,HttpStatus.OK);
	}
}
