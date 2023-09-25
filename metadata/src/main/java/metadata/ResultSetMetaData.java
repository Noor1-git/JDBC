package metadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaData {

	public static void main(String[] args) {
		String url="jdbc:postgresql://localhost:5432/library";
		String user="postgres";
		String pass="root";
		try {
//			step 1 
			Class.forName("org.postgresql.Driver");
			
//			step 2 
			Connection connection=DriverManager.getConnection(url, user, pass);
			
			String sql="SELECT * FROM book";
			
//			step 3
			Statement statement=connection.createStatement();
			
			ResultSet resultSet=statement.executeQuery(sql);
			
			java.sql.ResultSetMetaData data=resultSet.getMetaData();
			
			int colCount=data.getColumnCount();
			System.out.println(colCount);
			String colName=data.getColumnName(3);
			System.out.println(colName);
			String type=data.getColumnTypeName(3);
			System.out.println(type);
			
			
			statement.close();
			resultSet.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
