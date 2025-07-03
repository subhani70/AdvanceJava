package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class ResultSetDemo {

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
//		    boolean res=statement.execute("Insert Into students values(2, 'chandra','chandra@gmail.com','mouni')");
//		    System.out.println(res);
//			
			//4 Execute update
//		    int res=statement.executeUpdate("update students  set s_name='chandrababu' where s_id=3");
//			int res=statement.executeUpdate("delete from students where s_id=3");
			ResultSet set= statement.executeQuery("select * from students");
			while(set.next()) {
				int s_id=set.getInt(1);
				String s_name=set.getString("s_name");
				String s_email=set.getString("s_email");
				String s_password=set.getString("s_password");
				System.out.println(s_id);
				System.out.println(s_name);
				System.out.println(s_email);
				System.out.println(s_password);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
