package org.jsp;
import java.sql.*;
import java.util.Scanner;

public class Assignment {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1: Insert student\n 2:Update Student\n 3:Remove Student\n 4:Display Student");
		int n=sc.nextInt();
		
		try {
			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2 create Connection
			String url="jdbc:mysql://localhost:3306/students_info";
			String user="root";
			String password="Zquadstark@1";
			Connection connection=DriverManager.getConnection(url,user,password);
			
			if(n==1) {
				PreparedStatement preparedStatement=connection.prepareStatement("Insert into students values (?,?,?,?)");
				System.out.println("give id, name , eamil and password");
				preparedStatement.setInt(1, sc.nextInt());
				preparedStatement.setString(2, sc.next());
				preparedStatement.setString(3,sc.next());
				preparedStatement.setString(4,sc.next());
				preparedStatement.executeUpdate();
				System.out.println("done insertion");
			}
			
			else if(n==2) {
			//step 3
			PreparedStatement preparedStatement=connection.prepareStatement("Update students set s_password=? where s_id=?");
			System.out.println("for update password :");
			//updation
			preparedStatement.setString(1,sc.next() );
			preparedStatement.setInt(2, sc.nextInt());
			preparedStatement.executeUpdate();
			System.out.println("Statement Created");
			}else if(n==4) {
				//Display
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
