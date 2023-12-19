package com.product.productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.productservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	boolean existsByProductname(String productname); 
	
	
	
	
	
	
	
	
	
}
