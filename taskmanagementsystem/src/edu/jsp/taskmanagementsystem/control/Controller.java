package edu.jsp.taskmanagementsystem.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import edu.jsp.taskmanagementsystem.model.Task;

public class Controller {

	static String path = "D:\\NEW_ADVANCE\\taskmanagementsystem\\src\\Task.csv";
	static List<String> taskInfo;

	public void addTask(Task task) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path, true);
			byte[] data = task.toString().getBytes();
			fileOutputStream.write(data);
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> getTasks() {
		List<String> task = new ArrayList<>();

		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String line = "";
			line = bufferedReader.readLine();
			while ((line = bufferedReader.readLine()) != null) {
				task.add(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return task;
	}

	public List<Task> getTaskObjects() {
		List<Task> taskObj = new ArrayList<>();
		for (String string : getTasks()) {

			String[] record = string.split(",");
			String name = null;
			String start_date = null;
			String deadline = null;
			String task_manager = null;
			int no_of_members = 0;
			int priority = 0;

			for (int i = 0; i < record.length; i++) {

				name = record[0];
				start_date = record[1];
				deadline = record[2];
				task_manager = record[3];
				no_of_members = Integer.parseInt(record[4]);
				priority = Integer.parseInt(record[5]);

			}
			Task task = new Task(name, start_date, deadline, task_manager, no_of_members, priority);
			taskObj.add(task);
		}

		return taskObj;
	}
}