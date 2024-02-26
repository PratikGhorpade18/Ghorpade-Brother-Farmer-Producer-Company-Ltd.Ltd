package com.gbfpcl.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbfpcl.entities.AdminMaster;
@Repository
public interface AdminRepo extends JpaRepository<AdminMaster, Integer>{
	
	Optional<AdminMaster> findByUsername(String userName);

}
