package com.rezaak.server.service;

import java.util.List;

import com.rezaak.server.model.Product;

public interface ProductService {

	Product saveProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(Long productId);

	Long numberOfProdicts();

	List<Product> findAllProducts();


}
