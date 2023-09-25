package edu.jsp.taskmanagementsystem.view;

import java.util.List;
import java.util.Scanner;
import edu.jsp.taskmanagementsystem.control.Controller;
import edu.jsp.taskmanagementsystem.model.Task;

public class View {
	static Scanner scanner=new Scanner(System.in);
	static boolean loop=true;
	static Controller controller=new Controller();
	public static void main(String[] args) {
		while (loop) {
			menu();
			int choice=scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:{
				controller.addTask(addTask());
				break;
			}
			case 2:{
				displayTasks(controller.getTasks());
				break;
			}
			case 3:{
				getTaskObjects(controller.getTaskObjects());
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
	
	
	public static Task addTask() {
		System.out.println("Enter name");
		String name=scanner.nextLine();
		
		System.out.println("Enter starting date");
		String start_date=scanner.nextLine();
		
		System.out.println("Enter Deadline");
		String deadline=scanner.nextLine();
		
		System.out.println("Enter Manager's Name");
		String task_manager=scanner.nextLine();
		
		System.out.println("Enter number of Members in task");
		int no_of_members=scanner.nextInt();
		
		System.out.println("Enter priority");
		int priority=scanner.nextInt();
		
		return new Task(name, start_date, deadline, task_manager, no_of_members, priority);
		
	}
	public static void exit() {
		System.out.println("thank you");
		loop=false;
	}
	
	public static void menu() {
		System.out.println("Select operation to perform\n"
				+ "1.Add new Task\n"
				+ "2.Display all Tasks\n"
				+ "3.Convert all task records to objects\n"
				+ "4.Exit\n");
	}
	
	public static void displayTasks(List<String> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		System.out.println("\nAll users Displayed");
	}
	
	public static void getTaskObjects(List<Task> l) {
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		System.out.println("Created all Tasks objects\n");
	}
}