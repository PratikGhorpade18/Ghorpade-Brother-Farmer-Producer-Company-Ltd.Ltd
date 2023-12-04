package com.gbfpcl.service;

import java.util.List;

import com.gbfpcl.entities.ProductMaster;

public interface ProductService  {

	ProductMaster addProduct(ProductMaster productMaster);

	ProductMaster updateProduct(ProductMaster productMaster, Integer productId);

	void deleteProduct(Integer productId);

	List<ProductMaster> getAllProducts();

	ProductMaster getProductById(Integer productId);

}
