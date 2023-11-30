package com.gbfpcl.service;

import java.util.List;

import com.gbfpcl.dtos.SugarcaneEntryDto;

public interface SugarcaneEntryService {

	SugarcaneEntryDto addEntry(SugarcaneEntryDto sugarcaneEntryDto, Integer farmerId);

	SugarcaneEntryDto updateEntry(Integer entryId, SugarcaneEntryDto sugarcaneEntryDto, Integer farmerId);

	List<SugarcaneEntryDto> getAllEntries();

	void deleteEntry(Integer entryId);

	SugarcaneEntryDto getEntryById(Integer entryId);

}
