package com.jsp.helper;
import java.sql.*;
import java.sql.DriverManager;

public class HelperClass {

	public Connection getConnection() {
		
		String url="jdbc:mysql://localhost:3306/javabatch";
		String username="root";
		String password="root";
		
		Connection con=null;
		
		try
		{
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//creating a connection
			con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}