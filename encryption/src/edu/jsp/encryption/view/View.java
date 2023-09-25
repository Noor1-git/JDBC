package edu.jsp.encryption.view;

import java.util.Scanner;

import edu.jsp.encrypiton.model.User;
import edu.jsp.encryption.controller.UserController;

public class View {

	static UserController controller = new UserController();
	static Scanner scanner = new Scanner(System.in);
	static boolean loop = true;

	public static void main(String[] args) {
		while (loop) {
			menu();
		}
	}

	public static void menu() {
		System.out.println("Select Operation to perform\n" + "1.Add User\n" + "2.Remove User\n" + "3.Update user\n"
				+ "4.Show all Users\n" + "5.Exit\n");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {

		case 1: {
			addUser();
			break;
		}
		case 2: {
			removeUser();
			break;
		}
		case 3: {
			updateMenu();
			break;
		}
		case 4: {
			showUsers();
			break;
		}
		case 5: {
			loop = false;
			System.out.println("Thank you...");
			break;
		}
		default: {
			System.out.println("Invalid choice");
		}
			break;
		}
	}

	public static void updateMenu() {
		System.out.println(
				"Select What to Update\n" + "1.User name\n" + "2.User email\n" + "3.User password\n" + "4.Go back\n");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 1: {
			updateName();
			break;
		}
		case 2: {
			updateEmail();
			break;
		}
		case 3: {
			updatePass();
			break;
		}
		case 4: {
			menu();
			break;
		}
		default: {
			System.out.println("Invalid Choice");
			updateMenu();
			break;
		}
		}
	}

	public static void showUsers() {
		controller.getUsers();
	}

	public static void updateName() {
		System.out.println("Enter User id to Update");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter new User Name");
		String name = scanner.nextLine();
		System.out.println(controller.updateUsername(id, name));
	}

	public static void updateEmail() {
		System.out.println("Enter User id to Update");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter new User email");
		String name = scanner.nextLine();
		System.out.println(controller.updateUserEmail(id, name));
	}

	public static void updatePass() {
		System.out.println("Enter User id to Update");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter new User Password");
		String name = scanner.nextLine();
		System.out.println(controller.updatePass(name, id));
	}

	public static void addUser() {
		System.out.println("Enter User id");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter username");
		String name = scanner.nextLine();
		System.out.println("Enter User email");
		String email = scanner.nextLine();
		System.out.println("Enter user Password");
		String pass = scanner.nextLine();

		controller.InsertUser(new User(id, name, email, pass));
	}

	public static void removeUser() {
		System.out.println("Enter user id to remove");
		int id = scanner.nextInt();
		System.out.println(controller.removeUser(id) + "Users removed");
	}

}
