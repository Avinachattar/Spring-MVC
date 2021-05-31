package com.zensar.spring.service;

import java.util.List;

import com.zensar.spring.Product;

public interface ProductService {

	public Product insertProduct(Product product);

	public Product getProductById(int productId);
	
	public Product deleteProduct(int productId);
	
	public List<Product> getAllProducts();
	
	public Product updateProduct(int productId,Product product);

}
