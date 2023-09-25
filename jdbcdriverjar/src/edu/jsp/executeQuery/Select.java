package edu.jsp.executeQuery;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Select {

	public static void main(String[] args) {

		try {
			FileInputStream fileInputStream=new FileInputStream("school.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			
//			step 1 load driver 2 ways
			Class.forName(properties.getProperty("driverPath"));
			
//			Step 2 create connection 3 ways
			Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties);
			
//			Step 3 Create statement 2 ways
			Statement statement=connection.createStatement();
			
//			Step 4 execute query
			String sql="SELECT * FROM student";
			
			ResultSet resultSet=statement.executeQuery(sql);
			
			while (resultSet.next()) {
//				in getter method either we can use column name or column index
				System.out.println(resultSet.getInt("sid"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("email"));
				System.out.println(resultSet.getString("gender"));
				System.out.println("----------------------------------");
			}
			
//			Step 5 close connection
			connection.close();
			statement.close();
			resultSet.close();
			
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