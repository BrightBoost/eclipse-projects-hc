package com.hca.servlets.sakila;

import java.sql.*;

public class ExampleJDBC {
	public static void main(String[] args) {
//		if(args.length != 2) {
//			System.err.println("Not enough args");
//			System.exit(1);
//		}
		String user = args[0];
		String password = "";// args[1];
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", user, password);
			String query = "SELECT first_name, last_name FROM customer WHERE last_name LIKE ?"; 
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "Sa%");
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String s1 = rs.getString("first_name");
				String s2 = rs.getString("last_name");
				System.out.println(s1 + " " + s2);
			}
			rs.close();
			preparedStatement.close();
			connection.close();
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}