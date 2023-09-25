package edu.jsp.loadDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class LoadDriverByNewOperator {
	
	public static void main(String[] args) {
		
		String url="jdbc:postgresql://localhost:5432/shop";
		String username="postgres";
		String pass="root";
		Driver driver=new Driver();
		
		try {
			DriverManager.registerDriver(driver);
			
			Connection connection=DriverManager.getConnection(url,username,pass);
			
			System.out.println(connection);
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
