package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PrintTable {

	public static void main(String[] args) {
	try {
		//step1
		Class.forName("com.mysql.cj.jdbc.Driver");
		// 2 create connection
		String url="jdbc:mysql://localhost:3306/students_info";
		String user="root";
		String password="Zquadstark@1";
		
		//3
		Connection connection=DriverManager.getConnection(url,user,password);
		Statement statement=connection.createStatement();
		System.out.println("Statement Created");
		
		//4
		boolean res=statement.execute("Insert Into students values(3, 'chandra','chandra@gmail.com','mouni')");
	    System.out.println(res);
	    
	    boolean res2=statement.execute("Select * from students");
	    System.out.println(res2);


		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
