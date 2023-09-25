package edu.jsp.librarymanagementsystem.view;

import java.util.Scanner;

import edu.jsp.librarymanagementsystem.control.DbLayer;
import edu.jsp.librarymanagementsystem.model.Book;

public class View {

	static Scanner scanner = new Scanner(System.in);
	static DbLayer dbLayer = new DbLayer();
	static boolean loop = true;

	public static void main(String[] args) {
		while (loop) {
			menu();
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1: {
				addBook();
				break;
			}
			case 2: {
				searchBook();
				break;
			}
			case 3: {
				removeBook();
				break;
			}
			case 4: {
				borrowBook();
				break;
			}
			case 5: {
				returnBook();
				break;
			}
			case 6: {
				showBooks();
				break;
			}
			case 7: {
				View.loop = false;
				System.out.println("Thank you....");
				break;
			}
			default: {
				System.out.println("Invalid Choice please try again...");
				break;
			}
			}
		}
	}

	public static void menu() {
		System.out.println("Select Operation to Perform\n" + "1.Add Book\n" + "2.Search Book\n" + "3.Remove Book\n"
				+ "4.Borrow Book\n" + "5.Return Book\n" + "6.Show Books\n" + "7.Exit\n");
	}

	public static void addBook() {
		System.out.println("Enter Title Of Book");
		String name = scanner.nextLine();
		System.out.println("Enter Id Of Book");
		String id = scanner.nextLine();
		System.out.println("Enter Author Name");
		String author = scanner.nextLine();
		dbLayer.InsertRec(new Book(name, id, author, "Available"));
		System.out.println("Book Added Succesfully");
	}

	public static void searchBook() {
		System.out.println("Enter Title or Id or Author Name");
		String key = scanner.nextLine();

		for (Book book : dbLayer.searchBook(key)) {
			System.out.println(book);
		}
	}

	public static void removeBook() {
		showBooks();
		System.out.println("Enter Id to remove Book");
		String key = scanner.nextLine();
		Book book;
		if ((book = dbLayer.removeBook(key)) != null) {
			System.out.println("Book removed : " + book);
		} else {
			System.out.println("Book not available\n");
		}
	}

	public static void borrowBook() {
		System.out.println("Enter Title or Id or Author Name");
		String key = scanner.nextLine();
		Book book;
		if ((book = dbLayer.borrowBook(key)) != null) {
			System.out.println("Book borrowed : " + book);
		} else {
			System.out.println("Book not available\n");
		}
	}

	public static void returnBook() {
		System.out.println("Enter Title or Id or Author Name");
		String key = scanner.nextLine();
		Book book;
		if ((book = dbLayer.returnBook(key)) != null) {
			System.out.println("Returned successful : " + book);
			System.out.println("Thank you for returning book...");
		} else {
			System.out.println("Book not available");
		}
	}

	public static void showBooks() {
		for (Book book : dbLayer.showBooks()) {
			System.out.println(book);
			System.out.println();
		}
	}

}
