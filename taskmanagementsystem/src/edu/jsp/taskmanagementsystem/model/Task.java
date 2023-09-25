package edu.jsp.taskmanagementsystem.model;

public class Task {

	private String name;
	private String start_date;
	private String deadline;
	private String task_manager;
	private int no_of_members;
	private int priority;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return start_date;
	}
	public void setStartDate(String start_date) {
		this.start_date = start_date;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getTaskManager() {
		return task_manager;
	}
	public void setTaskManager(String task_manager) {
		this.task_manager = task_manager;
	}
	public int getNoOfMembers() {
		return no_of_members;
	}
	public void setNoOfMembers(int no_of_members) {
		this.no_of_members = no_of_members;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public Task(String name, String start_date, String deadline, String task_manager, int no_of_members, int priority) {
		setName(name);
		setStartDate(start_date);
		setDeadline(deadline);
		setTaskManager(task_manager);
		setNoOfMembers(no_of_members);
		setPriority(priority);
	}
	@Override
	public String toString() {
		return name + "," + start_date + "," + deadline + ","
				+ task_manager + "," + no_of_members + "," + priority+"\n";
	}	
}