package metadata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbMetaData {

	public static void main(String[] args) {

		try {
			FileInputStream fileInputStream=new FileInputStream("school.properties");
			Properties properties=new Properties();
			properties.load(fileInputStream);
			
//			step 1 load and register driver 2 ways
			Driver driver=new org.postgresql.Driver();
			DriverManager.registerDriver(driver);
			
//			step 2 create conn
			Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties);
			
			DatabaseMetaData data=connection.getMetaData();
			
			String name=data.getDatabaseProductName();
			System.out.println(name);
			String user=data.getUserName();
			System.out.println(user);
			String version=data.getDriverVersion();
			System.out.println(version);
			String drivername=data.getDriverName();
			System.out.println(drivername);
			boolean join=data.supportsOuterJoins();
			System.out.println(join);
			
			connection.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
