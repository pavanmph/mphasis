package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.db.ConnectionDB;
import com.test.model.Product;

public class ProductDaoImpl implements ProductDao
{
	Connection con = ConnectionDB.getCon();
	
	String INSERT_SQL = "insert into product (p_name, p_brand, p_price)values(?,?,?)";
	
	String FIND_SQL = "select * from product where id = ? ";
	
	String READ_SQL = "select * from product";
	
	String UPDATE_SQL = "update product set p_name = ?, p_brand = ?, p_price = ? where id = ? ";
	
	String DELETE_SQL = "delete from product where id = ? ";
	
	

	@Override
	public int saveProduct(Product obj) {
	
		int x = 0;
		
		try {
			
			PreparedStatement pst = con.prepareStatement(INSERT_SQL);
			
			pst.setString(1, obj.getP_name());
			pst.setString(2, obj.getP_brand());
			pst.setString(3, obj.getP_price());
			
			x = pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return x;
	}

	@Override
	public Product getProductById(int id) {
		
		Product pr = null;
		
		try
		{
			PreparedStatement pst = con.prepareStatement(FIND_SQL);
			
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				pr = new Product();
						
				pr.setId(rs.getInt(1));
				pr.setP_name(rs.getString(2));
				pr.setP_brand(rs.getString(3));
				pr.setP_price(rs.getString(4));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return pr;
	}

	@Override
	public List<Product> listAllProducts() {
		
		List<Product> listProducts = new ArrayList<>();
		
		try
		{
			PreparedStatement pst = con.prepareStatement(READ_SQL);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Product pr = new Product();
				
				pr.setId(rs.getInt(1));
				pr.setP_name(rs.getString(2));
				pr.setP_brand(rs.getString(3));
				pr.setP_price(rs.getString(4));
				
				listProducts.add(pr);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return listProducts;
	}

	@Override
	public int updateProduct(Product obj) {
		
		int x = 0;
		
		try
		{
			PreparedStatement pst = con.prepareStatement(UPDATE_SQL);
			
			pst.setString(1, obj.getP_name());
			pst.setString(2, obj.getP_brand());
			pst.setString(3, obj.getP_price());
			pst.setInt(4, obj.getId());
			
			x = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return x;
	}

	@Override
	public int deleteProductById(int id) {
		
		int x = 0;
		
		try
		{
			PreparedStatement pst = con.prepareStatement(DELETE_SQL);
			
			pst.setInt(1, id);
			
			x = pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return x;
	}

}
