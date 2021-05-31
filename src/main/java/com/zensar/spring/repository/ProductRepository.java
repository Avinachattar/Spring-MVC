package com.zensar.spring.repository;

import java.util.List;

import com.zensar.spring.Product;

public interface ProductRepository {
	
	public Product insertProduct(Product product);
	
	public Product getProductById(int productId);
	
	public Product deleteProduct(int productId);
	
	public List<Product> getAllProducts();
	
	Product updateProduct(int productId, Product product);

}
