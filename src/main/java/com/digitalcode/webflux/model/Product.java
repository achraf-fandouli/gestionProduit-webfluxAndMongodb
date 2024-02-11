package com.digitalcode.webflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection = "products")
@Data
@AllArgsConstructor
public class Product {

	@Id
	private String id;
	private String name;
	private String category;
	private Long price;
}
