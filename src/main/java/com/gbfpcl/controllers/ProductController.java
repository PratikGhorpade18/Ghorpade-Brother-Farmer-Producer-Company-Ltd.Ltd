package com.gbfpcl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbfpcl.entities.ProductMaster;
import com.gbfpcl.service.ProductService;

@RestController
@RequestMapping("/Ghorpade-Brother/Product/")
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping(value="/addProduct")
	public ResponseEntity<ProductMaster> addProduct(@RequestBody ProductMaster productMaster){
		System.out.println("-----------");
		ProductMaster addProduct = productService.addProduct(productMaster);
		return new ResponseEntity<>(addProduct,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/updateProduct/{productId}")
	public ResponseEntity<ProductMaster> updateMaster(@RequestBody ProductMaster productMaster,@PathVariable("productId")Integer productId){
		ProductMaster updateProduct = productService.updateProduct(productMaster,productId);
		return new ResponseEntity<>(updateProduct,HttpStatus.OK);
	}
	
}
