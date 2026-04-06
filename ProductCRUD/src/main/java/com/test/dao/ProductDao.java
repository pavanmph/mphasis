package com.test.dao;

import java.util.List;

import com.test.model.Product;

public interface ProductDao {
	
	public int saveProduct(Product obj);
	
	public Product getProductById(int id);
	
	public List<Product> listAllProducts();
	
	public int updateProduct(Product obj);
	
	public int deleteProductById(int id);
}
