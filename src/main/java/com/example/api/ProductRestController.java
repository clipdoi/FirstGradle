package com.example.api;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Product;
import com.example.models.ProductModel;

@RestController
@RequestMapping("api/product")
public class ProductRestController {
	
	@RequestMapping(value="find", method= RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> find(){
		try {
			ProductModel productModel = new ProductModel();
			return new ResponseEntity<Product>(productModel.find(), HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="findAll", method= RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findAll(){
		try {
			ProductModel productModel = new ProductModel();
			return new ResponseEntity<List<Product>>(productModel.findAll(), HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="create", method= RequestMethod.POST, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> create(@RequestBody Product product){
		try {
			System.out.println("id: " + product.getId());
			System.out.println("name: "+product.getName());
			product.setId("tv99");
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="update", method= RequestMethod.PUT, 
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> update(@RequestBody Product product){
		try {
			System.out.println("id: " + product.getId());
			System.out.println("name: "+product.getName());
			product.setId("tv100");
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="delete/{id}", method= RequestMethod.DELETE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> delete(@PathVariable("id") Integer id){
		try {
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="findAllReturnMap", method= RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Product>> findAllReturnMap(){
		try {
			ProductModel productModel = new ProductModel();
			return new ResponseEntity<>(productModel.findAllReturnMap(), HttpStatus.OK);

		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="findAllReturnSet", method= RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Product>> findAllReturnSet(){
		try {
			ProductModel productModel = new ProductModel();
			return new ResponseEntity<>(productModel.findAllReturnSet(), HttpStatus.OK);

		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="convertJsonToList", method= RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE
			, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findAll(@RequestBody String request){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			List<Product> products = objectMapper.readValue(request, new TypeReference<List<Product>>(){});
			return new ResponseEntity<>(products, HttpStatus.OK);

		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="convertJsonToMap", method= RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE
			, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findAllFromMap(@RequestBody String request){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Product> map = objectMapper.readValue(request, HashMap.class);
			List<Product> products = map.entrySet()
					.stream()
					.map(Map.Entry::getValue)
					.collect(Collectors.toList());
			return new ResponseEntity<>(products, HttpStatus.OK);

		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="convertJsonToSet", method= RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE
			, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Product>> findAllFromSet(@RequestBody String request){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Product> map = objectMapper.readValue(request, HashMap.class);
			Set<Product> products = map.entrySet()
					.stream()
					.map(Map.Entry::getValue)
					.collect(Collectors.toSet());
			return new ResponseEntity<>(products, HttpStatus.OK);

		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="convertJsonToSetFromSet", method= RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE
			, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Product>> findAllFromJsonSet(@RequestBody String request){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Set<Product> products = objectMapper.readValue(request, HashSet.class);
			return new ResponseEntity<>(products, HttpStatus.OK);

		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
