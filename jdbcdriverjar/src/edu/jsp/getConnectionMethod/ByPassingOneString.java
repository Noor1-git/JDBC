package edu.jsp.getConnectionMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ByPassingOneString {

	public static void main(String[] args) {
//		AKA query String.
		String dbUrl="jdbc:postgresql://localhost/shop?user=postgres&password=root";
		String driverPath="org.postgresql.Driver";
		
		try {
			Class.forName(driverPath);
			
			Connection connection=DriverManager.getConnection(dbUrl);
			
			System.out.println(connection);
			connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
