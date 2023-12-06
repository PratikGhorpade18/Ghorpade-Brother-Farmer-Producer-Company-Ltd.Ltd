package com.gbfpcl.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gbfpcl.entities.ImportDetails;

import java.sql.Date;
import java.sql.Timestamp;

@Repository
public interface ImportDetailsRepo extends JpaRepository<ImportDetails, Integer>{
	
	 @Query("SELECT i FROM ImportDetails i WHERE FUNCTION('DATE', i.entryDateTime) = FUNCTION('DATE', :date)")
	    List<ImportDetails> findByEntryDateTime(@Param("date") Date date);
}
