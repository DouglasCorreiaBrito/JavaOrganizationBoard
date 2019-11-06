package br.com.job.model;

import br.com.job.model.Status;
import br.com.job.model.User;

import java.util.Date;

public class Task {

	private int id;
	private String description;
	private Status status;
	private int hoursToSpend;
	private int hoursSpent;
	private User assignee;
	private Date previewDate;

	public void changeStatus(Status s) {

	}

}
