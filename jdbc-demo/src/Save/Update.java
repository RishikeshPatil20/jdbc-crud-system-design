package Save;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.SocksProxySocketFactory;

public class Update {
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
  int a=statement.executeUpdate("UPDATE employee SET  name='abc', email='abc@mail.com'  WHERE id=1 ");
  if(a>0) {
	  System.out.println("UPDATED");
	  
  }
  else {
	  System.out.println("NOT UPDATED");
  }
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