package edu.jsp.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/shop";
		String username="postgres";
		String pass="root";
		
		try {
			//Step 1: load/ Register driver class
			Class.forName("org.postgresql.Driver");
			
			//step 2: Create connection;
			Connection connection=DriverManager.getConnection(url, username, pass);
			
			//step 3:Create statement;
			Statement statement=connection.createStatement();
			
			//step 4:Execute query;
			String query="INSERT INTO product VALUES(4,'Nothing phone',50000,2)";
			statement.execute(query);
			System.out.println("success");
			
			//Step 5: Close the connection
			connection.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
