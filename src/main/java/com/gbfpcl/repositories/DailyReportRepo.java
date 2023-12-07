package com.gbfpcl.repositories;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gbfpcl.entities.DailyProductionDetails;

public interface DailyReportRepo extends JpaRepository<DailyProductionDetails, Integer> {
	


	
}
