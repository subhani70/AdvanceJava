package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchExecute {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		try {
			//step1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2
			String url="jdbc:mysql://localhost:3306/students_info";
			String user="root";
			String password="Zquadstark@1";
			
			//step 3
			connection=DriverManager.getConnection(url,user,password);
			
			//step 3
			statement=connection.createStatement();
			System.out.println("Statement Created");
			
			//step 4		  
			statement.addBatch("Insert Into students values(61,'Hemalatha','heam@gmail.com','hema@1234')");
			statement.addBatch("Insert Into students values(62,'Sara','sara@gmail.com','sara@1234')");
			statement.addBatch("Insert Into students values(63,'Sara','ankita@gmail.com','ankita@1234')");
			statement.addBatch("Insert Into students values(64,'Stark','stark@gmail.com','stark@1234')");
			statement.addBatch("Update students set s_name='AAAA' where s_name='sara'");
			
			int[] arr=statement.executeBatch();
			System.out.println(Arrays.toString(arr));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}if(statement !=null) {
					statement.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}
