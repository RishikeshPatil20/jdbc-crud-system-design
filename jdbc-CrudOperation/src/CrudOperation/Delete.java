package CrudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {

		String url="jdbc:mysql://localhost:3306/javabatch";
		String username= "root";
		String password="root";
		
		Connection connection=null;
		
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create a connection
			DriverManager.getConnection(url, username, password);
			//Create the statement
			Statement statement=connection.createStatement();
			//execute statement 
			statement.execute("DELETE from student where id=1");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("Connection got close");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
