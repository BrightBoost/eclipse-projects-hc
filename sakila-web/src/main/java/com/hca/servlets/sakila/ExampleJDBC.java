package com.hca.servlets.sakila;

import java.sql.*;

public class ExampleJDBC {
	public static void main(String[] args) {
		// I did not set a pw for mysql, so leaving this out
//		if(args.length != 2) {
//			System.err.println("Not enough args");
//			System.exit(1);
//		}
		String user = args[0];
		// no pw
		String password = "";// args[1];

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", user, password);
			String query = "SELECT first_name, last_name FROM customer WHERE last_name LIKE ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "Sa%");
			rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String s1 = rs.getString("first_name");
				String s2 = rs.getString("last_name");
				System.out.println(s1 + " " + s2);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("almost always executed");
			try {
				if (rs != null) {
					rs.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		try (Connection conn = DriverManager.getConnection("bla", "x", "x");
				PreparedStatement ps = conn.prepareStatement("some sql");
				ResultSet rs1 = ps.executeQuery();) {
			while (rs1.next()) {
				String s1 = rs1.getString("first_name");
				String s2 = rs1.getString("last_name");
				System.out.println(s1 + " " + s2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}

	}
}