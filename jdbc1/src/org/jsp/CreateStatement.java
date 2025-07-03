package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateStatement {

	public static void main(String[] args) {
		try {
			//step1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2
			String url="jdbc:mysql://localhost:3306/students_info";
			String user="root";
			String password="Zquadstark@1";
			
			//step 3
			Connection connection=DriverManager.getConnection(url,user,password);
			
			//step 3
			Statement statement=connection.createStatement();
			System.out.println("Statement Created");
			
			//step 4
//			Exexcute Statement
		    boolean res=statement.execute("Insert Into students values(2, 'chandra','chandra@gmail.com','mouni')");
		    System.out.println(res);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
