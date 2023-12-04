package com.gbfpcl.service;

import com.gbfpcl.entities.ProductMaster;

public interface ProductService  {

	ProductMaster addProduct(ProductMaster productMaster);

	ProductMaster updateProduct(ProductMaster productMaster, Integer productId);

}
