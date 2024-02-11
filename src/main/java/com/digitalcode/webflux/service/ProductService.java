package com.digitalcode.webflux.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalcode.webflux.model.Product;
import com.digitalcode.webflux.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public Product addProduct(Product product) {
		product.setId(UUID.randomUUID().toString().split("-")[0]);
		return repository.save(product);
	}

	public List<Product> findAllProduct() {
		return repository.findAll();
	}

	public Product getProductById(String id) {
		return repository.findById(id).get();
	}

	public List<Product> getProductByCategory(String category) {
		return repository.findByCategory(category);
	}
	
	public List<Product> getProductByPrice(Long price) {
		return repository.findProductsByPrice(price);
	}

	public Product updateProduct(Product product) {
		// get the existing document from DB
		// populate new value from request to existing object
		Product existingProduct = repository.findById(product.getId()).get();
		existingProduct.setName(product.getName());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);
	}

	public String deleteProduct(String productId) {
		repository.deleteById(productId);
		return productId + " Product deleted";
	}
}
