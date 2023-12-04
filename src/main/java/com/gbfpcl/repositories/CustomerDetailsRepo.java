package com.gbfpcl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbfpcl.entities.CustomerDetails;

public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails, Integer> {

}
