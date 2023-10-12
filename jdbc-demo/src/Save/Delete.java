package Save;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
public static void main (String[] args) {
String url ="jdbc:mysql://localhost:3306/javabatch";
String username ="root";
String password="root";

try {
//load/Register the driver
Class.forName("com.mysql.cj.jdbc.Driver");
//establish the connection
   Connection connection =DriverManager.getConnection(url,username,password);
   //create the statement
   Statement statement = connection.createStatement();
  // execute the statement
  statement.execute("Delete from pen where id =1");
 //close the connection
 connection.close();
 System.out.println("all good");
 
    }
catch(ClassNotFoundException e) {
//TODO Auto-generate catch block
e.printStackTrace();
}

catch(SQLException e) {
//TODO Auto-generate catch block    
e.printStackTrace();
}

}

}