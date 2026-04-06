package com.test.service.impl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.test.dao.ProductDao;
import com.test.entity.Product;
import com.test.service.ProductService;
 
@Service
public class ProductServiceImpl implements ProductService{
 
	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product saveProduct(Product obj) {
		return productDao.saveProduct(obj);
	}
 
	@Override
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}
 
	@Override
	public Product updateProductById(Product obj) {
		return productDao.updateProductById(obj);
	}
 
	@Override
	public List<Product> deleteProductById(int id) {
		return productDao.deleteProductById(id);
	}
 
	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}
 
	@Override
	public List<Product> getProductByName(String name) {
		return productDao.getProductByName(name);
	}
 
	@Override
	public List<Product> getProductByQuantity(int qunty) {
		return productDao.getProductByQuantity(qunty);
	}
 
	@Override
	public List<Product> getAllProductsByNameASC() {
		return productDao.getAllProductsByNameASC();
	}
 
	@Override
	public List<Product> getProductsByNameQP(String name) {
		return productDao.getProductsByNameQP(name);
	}
 
	@Override
	public List<Product> getProductsByQuantityQP(int qnty) {
		return productDao.getProductsByQuantityQP(qnty);
	}
 
}
 
 