package org.jsp;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class LoadAndRegisterType1 {

	public static void main(String[] args) {
		try {
		Driver driver= new Driver(); //load
		//&
		DriverManager.registerDriver(driver); //register
		System.out.println("Load and  register done");
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
