package edu.jsp.getConnectionMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ByThreeArgs {

	public static void main(String[] args) {
//		Create connection by passing url,username,password;
		
		String dburl="jdbc:postgresql://localhost:5432/shop";
		String user="postgres";
		String pass="root";
		String driverPath="org.postgresql.Driver";
		
		try {
			Class.forName(driverPath);
			
			Connection connection=DriverManager.getConnection(dburl, user, pass);
			
			System.out.println(connection);
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
