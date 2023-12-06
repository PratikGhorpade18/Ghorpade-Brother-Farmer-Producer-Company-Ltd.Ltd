package com.gbfpcl.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gbfpcl.entities.ExportDetails;

public interface ExportDetailsRepo extends JpaRepository<ExportDetails, Integer> {
	
	@Query("SELECT i FROM ExportDetails i WHERE FUNCTION('DATE',i.exportDate)= FUNCTION('DATE',:date)")
	 List<ExportDetails> findExportEntriesOnDate(@Param("date") Date date);

}
