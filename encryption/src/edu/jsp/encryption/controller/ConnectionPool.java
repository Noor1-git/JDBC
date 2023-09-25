package edu.jsp.encryption.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
	private List<Connection> connectionList = new ArrayList<>();
	private FileInputStream fileInputStream;
	private Properties properties;
	private final int POOL_SIZE = 5;

	{
		try {
			fileInputStream = new FileInputStream("DbConfig.properties");
			properties = new Properties();
			properties.load(fileInputStream);

			Class.forName(properties.getProperty("DriverPath"));

			for (int i = 0; i <= POOL_SIZE; i++) {
				connectionList.add(createConnection());
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnectionObj() {
		if (!connectionList.isEmpty()) {
			return connectionList.remove(0);
		} else {
			return createConnection();
		}
	}

	public void receiveConnectionObj(Connection connection) {
		if (connectionList.size() < POOL_SIZE) {
			connectionList.add(connection);
		} else {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}