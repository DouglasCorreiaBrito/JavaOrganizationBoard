package br.com.job.model;

import br.com.job.dao.TaskDAO;

import java.util.Date;

public class Task implements Persistent {

	private int id;

	private String title;
	private String description;
	private Status status;
	private int hoursToSpend;
	private int hoursSpent;
	private User assignee;
	private Date iniDate;
	private Date endDate;

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

	public String getTitle() {
		return title == null ? "" : title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description == null ? "" : description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status == null ? Status.ToDo : status;
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

	public Date getIniDate() {
		return iniDate;
	}

	public void setIniDate(Date iniDate) {
		this.iniDate = iniDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void save(boolean salvar) {
		new TaskDAO().saveTask(this, salvar);
	}

	public void saveTaskWithCalendar(boolean salvar) {
		new TaskDAO().saveTaskWithCalendar(this, salvar);
	}
}
