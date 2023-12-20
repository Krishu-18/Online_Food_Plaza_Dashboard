package com.project.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static Connection con;

	public static Connection establishConnection() {

		try {

			// step2-> Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");// Checked exception
			

			// Step3-> Establish connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_plaza", "root", "Krishna@18");

			// return con;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
