package edu.jsp.blob.crud;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetImage {

	public static void main(String[] args) {
		
		String dburl="jdbc:postgresql://localhost:5432/jdbc";
		String user="postgres";
		String pass="root";
		String driverpath="org.postgresql.Driver";

		
		try {
			Class.forName(driverpath);
			
			Connection connection=DriverManager.getConnection(dburl, user, pass);
			
			connection.setAutoCommit(false);
			
			PreparedStatement statement=connection.prepareStatement("SELECT * FROM student where id=?");
			
			statement.setInt(1, 1);
			
			ResultSet set=statement.executeQuery();
			
			set.next();
			
			Blob blob=set.getBlob(5);
			
			saveImageToFile(blob, "D:/retreivedImg.jpg");
			
			connection.commit();
			
			set.close();
			statement.close();
			connection.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void saveImageToFile(Blob blob,String path) {
		
		try {
			
			
			FileOutputStream stream=new FileOutputStream(path);
			
			stream.write(blob.getBytes(1, (int)blob.length()));
			
			
			stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
