package edu.jsp.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.Driver;

public class JdbcGetDataDemo {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/shop";
		String Username="postgres";
		String pass="root";
		
		try {
//			Step 1
//			Class.forName("org.postgresql.Driver");
			
//			Step1 second way.
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
//			Step 2
			Connection connection=DriverManager.getConnection(url, Username, pass);
			
//			Step 3
			Statement statement=connection.createStatement();
			
			String sql="SELECT * FROM product";
//			Step 4
			ResultSet resultSet=statement.executeQuery(sql);
			
			while (resultSet.next()) {
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				double price=resultSet.getDouble(3);
				int quantity=resultSet.getInt(4);
				
				System.out.println("id is "+id);
				System.out.println("name is "+name);
				System.out.println("price is "+price);
				System.out.println("quantity is "+quantity);
				System.out.println("---------------------------------------");
			}
			connection.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

}
