package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Student;
import com.jsp.helper.HelperClass;

public class StudentDao
{
  HelperClass helperclass=new HelperClass();

  
  Connection connection=null;
  
  public  Student saveStudent(Student student)
  {
    Connection connection= helperclass.getConnection();
   
    String sql ="INSERT INTO student values(?,?,?)";
    //create statement
    PreparedStatement preparedStatement;
    try {
      preparedStatement = connection.prepareStatement(sql);
     
      preparedStatement.setInt(1,student.getId());
      preparedStatement.setString(2,student.getName());
      preparedStatement.setString(3,student.getEmail());
     
      preparedStatement.execute();
    } catch (SQLException e) {
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
    //execute the statement
    return student;
  }
  
  
  
  
 public Student getStudentById(int id) {
	 connection=helperclass.getConnection();
	 String sql="SELECT * FROM student WHERE id=?";
	 Student student2=new Student();
	 
	 try {//create statement
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		//execute the statement
		ResultSet resultSet= preparedStatement.executeQuery();
		while(resultSet.next()) {
			int id2=resultSet.getInt(1);
			String name= resultSet.getString(2);
			String email= resultSet.getString(3);
			student2.setId(id2);
			student2.setName(name);
			student2.setEmail(email);
			
		}
	} catch (SQLException e) {
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
	 return student2;
 }
  
  
//delete
  public boolean deleteStudentById(int id){
	connection=helperclass.getConnection();
	String sql="DELETE from student where id=?";
	boolean res=false;
	try {//create statement
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			//execute
			int res2=preparedStatement.executeUpdate();
			
			if(res2>0) {
				res=true;
			}
			else {
				res=false;
			}
	} catch (SQLException e) {
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
	return res;
  }
  //get All
  public List<Student> getAllStudent(){
	  connection =helperclass.getConnection();
	  String sql ="SELECT * from student";
	  ArrayList<Student> al = null;
	  try {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		//Execute query
		ResultSet resultSet =preparedStatement.executeQuery();
		al = new ArrayList<>();
		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name =resultSet.getString(2);
			String email = resultSet.getString(3);
			Student s=new Student();
			s.setId(id);
			s.setName(name);
			s.setEmail(email);
			al.add(s);
			
		
}
	} catch (SQLException e) {
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
	return al;
  }
  public void addMultipleStudents(List<Student> students) {
		connection=helperclass.getConnection();
		
		String sql="INSERT INTO student VALUES(?,?,?)";
		
		// create statement
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			
			//execute statement
			for(Student s : students) {
				preparedStatement.setInt(1, s.getId());
				preparedStatement.setString(2, s.getName());
				preparedStatement.setString(3, s.getEmail());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("All Good");
			} catch (SQLException e) {
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
