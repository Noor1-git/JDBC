package edu.jsp.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDeleteDemo {

	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5432/shop";
		String user="postgres";
		String pass="root";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection=DriverManager.getConnection(url, user, pass);
			
			String sql="DELETE FROM product WHERE id=1";
			
			Statement statement=connection.createStatement();
			
			statement.execute(sql);
			System.out.println("delete successfully");
			connection.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

}
