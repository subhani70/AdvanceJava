package org.jsp;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hr_table?user=root&password=Zquadstark@1");
			PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM users WHERE email=?");
			preparedStatement.setString(1,email);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				String dBPassword=resultSet.getString("password");
				if(dBPassword.equals(password)) {
					String name=resultSet.getString("name");
					out.println("<h1>Hi....."+ name +"</h1>");
					System.out.println("Successfull login");
				}else {
					out.println("<h1>Login Unsuccessful Wrong password</h1>");
					System.out.println("unsuccessfull");
				}
			}else {
				out.println("<h1>Login un successful wrong password</h1>");
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