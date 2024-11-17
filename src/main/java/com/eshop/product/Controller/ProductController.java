package com.eshop.product.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.product.entity.Product;
import com.eshop.product.service.productService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

	
	@Autowired
	private productService pService;
	@PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product p){
		
		Product product = pService.saveProduct(p);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
		
		
	}
	
	
	 
	
	 
	@GetMapping("/get/{id}")
	@CircuitBreaker(name="userServiceBreaker" ,fallbackMethod = "userServiceFallBack")
	public ResponseEntity<Product> getProduct(@PathVariable int id){
		
               Product product = pService.findProduct(id);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
		
		
	}
	
	public ResponseEntity<Product> userServiceFallBack( int id,Exception e){
		 
        Product product =  new Product(00,"dummy",00);
	return new ResponseEntity<Product>(product,HttpStatus.OK);
	
	
}
	
}

