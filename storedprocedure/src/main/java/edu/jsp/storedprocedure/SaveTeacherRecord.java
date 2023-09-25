package edu.jsp.storedprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SaveTeacherRecord {

	public static void main(String[] args) {

		String url="jdbc:postgresql://localhost:5432/school";
		String user="postgres";
		String pass="root";

		try {
//			step 1 load driver 2 ways
			Class.forName("org.postgresql.Driver");
			
//			Step 2 create connection 3 ways
			Connection connection=DriverManager.getConnection(url, user, pass);
			
//			step 3 create statement 3 ways
			String sql="call create_teacher_record(?,?,?,?,?,?,?)";
			CallableStatement statement=connection.prepareCall(sql);
			
			statement.setInt(1, 2);
			statement.setString(2, "Dimple");
			statement.setString(3, "Female");
			statement.setInt(4, 25);
			statement.setString(5, "Dimple@mail.com");
			statement.setString(6, "123456");
			statement.setString(7, "OB+");
			
//			Step 4 execute query
			statement.execute();
			
//			Step 5 close connection 
			connection.close();
			
			System.out.println("done");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
