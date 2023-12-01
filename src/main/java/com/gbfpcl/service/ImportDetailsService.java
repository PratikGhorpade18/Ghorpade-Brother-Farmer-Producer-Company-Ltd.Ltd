package com.gbfpcl.service;

import java.util.List;

import com.gbfpcl.dtos.ImportDetailsDto;

public interface ImportDetailsService {

	ImportDetailsDto addEntry(ImportDetailsDto sugarcaneEntryDto, Integer farmerId);

	ImportDetailsDto updateEntry(Integer entryId, ImportDetailsDto sugarcaneEntryDto, Integer farmerId);

	List<ImportDetailsDto> getAllEntries();

	void deleteEntry(Integer entryId);

	ImportDetailsDto getEntryById(Integer entryId);

}
