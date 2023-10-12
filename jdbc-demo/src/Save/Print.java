package Save;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

public class Print

{

public static void main(String[] args) {
String url= "jdbc:mysql://localhost:3306/javabatch";
String username= "root";
String password = "root";
Connection connection = null;

try {

Class.forName("com.mysql.cj.jdbc.Driver");

try {

connection= DriverManager.getConnection(url, username, password);

Statement statement = connection.createStatement();

ResultSet resultset= statement.executeQuery("select * from pen");

while(resultset.next()){

System.out.println(resultset.getInt(1));

System.out.println(resultset.getString(2));

System.out.println(resultset.getString(3));

System.out.println(resultset.getInt(4));

System.out.println("==================================");

}

} catch (SQLException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

} catch (ClassNotFoundException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

finally {

try {

connection.close();

} catch (SQLException e) {

// TODO Auto-generated catch block

e.printStackTrace();

}

}

}

}