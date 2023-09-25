package edu.jsp.createStatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateStatement {

	public static void main(String[] args) {

		try {
			FileInputStream fileInputStream=new FileInputStream("school.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			
//			step 1 load driver 2 ways
			Class.forName(properties.getProperty("driverPath"));
			
//			step 2 create connection 3 ways
			Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties);
		
//			step 3 create statement 2 ways , 1st way
			Statement statement=connection.createStatement();
			
			System.out.println(statement);
			
			connection.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
