package com.test.dao;

import java.sql.PreparedStatement;
import java.util.List;

import com.test.db.ConnectionDB;
import com.test.model.Customer;

public class CustomerDaoImpl implements CustomerDao
{

	@Override
	public int saveCustomer(Customer obj)
	{
		String sql = "insert into customer (c_name, c_email, c_city) values (?,?,?)";
		
		int x = 0;
		
		try
		{
			PreparedStatement pst = ConnectionDB.getCon().prepareStatement(sql);
			
			pst.setString(1, obj.getName());
			
			pst.setString(2, obj.getEmail());
			
			pst.setString(3, obj.getCity());
			
			x =  pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return x;
		
	}
	
	@Override
	public List<Customer> listAllCustomers()
	{
		return null;
	}
	
}
