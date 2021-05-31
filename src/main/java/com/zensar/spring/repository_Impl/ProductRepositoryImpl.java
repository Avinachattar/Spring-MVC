package com.zensar.spring.repository_Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zensar.spring.Product;
import com.zensar.spring.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Product insertProduct(Product product) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		return product;

	}

	@Override
	public Product getProductById(int productId) {
		Session session = getSessionFactory().openSession();
		Product product = null;
		product = session.get(Product.class, productId);
		if (product != null) {
			return product;
		} else {
			return new Product(0, "", 0);
		}
	}

	@Override
	public Product deleteProduct(int productId) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Product product = session.get(Product.class, productId);
		if (product != null) {
			Query<Product> query = session.createQuery("delete from Product where productId=:productId");
			query.setParameter("productId", productId);
			query.executeUpdate();
			session.getTransaction().commit();
			return product;
		} else {
			return new Product(0, "", 0);
		}
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = new ArrayList<Product>();
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Query<Product> query = session.createQuery("from Product");
		list = query.list();
		session.getTransaction().commit();
		return list;

	}

	@Override
	public Product updateProduct(int productId, Product updatedProduct) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "UPDATE Product  set productName = :productName,  productCost = :productCost "
				+ "where productId = :productId";

		Query<Product> query = session.createQuery(hql);
		query.setParameter("productId", updatedProduct.getProductId());
		query.setParameter("productName", updatedProduct.getProductName());
		query.setParameter("productCost", updatedProduct.getProductCost());
		query.executeUpdate();
		session.getTransaction().commit();
		return updatedProduct;

	}

}
