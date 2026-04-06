package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	
	public static Connection getCon()
	{
		Connection con = null;
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mlafeb";
		String user = "root";
		String pas = "password";//root@39
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
	
}
