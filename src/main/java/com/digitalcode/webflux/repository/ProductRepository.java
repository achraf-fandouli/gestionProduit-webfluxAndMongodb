package com.digitalcode.webflux.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.digitalcode.webflux.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByCategory(String category);
	
	@Query("{price : ?0}")
	List<Product> findProductsByPrice(Long price);

}
