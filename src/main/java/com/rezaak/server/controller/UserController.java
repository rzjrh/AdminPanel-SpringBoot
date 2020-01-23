package com.rezaak.server.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rezaak.server.model.Role;
import com.rezaak.server.model.Transaction;
import com.rezaak.server.model.User;
import com.rezaak.server.service.ProductService;
import com.rezaak.server.service.TransactionService;
import com.rezaak.server.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/api/user/registration")
	public ResponseEntity<?> register (@RequestBody User user){
		//check if username exist or not(username should be unique)
		if (userService.findByUsername(user.getUsername()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		//user is a default role
		user.setRole(Role.USER);
		return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
		
	}
	
	@GetMapping("/api/user/login")
	public ResponseEntity<?> getUser (Principal principal) {
		if(principal == null || principal.getName() == null ) {
			return ResponseEntity.ok(principal);
		}
		return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
	}
	
	@PostMapping("api/user/purchase")
	public ResponseEntity<?> purchaseProduct (@RequestBody Transaction transaction) {
		transaction.setPurchaseDate(LocalDateTime.now());
		return new ResponseEntity<> (transactionService.saveTransaction(transaction), HttpStatus.CREATED) ;
		
	}
	
	@GetMapping("api/user/products")
	public ResponseEntity<?> getAllProducts(){
		return new ResponseEntity<> (productService.findAllProducts(), HttpStatus.OK);
		
	}
	
	
	
	
	
	
}
