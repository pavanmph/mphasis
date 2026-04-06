package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {
	
	public static Connection getCon()
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/mlafeb";
		
		String user = "root";
		
		String pas = "password";
		
		Connection con = null;
		
		try
		{
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, pas);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void saveEmployee(Employee emp)
	{
		try
		{
			String sql = "insert into employee(id, emp_name, company, city)values(?,?,?,?)";
			
			Connection con = EmpDao.getCon();
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1, emp.getId());
			pst.setString(2, emp.getName());
			pst.setString(3, emp.getCmp());
			pst.setString(4, emp.getCity());
			
			pst.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public List<Employee> getAllEmployees()
	{
		List<Employee> empList = new ArrayList<>();
		
		try
		{
			String sql = "select * from employee";
			
			PreparedStatement pst = EmpDao.getCon()
					.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Employee emp = new Employee();
				
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setCmp(rs.getString(3));
				emp.setCity(rs.getString(4));
				
				empList.add(emp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return empList;
	}
	
	public void updateEmployee(Employee emp)
	{
		try
		{
			String sql = "update employee set emp_name = ?, company = ?, city = ? where id = ? ";
			
			PreparedStatement pst = EmpDao.getCon().prepareStatement(sql);
			
			pst.setString(1, emp.getName());
			pst.setString(2, emp.getCmp());
			pst.setString(3, emp.getCity());
			pst.setInt(4, emp.getId());
			
			pst.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee(int id)
	{
		try
		{
			String sql = "delete from employee where id = ? ";
			
			PreparedStatement pst = EmpDao.getCon().prepareStatement(sql);
			
			pst.setInt(1, id);
			
			pst.execute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
