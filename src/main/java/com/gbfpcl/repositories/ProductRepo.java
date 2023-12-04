package com.gbfpcl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gbfpcl.entities.ProductMaster;

@Repository
public interface ProductRepo extends JpaRepository<ProductMaster, Integer>{

}
