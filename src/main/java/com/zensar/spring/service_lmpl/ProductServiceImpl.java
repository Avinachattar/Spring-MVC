package com.zensar.spring.service_lmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.spring.Product;
import com.zensar.spring.repository.ProductRepository;
import com.zensar.spring.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Product insertProduct(Product product) {
		return repo.insertProduct(product);

	}

	@Override
	public Product getProductById(int productId) {
		return repo.getProductById(productId);
	}

	@Override
	public Product deleteProduct(int productId) {
		return repo.deleteProduct(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return repo.getAllProducts();
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Product p = repo.getProductById(productId);
		if (p.getProductId() != 0) {
			Product product2 = repo.updateProduct(productId, product);
			return product2;
		} else {
			return new Product(0, "", 0);
		}
	}

}
