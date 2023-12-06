package com.gbfpcl.service;

import java.sql.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gbfpcl.dtos.ExportDetailDto;
import com.gbfpcl.entities.ExportDetails;

public interface ExportDetailsService {

	ExportDetailDto addExportEntry( ExportDetailDto exportDetails);

	List<ExportDetails> getAllExportEntries();

	void deleteExportEntry(Integer entryId);

	ExportDetails getExportEntryById(Integer entryId);

	ExportDetails editExportEntry(Integer entryId, ExportDetails exportdetails);

	List<ExportDetails> getExportEntriesOndate(Date date);

}
