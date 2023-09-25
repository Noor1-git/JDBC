package edu.jsp.filehandeling.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import edu.jsp.filehandling.model.User;

public class Controller {
	
	static String path="D:\\NEW_ADVANCE\\filehandeling\\src\\UserInfo.txt";
	static List<String>userInfo;
	
	public void addUser(User user) {
			
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path, true);
			byte[] write = user.toString().getBytes();
			fileOutputStream.write(write);
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getUsers() {
		userInfo=new ArrayList<String>();
		
		try {
			FileInputStream fileInputStream=new FileInputStream(path);
			InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
			
			String line="";
			while ((line=bufferedReader.readLine())!=null) {
				userInfo.add(line);
			}
			bufferedReader.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}
	
	public List<User> getObjects() {
		List<User> objects = new ArrayList<>();
		
		for (String s : getUsers()) {
			
			String[] record=s.split("=|,");
			
			String name=null;
			int id=0;
			String email=null;
			
			for (int i = 0; i < record.length; i++) {
				
				name=record[1];
				id=Integer.parseInt(record[3]);
				email=record[5];
			}
			
			User user=new User(name, id, email);
			objects.add(user);
		}
		return objects;
	}
}