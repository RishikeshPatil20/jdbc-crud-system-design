package com.jsp.dao;
import java.sql.*;

import com.jsp.dto.Car;
import com.jsp.helper.HelperClass;

public class CarDao {
 
	HelperClass helperclass=new HelperClass();
	Connection con=null;
	
	
	
	public Car saveCar(Car car) {
		
	Connection con = helperclass.getConnection();
	
	String sql="insert into car values(?,?,?,?)";
	
	PreparedStatement preparedStatement;
	try 
	{
		preparedStatement =con.prepareStatement(sql);
		
		preparedStatement.setInt(1, car.getId());
		preparedStatement.setString(2, car.getBrand());
		preparedStatement.setInt(3, car.getPrice());
		preparedStatement.setString(4, car.getColor());
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return car;
	}
	
}
