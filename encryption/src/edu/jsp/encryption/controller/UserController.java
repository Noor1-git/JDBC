package edu.jsp.encryption.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

import edu.jsp.encrypiton.model.User;
import edu.jsp.encryption.sha256.Encryptor;

public class UserController {

	ConnectionPool pool = new ConnectionPool();
	Connection connection;
	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Scanner scanner;

	public int removeUser(int id) {
//		Step 2 create connection
		connection = pool.getConnectionObj();
		int res = 0;
		try {
//			Step 3 create statement
			String sql = "DELETE FROM \"user\" WHERE id=" + id;
			preparedStatement = connection.prepareStatement(sql);

//			step 4 execute query
			res = preparedStatement.executeUpdate();

//			update time and date
			UpdateTime(id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		pool.receiveConnectionObj(connection);
		return res;
	}

	public int updatePass(String pass, int id) {
//		Step 2 create connection
		connection = pool.getConnectionObj();
		int res = 0;
		try {
//			Step 3 create statement
			String sql = "UPDATE \"user\" SET password='" + Encryptor.toHexString(Encryptor.getSHA(pass))
					+ "' WHERE id=" + id;
			preparedStatement = connection.prepareStatement(sql);

//			step 4 execute query
			res = preparedStatement.executeUpdate();

			System.out.println("Password update");
//			update time and date
			UpdateTime(id);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		pool.receiveConnectionObj(connection);
		return res;
	}

	public int updateUserEmail(int id, String email) {
//		Step 2 create connection
		connection = pool.getConnectionObj();
		int res = 0;

		try {
//			Step 3 create statement
			String sql = "UPDATE \"user\" SET email='" + email + "' WHERE id=" + id;
			preparedStatement = connection.prepareStatement(sql);

//			step 4 execute query
			res = preparedStatement.executeUpdate();

			System.out.println("Username update");
//			update time and date
			UpdateTime(id);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		pool.receiveConnectionObj(connection);
		return res;
	}

	private void UpdateTime(int id) {
//		Step 2 create connection
		connection = pool.getConnectionObj();
		String sql1 = "UPDATE \"user\" SET updated_on='" + String.valueOf(LocalDateTime.now()) + "' WHERE id=" + id;
		try {
//			Step 3 create statement
			preparedStatement = connection.prepareStatement(sql1);
//			step 4 execute query
			preparedStatement.execute();
			System.out.println("Updated");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		pool.receiveConnectionObj(connection);

	}

	public int updateUsername(int id, String name) {
//		Step 2 create connection
		connection = pool.getConnectionObj();

		int res = 0;
		try {
//				Step 3 create statement
			String sql = "UPDATE \"user\" SET name='" + name + "' WHERE id=" + id;
			preparedStatement = connection.prepareStatement(sql);

//				step 4 execute query
			res = preparedStatement.executeUpdate();

			System.out.println("Username update");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public void getUsers() {

//		Step 2 create connection.
		connection = pool.getConnectionObj();

		try {
//			step 3
			String sql = "SELECT * FROM \"user\"";

			statement = connection.createStatement();

//			Step 4 execute query
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				String updated = resultSet.getString(6);

				System.out.print(id + ", ");
				System.out.print(name + ", ");
				System.out.print(email + ", ");
				System.out.println("Last Updated on " + updated);
				System.out.println("-------------------------------------------");
			}

//			close connection
			pool.receiveConnectionObj(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InsertUser(User user) {

//		Step 2 create connection.
		connection = pool.getConnectionObj();

		try {
			String sql = "INSERT INTO \"user\" VALUES(?,?,?,?,?,?)";
//			Step 3 create statement
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPass());
			preparedStatement.setString(5, user.getCreated());
			preparedStatement.setString(6, user.getUpdated());

//			Step 4 execute query;
			int res = preparedStatement.executeUpdate();
			System.out.println(res + " rows affected");

//			step 5 close connection
			pool.receiveConnectionObj(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}