package com.eshop.product.service;

import com.eshop.product.entity.Product;

public interface productService {

	Product saveProduct(Product p);

	Product findProduct(int id);

}
