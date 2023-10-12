package Save;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
public static void main (String[] args) {
String url ="jdbc:mysql://localhost:3306/javabatch";
String username ="root";
String password="root";

Connection connection=null;
try {
//load/Register the driver
Class.forName("com.mysql.cj.jdbc.Driver");
//establish the connection
  connection =DriverManager.getConnection(url,username,password);
   //create the statement
   Statement statement = connection.createStatement();
  // execute the statement
  statement.execute("INSERT INTO employee VALUES(2,'xyz','red@gmail.com')");
 //close the connection
    }
catch(ClassNotFoundException e) {
//TODO Auto-generate catch block
e.printStackTrace();
}

catch(SQLException e) {
//TODO Auto-generate catch block    
e.printStackTrace();
}
finally {
	 try {
		connection.close();
		 System.out.println("all good");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}

}
