package com.ecommerce.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.project.entities.Product;
import com.ecommerce.project.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		service.criateProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> listProduct= service.getAllProduct();
			return ResponseEntity.status(HttpStatus.OK).body(listProduct);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> findByProduct(@PathVariable Long id) {
	    Product product = service.findByProductId(id);  
	    	return ResponseEntity.status(HttpStatus.OK).body(product);  
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

	    Product updatedProduct = service.updateProduct(id, product);

	 
	    return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity <Void> deleteProduct(@PathVariable Long id){
		service.findByProductId(id);
		service.deleteProduct(id); 
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
