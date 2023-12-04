package com.gbfpcl.service;

import java.util.List;

import com.gbfpcl.entities.ExportDetails;

public interface ExportDetailsService {

	ExportDetails addExportEntry( ExportDetails exportDetails);

	List<ExportDetails> getAllExportEntries();

	void deleteExportEntry(Integer entryId);

	ExportDetails getExportEntryById(Integer entryId);

	ExportDetails editExportEntry(Integer entryId, ExportDetails exportdetails);

}
