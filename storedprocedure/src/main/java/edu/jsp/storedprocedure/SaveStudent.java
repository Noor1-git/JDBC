package edu.jsp.storedprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SaveStudent {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String pass = "root";

		try {
//			step 1 load driver
			Class.forName("org.postgresql.Driver");
//			step 2 create connection.
			Connection connection=DriverManager.getConnection(url, user, pass);
//			Step 3 create statement
			String sql="call insert_student_record(?,?,?,?)";
			CallableStatement statement=connection.prepareCall(sql);
			statement.setInt(1, 3);
			statement.setString(2, "PQRS");
			statement.setString(3, "B");
			statement.setString(4, "pqrs@mamil.com");
			
//			step 4 execute query
			int res=statement.executeUpdate();
			
//			step 5 close jdbc objs
			connection.close();
			statement.close();
			
			System.out.println(res+"rows affected");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}