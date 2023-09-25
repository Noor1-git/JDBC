package edu.jsp.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdateDemo {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/shop";
		String user="postgres";
		String pass="root";
		
		try {
//			Step 1 load
			Class.forName("org.postgresql.Driver");
			
//			step 2 create conn.
			
			Connection connection=DriverManager.getConnection(url, user, pass);
			String sql="UPDATE product set cost=2000 WHERE id=1";
			
//			Step 3 create stmt.
			
			Statement statement=connection.createStatement();
			
//			step 4
			
			statement.execute(sql);
			System.out.println("data update");
//			step 5
			connection.close();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
