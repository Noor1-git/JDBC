package edu.jsp.executeUpdate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Update {

	public static void main(String[] args) {

		try {
			FileInputStream fileInputStream=new FileInputStream("school.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			
//			Step 1 load Driver class 2 ways
			
			Driver driver=new org.postgresql.Driver();
			
			DriverManager.registerDriver(driver);
			
//			Step 2 create connection  3 ways.
			String url="jdbc:postgresql://localhost:5432/school?user=postgres&password=root";
			Connection connection=DriverManager.getConnection(url);
			
//			Step 3 create statment 2 ways
			Statement statement=connection.createStatement();
			
//			Step 4 execute query 
			String sql="UPDATE student SET email='raj@email.com' WHERE sid=101";
			
			int result=statement.executeUpdate(sql);
			System.out.println(result+" Rows affected");
			
			statement.close();
			connection.close();
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
