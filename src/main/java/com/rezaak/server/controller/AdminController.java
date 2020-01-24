package com.rezaak.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rezaak.server.model.Product;
import com.rezaak.server.model.StringResponse;
import com.rezaak.server.model.User;
import com.rezaak.server.service.ProductService;
import com.rezaak.server.service.TransactionService;
import com.rezaak.server.service.UserService;

@RestController
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TransactionService transactionService;
	
	
	@PutMapping("/api/admin/user-update")
	public ResponseEntity<?> updateUser (@RequestBody User user){
		User existUser = userService.findByUsername(user.getUsername());
		if (existUser != null && !existUser.getId().equals(user.getId())) {
			return new ResponseEntity<> (HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
	}
	
	//we can also use @DeleteMapping
	@PostMapping ("/api/admin/user-delete")
	public ResponseEntity<?> deleteUser (@RequestBody User user){
	userService.deleteUser(user.getId());
	return new ResponseEntity<> (HttpStatus.OK);
	}
	
	@GetMapping ("/api/admin/user-all")
	public ResponseEntity<?> findAllUsers (){
		return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
	}
	
	
	@GetMapping ("/api/admin/user-number")
	public ResponseEntity<?> numberOfUsers(){
		Long number = userService.numberOfUsers();
		StringResponse response = new StringResponse();
		response.setResponse(number.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping ("/api/admin/product-create")
	public ResponseEntity<?> createProduct (@RequestBody Product product){
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
	}
	
	
	@PutMapping("/api/admin/product-update")
	public ResponseEntity<?> updateProduct (@RequestBody Product product){
		
		return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
	}
	
	@PostMapping ("/api/admin/product-delete")
	public ResponseEntity<?> deleteProduct (@RequestBody Product product){
		productService.deleteProduct(product.getId()); 
	return new ResponseEntity<> (HttpStatus.OK);
	}
	
	
	@GetMapping ("/api/admin/product-all")
	public ResponseEntity<?> findAllProducts (){
		return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping ("/api/admin/product-number")
	public ResponseEntity<?> numberOfProducts(){
		Long number = productService.numberOfProducts();
		StringResponse response = new StringResponse();
		response.setResponse(number.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping ("/api/admin/transaction-all")
	public ResponseEntity<?> findAllTransactions (){
		return new ResponseEntity<>(transactionService.findAllTransactions(), HttpStatus.OK);
	}
	
	@GetMapping ("/api/admin/transaction-number")
	public ResponseEntity<?> numberOfTransactions(){
		Long number = transactionService.numberOfTransactions();
		StringResponse response = new StringResponse();
		response.setResponse(number.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
}
