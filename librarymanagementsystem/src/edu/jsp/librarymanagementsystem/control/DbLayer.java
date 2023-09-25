package edu.jsp.librarymanagementsystem.control;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import edu.jsp.librarymanagementsystem.model.Book;

public class DbLayer {

	static FileInputStream fileInputStream;
	static Properties properties;
	static Statement statement;
	static PreparedStatement preparedStatement;
	static Connection connection;
	static ResultSet resultSet;
	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Book> searchData;
	static ConnectionPool pool = new ConnectionPool();

	public void InsertRec(Book book) {
		try {

			connection = pool.getConnectionObj();

			String sql = "INSERT INTO book VALUES(?,?,?,?)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, book.getName());
			preparedStatement.setString(2, book.getId());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.setString(4, "available");

			preparedStatement.execute();
			System.out.println("data inserted");
			
			pool.receiveConnectionObj(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Book> searchBook(String key) {
		searchData = new ArrayList<>();
		String sql = "SELECT * FROM book";
		try {

			connection = pool.getConnectionObj();

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String name = resultSet.getString(1);
				String id = resultSet.getString(2);
				String author = resultSet.getString(3);
				String available = resultSet.getString(4);

				if (name.equalsIgnoreCase(key) || id.equalsIgnoreCase(key) || author.equalsIgnoreCase(key)) {
					searchData.add(new Book(name, id, author, available));
				}
			}
			resultSet.close();
			statement.close();
			pool.receiveConnectionObj(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return searchData;
	}

	public Book borrowBook(String key) {
		ArrayList<Book> searchData = searchBook(key);
		System.out.println(searchData);
		System.out.println("Enter Book id to borrow");
		String id = scanner.nextLine();
		for (Book book : searchData) {
			if (book.getId().equalsIgnoreCase(id)) {
				if (book.isAvailable().equalsIgnoreCase("Available")) {
					String sql = "UPDATE book SET available='not available' WHERE id='" + id + "'";
					try {

						connection = pool.getConnectionObj();

						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.execute();

						preparedStatement.close();
						pool.receiveConnectionObj(connection);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return book;
				}
			}
		}
		return null;
	}

	public Book returnBook(String key) {
		ArrayList<Book> searchData = searchBook(key);
		System.out.println("Enter book id to return");
		String id = scanner.nextLine();
		for (Book book : searchData) {
			if (book.getId().equalsIgnoreCase(id)) {
				if (book.isAvailable().equalsIgnoreCase("Not available")) {
					String sql = "UPDATE book SET available='available' WHERE id='" + id + "'";
					try {

						connection = pool.getConnectionObj();

						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.execute();
						System.out.println("Book Returned thank you..");
						preparedStatement.close();
						pool.receiveConnectionObj(connection);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					return book;
				}
			}
		}
		return null;
	}

	public Book removeBook(String key) {
		ArrayList<Book> searchData = searchBook(key);
		String id = key;
		for (Book book : searchData) {
			if (book.getId().equalsIgnoreCase(id)) {
				String sql = "DELETE FROM book WHERE id='" + id + "'";
				try {
					connection = pool.getConnectionObj();

					preparedStatement = connection.prepareStatement(sql);

					preparedStatement.execute();

					preparedStatement.close();

					pool.receiveConnectionObj(connection);

				} catch (SQLException e) {
					e.printStackTrace();
				}
				return book;
			}
		}
		return null;
	}

	public ArrayList<Book> showBooks() {
		ArrayList<Book> arrayList = new ArrayList<>();
		String sql = "SELECT * FROM book";
		try {

			connection = pool.getConnectionObj();

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String name = resultSet.getString(1);
				String id = resultSet.getString(2);
				String author = resultSet.getString(3);
				String available = resultSet.getString(4);

				arrayList.add(new Book(name, id, author, available));
			}
			resultSet.close();
			statement.close();
			pool.receiveConnectionObj(connection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}
}