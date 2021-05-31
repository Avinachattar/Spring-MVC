package com.zensar.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zensar.spring.Product;
import com.zensar.spring.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping("/productDetail")
	public String productDetail() {
		return "productDetail";

	}

	@RequestMapping("/insertProduct")
	public String insertProduct(@ModelAttribute Product product, Model model) {
		Product insertedProduct = service.insertProduct(product);
		System.out.println(insertedProduct);
		model.addAttribute("insertedProduct", insertedProduct);
		return "insertProduct";
	}

	@RequestMapping("/getProduct")
	public String getProduct() {
		return "getProduct";
	}

	@RequestMapping("/getProductById")
	public String getProductById(@RequestParam("productId") int productId, Model model) {
		System.out.println("hi");
		Product p = service.getProductById(productId);
		if (p.getProductId() == productId) {
			model.addAttribute("product", p);
			return "getProductById";
		} else {
			return "getProductError";
		}
	}

	@RequestMapping("/getAllProducts")
	public String getAllProducts(Model model) {
		List<Product> list = service.getAllProducts();
		System.out.println(list);
		model.addAttribute("list", list);
		return "getAllProducts";
	}

	@RequestMapping("/deleteProductById")
	public String deleteProductById() {
		return "deleteProductById";
	}

	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") int productId, Model model) {
		Product p = service.deleteProduct(productId);
		if (p.getProductId() == productId) {
			model.addAttribute("product", p);
			return "deleteProduct";
		} else {
			return "deleteError";
		}

	}

	@RequestMapping("/updatedProduct")
	public String updatedProduct() {
		return "updatedProduct";
	}

	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute Product product,@RequestParam("productId") int productId, Model model) {
		Product updatedProduct = service.updateProduct(productId, product);
		System.out.println(updatedProduct);
		if (updatedProduct.getProductId() == productId) {
			model.addAttribute("updatedProduct", updatedProduct);
			return "updateProduct";
		} else {
			return "getProductError";
		}

	}
}
