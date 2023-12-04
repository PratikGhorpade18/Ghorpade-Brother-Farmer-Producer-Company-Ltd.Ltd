package com.gbfpcl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbfpcl.entities.DailyProductionDetails;

public interface DailyReportRepo extends JpaRepository<DailyProductionDetails, Integer> {

}
