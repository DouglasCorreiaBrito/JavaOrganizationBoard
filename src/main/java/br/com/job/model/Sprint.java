package br.com.job.model;

import br.com.job.dao.SprintDAO;

import java.util.List;

public class Sprint {
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String tag;
	private List<Task> tasks;
	private int number;
	private String description;

	public void closeSprint() {

	}

	public void openSprint() {

	}

	public void newTask() {

	}

	public void deleteTask(Task t) {

	}
}
