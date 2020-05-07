package com.EcommerceApp.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class MySqlConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "root");
		return con;
	}
}
