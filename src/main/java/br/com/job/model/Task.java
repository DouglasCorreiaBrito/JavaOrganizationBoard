package br.com.job.model;

import java.util.Date;

public class Task implements Persistent {

	private int id;
	private String description;
	private Status status;
	private int hoursToSpend;
	private int hoursSpent;
	private User assignee;
	private Date previewDate;

	public void changeStatus(Status s) {

	}

	@Override
	public void save() {

	}

	@Override
	public Persistent search() {
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getHoursToSpend() {
		return hoursToSpend;
	}

	public void setHoursToSpend(int hoursToSpend) {
		this.hoursToSpend = hoursToSpend;
	}

	public int getHoursSpent() {
		return hoursSpent;
	}

	public void setHoursSpent(int hoursSpent) {
		this.hoursSpent = hoursSpent;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	public Date getPreviewDate() {
		return previewDate;
	}

	public void setPreviewDate(Date previewDate) {
		this.previewDate = previewDate;
	}
}
