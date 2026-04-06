package com.test.dao;
 
import java.util.List;
 
import com.test.entity.Product;
 
public interface ProductDao {
 
	Product saveProduct(Product obj);
	
	Product getProductById(int id);
	
	Product updateProductById(Product obj);
	
	List<Product> deleteProductById(int id);
	
	//List<Product> getAllProductById(int id);
	
	List<Product> getAllProducts();
	
	List<Product> getProductByName(String name);
	
	List<Product> getProductByQuantity(int qunty);
	
	List<Product> getAllProductsByNameASC();
	
	List<Product> getProductsByNameQP(String name);
	
	List<Product> getProductsByQuantityQP(int qnty);
}