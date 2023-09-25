package edu.jsp.librarymanagementsystem.model;

public class Book {
	private String name;
	private String id;
	private String author;
	private String isAvailable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String isAvailable() {
		return isAvailable;
	}

	public void setAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", id=" + id + ", author=" + author + ", isAvailable=" + isAvailable + "]";
	}

	public Book(String name, String id, String author, String available) {
		setName(name);
		setId(id);
		setAuthor(author);
		setAvailable(available);
	}
}