package com.gbfpcl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbfpcl.entities.Farmer;

@Repository
public interface FarmerRepo extends JpaRepository<Farmer,Integer> {

}
