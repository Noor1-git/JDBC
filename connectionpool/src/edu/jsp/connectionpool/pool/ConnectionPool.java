package edu.jsp.connectionpool.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static String driverPath="org.postgresql.Driver";
	private static String url="jdbc:postgresql://localhost:5432/ticket";
	private static String user="postgres";
	private static String pass="root";
	private static final int POOL_SIZE=5;
	static List<Connection> list=new ArrayList<>();
	
	static {
		
		try {
			Class.forName(driverPath);
			
			for (int i = 0; i < POOL_SIZE; i++) {
				list.add(createConnection());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnectionObj() {
		if (!list.isEmpty()) {
			return list.remove(0);
		} else {
			return createConnection();
		}
	}
	
	public static void recieveConnectionObj(Connection connection) {
		if (list.size()<POOL_SIZE) {
			list.add(connection);
		} else {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Connection createConnection() {
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url, user, pass);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}