package edu.jsp.executeUpdate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Insert {

	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream=new FileInputStream("school.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			
//			Step 1 load driver 2 ways
			Class.forName(properties.getProperty("driverPath"));
			
//			Step 2 create connection. 3 ways
			Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties);
			
//			Step3 create Statement.  2 ways
			Statement statement=connection.createStatement();
			
			String sql="INSERT INTO student VALUES(104,'kavya','kavya@email.com','female')";
			
//			Step 4 execute query
			
			int result=statement.executeUpdate(sql);
			System.out.println("Result is : "+result);
			
//			Step 5 close the connection
			connection.close();
			statement.close();
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
