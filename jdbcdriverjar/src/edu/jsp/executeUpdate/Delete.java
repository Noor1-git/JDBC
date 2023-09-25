package edu.jsp.executeUpdate;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/school";
		String user="postgres";
		String pass="root";
		
//		Step 1 load driver 2 ways
		Driver driver=new org.postgresql.Driver();
		try {
			DriverManager.registerDriver(driver);
			
//			Step 2 create connection 3 ways
			Connection connection=DriverManager.getConnection(url, user, pass);
			
//			Step 3 create statement 2 ways
			Statement statement=connection.createStatement();
			
//			Step 4 execute statement
			
			String sql="DELETE FROM student WHERE sid=105";
			
			int res=statement.executeUpdate(sql);
			System.out.println(res+" Rows affected");
			
//			Step 5 close connections
			connection.close();
			statement.close();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
