package edu.jsp.filehandeling.veiw;


import java.util.List;
import java.util.Scanner;

import edu.jsp.filehandeling.control.Controller;
import edu.jsp.filehandling.model.User;

public class View {
	static boolean loop=true;
	static Scanner scanner;
	static Controller controller=new Controller();
	public static void main(String[] args) {		
		scanner=new Scanner(System.in);
		
		while (loop) {
			menu();
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				controller.addUser(addUser());
				break;
			}
			case 2:{
				displayUsers(controller.getUsers());
				break;
			}
			case 3:{
				getObjects(controller.getObjects());
				break;
			}
			case 4:{
				exit();
				break;
			}
			default:
				System.out.println("Invalid choice please try again\n");
				break;
			}
		}	
	}
	public static User addUser() {
		System.out.println("Enter Username\n");
		scanner.nextLine();
		String name=scanner.nextLine();
		System.out.println("Enter id\n");
		int id=scanner.nextInt();
		System.out.println("Enter email\n");
		scanner.nextLine();
		String email=scanner.nextLine();
		System.out.println("User added Succesfully\n");
		return new User(name,id,email);
	}
	
	public static void displayUsers(List<String> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		System.out.println("\nAll users Displayed");
	}
	
	public static void exit() {
		System.out.println("thank you");
		loop=false;
	}
	
	public static void menu() {
		System.out.println("Select operation to perform\n"
				+ "1.Add new User\n"
				+ "2.Display all users\n"
				+ "3.Convert records to objects\n"
				+ "4.Exit\n");
	}
	
	public static void getObjects(List<User> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		System.out.println("Created all users objects\n");
	}
}