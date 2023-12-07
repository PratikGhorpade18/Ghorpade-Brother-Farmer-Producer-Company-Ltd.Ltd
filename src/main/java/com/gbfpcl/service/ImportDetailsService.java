package com.gbfpcl.service;

import java.sql.Date;
import java.util.List;

import com.gbfpcl.dtos.ImportDetailsDto;
import com.gbfpcl.entities.ImportDetails;

public interface ImportDetailsService {

	ImportDetailsDto addEntry(ImportDetailsDto sugarcaneEntryDto);

	ImportDetailsDto updateEntry(Integer entryId, ImportDetailsDto sugarcaneEntryDto);

	List<ImportDetailsDto> getAllEntries();

	void deleteEntry(Integer entryId);

	ImportDetailsDto getEntryById(Integer entryId);

	List<ImportDetailsDto> getImportEntriesByDate(Date date);

	List<ImportDetailsDto> getAllEntriesOfFamrer(Integer farmerId);

}
