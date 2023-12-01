package com.gbfpcl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbfpcl.entities.ImportDetails;
@Repository
public interface ImportDetailsRepo extends JpaRepository<ImportDetails, Integer>{

}
