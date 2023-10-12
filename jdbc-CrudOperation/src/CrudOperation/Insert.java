package CrudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {

		String url ="jdbc:mysql://localhost:3306/javabatch";
		String username="root";
		String password="root";
		
		Connection connection =null;
		
		try {
			//Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Establish the connection
			connection=DriverManager.getConnection(url, username, password);
			//create statement 
			Statement statement=connection.createStatement();
			//execute the statement
			statement.execute("INSERT INTO student VALUES(2,'xyz','red@gmail.com')");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("Connection closed ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
