package com.gbfpcl.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.gbfpcl.dtos.DailyProductionDetailsDto;
import com.gbfpcl.entities.DailyProductionDetails;
import com.gbfpcl.entities.Farmer;
import com.gbfpcl.entities.ProductMaster;

public interface DailyReportService {

	DailyProductionDetailsDto addDailyReportl( DailyProductionDetailsDto dailyProductionDetails);



	DailyProductionDetails updateDailyReport(Integer dailyReportId,
			DailyProductionDetails dailyProductionDetails);

	void deleteDailyReport(Integer dailyReportId);

	DailyProductionDetails getDailyReportId(Integer dailyReportId);

	List<DailyProductionDetails> getAll();



	Map<String,Integer> getTotalProductionProductWise();

}
