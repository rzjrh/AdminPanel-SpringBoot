package com.rezaak.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rezaak.server.model.Product;

public interface ProductRepository extends JpaRepository <Product, Long>{

	
}
