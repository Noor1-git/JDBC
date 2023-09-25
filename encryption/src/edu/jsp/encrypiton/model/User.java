package edu.jsp.encrypiton.model;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import edu.jsp.encryption.sha256.Encryptor;

public class User {
	private int id;
	private String name;
	private String email;
	private String pass;
	private String created = String.valueOf(LocalDateTime.now());
	private String Updated = String.valueOf(LocalDateTime.now());

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		String pass = null;
		try {
			pass = Encryptor.toHexString(Encryptor.getSHA(this.pass));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCreated() {
		String s = String.valueOf(created);
		return s;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		String s = String.valueOf(Updated);
		return s;
	}

	public void setUpdated(String updated) {
		Updated = updated;
	}

	public User(int id, String name, String email, String pass) {
		setId(id);
		setName(name);
		setEmail(email);
		setPass(pass);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", Updated_on=" + getUpdated() + "]";
	}

}
