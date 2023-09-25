package edu.jsp.filehandling.model;

public class User {
	private String name;
	private int id;
	private String email;
	
	public User(String name,int id,String email){
		setName(name);
		setId(id);
		setEmail(email);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "name=" + name + ",id=" + id + ",email=" + email + "\n";
	}
}