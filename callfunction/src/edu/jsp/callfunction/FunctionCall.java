package edu.jsp.callfunction;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class FunctionCall {

	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream=new FileInputStream("school.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			
//			Step 1 load or register driver
			Class.forName(properties.getProperty("driverPath"));
			
//			step 2 create conn
			Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties);
			
//			step 3 create Statement
			String sql="select count_by_gender(?)";
			CallableStatement callableStatement=connection.prepareCall(sql);
			callableStatement.setString(1, "female");
			
//			step 4 execute query
			ResultSet resultSet=callableStatement.executeQuery();
			
//			to point towards first record
			resultSet.next();
			
			int res=resultSet.getInt(1);
			System.out.println("Count is : "+res);
			
//			step 5 close conn
			callableStatement.close();
			resultSet.close();
			connection.close();
			fileInputStream.close();
			
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