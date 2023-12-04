package com.gbfpcl.serviceImpl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.gbfpcl.entities.DailyProductionDetails;
import com.gbfpcl.service.DailyReportService;

@Service
public class DailyReportServiceImpl  implements DailyReportService{

	@Override
	public DailyProductionDetails addDailyReportl(@Valid DailyProductionDetails dailyProductionDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAllDailyReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DailyProductionDetails updateDailyReport(Integer dailyReportId,
			DailyProductionDetails dailyProductionDetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDailyReport(Integer dailyReportId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DailyProductionDetails getDailyReportId(Integer dailyReportId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DailyProductionDetails> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
