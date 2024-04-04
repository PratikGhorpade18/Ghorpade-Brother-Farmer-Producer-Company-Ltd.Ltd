package com.gbfpcl.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbfpcl.dtos.FarmerDto;
import com.gbfpcl.entities.Farmer;
import com.gbfpcl.entities.ProductMaster;
import com.gbfpcl.service.ProductService;

@RestController
@RequestMapping("/Ghorpade-Brother/Product/")
@CrossOrigin
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping(value="/addProduct")
	public ResponseEntity<ProductMaster> addProduct(@RequestBody ProductMaster productMaster){
		ProductMaster addProduct = productService.addProduct(productMaster);
		return new ResponseEntity<>(addProduct,HttpStatus.CREATED);
	}
	
	@PutMapping(value="/updateProduct/{productId}")
	public ResponseEntity<ProductMaster> updateMaster(@RequestBody ProductMaster productMaster,@PathVariable("productId")Integer productId){
		ProductMaster updateProduct = productService.updateProduct(productMaster,productId);
		return new ResponseEntity<>(updateProduct,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllProducts")
	public ResponseEntity<List<ProductMaster>> getAllProducts(){
		return new ResponseEntity<>(this.productService.getAllProducts(),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping(value="/deleteProduct/{productId}")
	public ResponseEntity<?> deleteProductById(@PathVariable(name="productId")Integer productId){
		Map<String,String> map= new HashMap<>();
		this.productService.deleteProduct(productId);
		map.put("message", "Product Deleted Sucessfully!!!");
		return  ResponseEntity.ok(map);
	}
	
	@GetMapping(value="/getProductById/{productId}")
	public ResponseEntity<ProductMaster> getFarmerbyId(@PathVariable(name="productId")Integer productId){
		ProductMaster productMaster = this.productService.getProductById(productId);
		return new ResponseEntity<ProductMaster>(productMaster,HttpStatus.OK);
	}
	
}
