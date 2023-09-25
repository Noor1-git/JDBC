package edu.jsp.connectionpool.ticket;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.jsp.connectionpool.pool.ConnectionPool;

public class TicketTest {

	public static void main(String[] args) {

		Connection connection=ConnectionPool.getConnectionObj();
		
		String sqlBooking_info="INSERT INTO booking_info VALUES(1,'AIR-IND-101','BLR','US')";
		String sqlPass_info1="INSERT INTO passenger_info VALUES(1,'PRIYA',22,'FEMALE')";
		String sqlPass_info2="INSERT INTO passenger_info VALUES(2,'DIMPLE',21,'FEMALE')";
		String sqlPass_info3="INSERT INTO passenger_info VALUES(3,'RAJU',24,'MALE')";
		String sqlpay_info="INSERT INTO payment_info VALUES(1,1,250000,7000,'REQUESTED')";
		
		
		try {
			
			connection.setAutoCommit(false);
			
			Statement statement=connection.createStatement();
			statement.execute(sqlBooking_info);
			
			Statement statement2=connection.createStatement();
			statement2.execute(sqlPass_info1);
			
			Statement statement3=connection.createStatement();
			statement3.execute(sqlPass_info2);
			
			Statement statement4=connection.createStatement();
			statement4.execute(sqlPass_info3);
			
			if (DemoPaymentGateway.isSuccess()) {
				Statement statement5=connection.createStatement();
				statement5.execute(sqlpay_info);
				connection.commit();
				System.out.println("Transaction complete");
			} else {
				System.out.println("Transaction failed");
				connection.rollback();
			}
			
			ConnectionPool.recieveConnectionObj(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}