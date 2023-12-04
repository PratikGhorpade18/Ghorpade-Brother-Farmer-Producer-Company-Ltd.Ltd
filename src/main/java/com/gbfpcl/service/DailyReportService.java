package com.gbfpcl.service;

import java.util.List;

import javax.validation.Valid;

import com.gbfpcl.entities.DailyProductionDetails;
import com.gbfpcl.entities.Farmer;

public interface DailyReportService {

	DailyProductionDetails addDailyReportl(@Valid DailyProductionDetails dailyProductionDetails, Integer productId);



	DailyProductionDetails updateDailyReport(Integer dailyReportId,
			DailyProductionDetails dailyProductionDetails);

	void deleteDailyReport(Integer dailyReportId);

	DailyProductionDetails getDailyReportId(Integer dailyReportId);

	List<DailyProductionDetails> getAll();

}
