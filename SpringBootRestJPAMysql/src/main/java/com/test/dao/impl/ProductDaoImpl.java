package com.test.dao.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.repository.ProductRepository;
 
@Repository
public class ProductDaoImpl implements ProductDao{
 
	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product saveProduct(Product obj) {
		return repository.save(obj);
	}
 
	@Override
	public Product getProductById(int id) {
		return repository.findById(id).get();
	}
 
	@Override
	public Product updateProductById(Product obj) {
		return repository.save(obj);
	}
 
	@Override
	public List<Product> deleteProductById(int id) {
		repository.deleteById(id);
		return repository.findAll();
	}
 
	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
 
	@Override
	public List<Product> getProductByName(String name) {
		return repository.getProductByName(name);
	}
 
	@Override
	public List<Product> getProductByQuantity(int qunty) {
		return repository.getProductByQuantity(qunty);
	}
 
	@Override
	public List<Product> getAllProductsByNameASC() {
		return repository.getAllProductsByNameASC();
	}
 
	@Override
	public List<Product> getProductsByNameQP(String name) {
		return repository.getProductsByNameQP(name);
	}
 
	@Override
	public List<Product> getProductsByQuantityQP(int qnty) {
		return repository.getProductsByQuantityQP(qnty);
	}
 
	
}