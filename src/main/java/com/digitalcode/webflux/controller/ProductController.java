package com.digitalcode.webflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcode.webflux.model.Product;
import com.digitalcode.webflux.service.ProductService;

@RestController("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}

	@GetMapping
	public List<Product> getProducts() {
		return productService.findAllProduct();
	}

	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable String productId) {
		return productService.getProductById(productId);
	}

	@GetMapping("/{category}")
	public List<Product> getProductByCategory(@PathVariable String category) {
		return productService.getProductByCategory(category);
	}

	@GetMapping("/{price}")
	public List<Product> getProductByPrice(@PathVariable Long price) {
		return productService.getProductByPrice(price);
	}

	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

	@DeleteMapping("{productId}")
	public String deleteProduct(@PathVariable String productId) {
		return productService.deleteProduct(productId);
	}

}
