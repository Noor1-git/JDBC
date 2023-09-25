package edu.jsp.loadDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadByReflection {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/shop";
		String user = "postgres";
		String pass = "root";
		String classPath = "org.postgresql.Driver";
		
		try {
			Class.forName(classPath);

//forName() will load and register driver class implicitly.
//no need of using registerDriver() method when we are using reflection to load and register driver class.

			Connection connection = DriverManager.getConnection(url, user, pass);

			System.out.println(connection);
			
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

}
