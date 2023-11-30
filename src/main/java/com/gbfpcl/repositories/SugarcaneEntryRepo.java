package com.gbfpcl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbfpcl.entities.SugarcaneEntry;
@Repository
public interface SugarcaneEntryRepo extends JpaRepository<SugarcaneEntry, Integer>{

}
