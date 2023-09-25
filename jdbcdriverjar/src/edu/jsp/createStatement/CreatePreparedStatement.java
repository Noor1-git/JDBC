package edu.jsp.createStatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class CreatePreparedStatement {

	public static void main(String[] args) {

		try {
			FileInputStream fileInputStream=new FileInputStream("school.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			
//			Step 1 load driver 2 ways
			Class.forName(properties.getProperty("driverPath"));
			
//			Step 2 create connection 3 ways
			Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties);
			
//			Step 3 create statement 2 ways , 2nd way
			
			String sql="INSERT INTO student VALUES(?,?,?,?)";
			
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, 104);
			preparedStatement.setString(2, "shikha");
			preparedStatement.setString(3, "shikha@email.com");
			preparedStatement.setString(4 , "female");
			
//			Step 4 execute query
			
			int res=preparedStatement.executeUpdate();
			System.out.println(res+" rows affected");
			
//			Step 5 close connection
			connection.close();
			preparedStatement.close();
			
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