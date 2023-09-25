package edu.jsp.executeBatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class InsertBatch {

	public static void main(String[] args) {

		try {
			FileInputStream fileInputStream=new FileInputStream("school.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			
//			Step 1 load driver class 2 ways
			Class.forName(properties.getProperty("driverPath"));
			
//			Step 2 create connection 3 ways
			Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties);
			
//			Step 3 create statement 2 ways
			String sql="INSERT INTO student VALUES(?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			preparedStatement.setInt(1, 105);
			preparedStatement.setString(2,"Ramya");
			preparedStatement.setString(3,"ramya@mail.com");
			preparedStatement.setString(4,"Female");
			
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, 106);
			preparedStatement.setString(2,"Dinesh");
			preparedStatement.setString(3,"dini@mail.com");
			preparedStatement.setString(4,"Male");
			
			preparedStatement.addBatch();
			
//			Step 4 execute query
			int[] res=preparedStatement.executeBatch();
			
				System.out.println(res.length);
			
			
//			Step 5 close conneciton
			connection.close();
			preparedStatement.close();
			System.out.println("Data inserted");
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
