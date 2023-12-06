package com.gbfpcl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbfpcl.entities.CustomerDetails;
@Repository
public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails, Integer> {

}
