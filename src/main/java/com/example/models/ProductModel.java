package com.example.models;

import com.example.entities.Product;

import java.util.*;

public class ProductModel {
	
	public Product find() {
		return new Product("p01", "name1", 5.8, 2, true);
	}
	
	public List<Product> findAll(){
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p01", "name1", 5.8, 2, true));
		products.add(new Product("p02", "name2", 5.5, 1, true));
		products.add(new Product("p03", "name3", 5.0, 3, false));
		return products;
	}

	public Map<String, Product> findAllReturnMap(){
		Map<String, Product> products = new HashMap<>();
		products.put("a1", new Product("p01", "name1", 5.8, 2, true));
		products.put("a2", new Product("p02", "name2", 5.5, 1, true));
		products.put("a3", new Product("p03", "name3", 5.0, 3, false));
		return products;
	}

	public Set<Product> findAllReturnSet(){
		Set<Product> products = new HashSet<>();
		products.add(new Product("p01", "name1", 5.8, 2, true));
		products.add(new Product("p01", "name2", 5.5, 1, true));
		products.add(new Product("p03", "name3", 5.0, 3, false));
		return products;
	}
}
