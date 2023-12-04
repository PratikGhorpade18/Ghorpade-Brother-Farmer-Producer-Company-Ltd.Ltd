package com.gbfpcl.serviceImpl;

import java.util.List;

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

	@Override
	public void deleteProduct(Integer productId) {
		this.productRepo.deleteById(productId);
		
	}

	@Override
	public List<ProductMaster> getAllProducts() {
		return this.productRepo.findAll();
	}

	@Override
	public ProductMaster getProductById(Integer productId) {
		return this.productRepo.findById(productId).orElseThrow(()->new ResourceNotFoundException("product", "productId", productId));
	}

}
