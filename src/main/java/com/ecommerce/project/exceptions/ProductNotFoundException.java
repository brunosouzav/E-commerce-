package com.ecommerce.project.exceptions;

public class ProductNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException (String mensage) {
		super(mensage);
	}
}
