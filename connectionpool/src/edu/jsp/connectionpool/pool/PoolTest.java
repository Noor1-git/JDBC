package edu.jsp.connectionpool.pool;

import java.sql.Connection;

public class PoolTest {

	public static void main(String[] args) {

		System.out.println(ConnectionPool.list.size());
		
		Connection connection=ConnectionPool.getConnectionObj();
		System.out.println(connection);
		
		System.out.println(ConnectionPool.list.size());
		
		ConnectionPool.recieveConnectionObj(connection);
		
		System.out.println(ConnectionPool.list.size());
	}

}
