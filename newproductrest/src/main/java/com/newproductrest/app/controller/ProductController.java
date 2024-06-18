package com.newproductrest.app.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newproductrest.app.constants.ResponseKey;
import com.newproductrest.app.constants.ResponseMessage;
import com.newproductrest.app.model.Product;
import com.newproductrest.app.service.ProductService;

@RestController // combo of responsebody and controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public ResponseEntity<Object> findAll() {
		try {
			List<Product> productslist = productService.findAll();
			HashMap<String, String> data = new HashMap<>();
			if (productslist.isEmpty()) {
				data.put(ResponseKey.MESSAGE, ResponseMessage.NO_PRODUCT_FOUND);
				return new ResponseEntity<>(data, HttpStatus.NO_CONTENT);
			} else {
				HashMap<String, Object> data = new HashMap<>();
				data.put(ResponseKey.COUNT, productService.countAll());
				data.put(ResponseKey.PRODUCTS, productslist);
				return new ResponseEntity<>(data, HttpStatus.OK);
			}
		} catch (Exception e) {
			HashMap<String, Object> data = new HashMap<>();
			data.put(ResponseKey.MESSAGE, ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/")
	public Product save(@RequestBody Product product) {
		HashMap<String, String> data = new HashMap<>();
		try {
			Product savedproduct = productService.save(product);
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} catch (Exception e) {
			data.put(ResponseKey.MESSAGE, ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/by-name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		HashMap<String, String> data = new HashMap<>();
		try {
			List<Product> productsList = productService.findByName(name);
			return new ResponseEntity<>(productsList,HttpStatus.OK);
		} catch (Exception  e) {
			data.put(ResponseKey.MESSAGE, ResponseMessage.SOMETHING_WENT_WRONG);
			return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
