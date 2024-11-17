package com.eshop.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eshop.product.entity.Product;
import com.eshop.product.exception.NotFoundException;
@Service
public class productServiceImpl implements productService{
	
	List<Product> productList=new ArrayList<Product>();

	@Override
	public Product saveProduct(Product p) {
		productList.add(p);
		
		return p;
	}

	@Override
	public Product findProduct(int id) {
		Optional<Product> optional = productList.stream().filter(p->p.getProductId()==id).findFirst();
		if(optional.isEmpty()) {
			throw new NotFoundException("not found ");
		
		} 
		return optional.get();
	}

}
