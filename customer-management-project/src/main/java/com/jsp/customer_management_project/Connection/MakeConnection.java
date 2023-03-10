package com.jsp.customer_management_project.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MakeConnection {
	
	public static Connection getConnection() {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String pass = "root";
			String url = "jdbc:mysql://localhost:3306/customer_management_project1";
		return	DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
