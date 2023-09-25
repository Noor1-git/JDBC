package edu.jsp.getConnectionMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ByUsingPropertiesClass {

	public static void main(String[] args) {
		try {
			
			FileInputStream fileInputStream = new FileInputStream("DbConfig.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			String driverPath = properties.getProperty("driverPath");
			String url = properties.getProperty("url");
			Class.forName(driverPath);
			Connection connection = DriverManager.getConnection(url, properties);
			System.out.println(connection);
			connection.close();
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}