package com.gbfpcl.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbfpcl.entities.ProductMaster;
import com.gbfpcl.exceptions.ResourceNotFoundException;
import com.gbfpcl.repositories.ProductRepo;
import com.gbfpcl.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired
ProductRepo productRepo;

	@Override
	public ProductMaster addProduct(ProductMaster productMaster) {
		return this.productRepo.save(productMaster);
	}

	@Override
	public ProductMaster updateProduct(ProductMaster productMaster,Integer productId) {
		ProductMaster orElseThrow = this.productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product", "productId", productId));
		orElseThrow.setProductName(productMaster.getProductName());
		orElseThrow.setCreatedDate(productMaster.getCreatedDate());
		return this.productRepo.save(orElseThrow);
	}

}
