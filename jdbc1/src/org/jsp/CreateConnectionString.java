package org.jsp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConnectionString {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		//step 1
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step2 CreateConnection
		String url="jdbc:mysql://localhost:3306/students_info?user=root&password=Zquadstark@1";
		Connection connection = DriverManager.getConnection(url);
		System.out.println("Connection Successful");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
}
