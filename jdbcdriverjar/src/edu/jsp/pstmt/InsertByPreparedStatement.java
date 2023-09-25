package edu.jsp.pstmt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class InsertByPreparedStatement {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			FileInputStream fileInputStream = new FileInputStream("school.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);

			Class.forName(properties.getProperty("driverPath"));

			Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);

			String sql = "INSERT INTO student VALUES(?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
				System.out.println("Enter student id");
				preparedStatement.setInt(1, scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter student Name");
				preparedStatement.setString(2, scanner.nextLine());
				System.out.println("Enter student Email");
				preparedStatement.setString(3, scanner.nextLine());
				System.out.println("Enter Student gender");
				preparedStatement.setString(4, scanner.nextLine());

				preparedStatement.execute();

				System.out.println("Data Inserted");
			
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