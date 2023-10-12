package com.jsp.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelperClass {
public Connection getConnection() {
	//create connection1
String url="jdbc:mysql://localhost:3306/javabatch";
String username="root";
String password="root";

//step 1: load/Register the driver
Connection connection=null;
try {
Class.forName("com.mysql.cj.jdbc.Driver");


//create connection2
connection=DriverManager.getConnection(url,username,password);
}
catch(ClassNotFoundException e) {

e.printStackTrace();
}

catch(SQLException e) {
e.printStackTrace();

}
return connection;


}
}