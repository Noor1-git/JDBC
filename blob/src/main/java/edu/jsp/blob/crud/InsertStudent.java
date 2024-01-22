package edu.jsp.blob.crud;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class InsertStudent {

	public static void main(String[] args) {
		
		String dburl="jdbc:postgresql://localhost:5432/jdbc";
		String user="postgres";
		String pass="root";
		String driverpath="org.postgresql.Driver";

		try {
			File file=new File("D:/W11.jpg");
			FileInputStream stream=new FileInputStream(file);
			
			Class.forName(driverpath);
			
			Connection connection=DriverManager.getConnection(dburl, user, pass);
			
			connection.setAutoCommit(false);
			
			PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?)");

			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, "Madhu");
			preparedStatement.setDouble(3, 89.80);
			
			LocalDate date=LocalDate.of(2024, 01, 22);
			Date date2=Date.valueOf(date);
			preparedStatement.setDate(4, date2);
			
			preparedStatement.setBlob(5, stream, file.length());
			
			int result=preparedStatement.executeUpdate();
			
			System.out.println(result+" rows affected");
			
			connection.commit();
			
			preparedStatement.close();
			connection.close();
			stream.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
