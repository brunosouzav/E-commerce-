package com.ecommerce.project.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.project.entities.Product;
import com.ecommerce.project.exceptions.ProductNotFoundException;
import com.ecommerce.project.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public void criateProduct(Product product) {
		repository.save(product);
	}

	public List<Product> getAllProduct() {
		return repository.findAll();
	}

	public Product findByProductId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Produto com id" + id + "não encontrado"));
	}
	
	public Product updateProduct(Long id, Product product) {
		 Product newProduct = findByProductId(id);

		
		    newProduct.setName(product.getName());
		    newProduct.setPrice(product.getPrice());
		    newProduct.setQuantity(product.getQuantity());

		   
		    return repository.save(newProduct);
	}

	public void deleteProduct(Long id) {
		findByProductId(id);
		repository.deleteById(id);
	}
}
