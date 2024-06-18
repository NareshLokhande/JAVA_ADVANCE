package com.newproductrest.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newproductrest.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	static List<Product> findByName() {

		return null;
	}


}
