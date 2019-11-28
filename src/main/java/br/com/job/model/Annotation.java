package br.com.job.model;

import java.util.Date;

import br.com.job.dao.AnnotationDAO;
import br.com.job.dao.TaskDAO;

public class Annotation implements Persistent{

	private int id;
	private String title;
	private String description;
	private String color;
	private Date expireDate;

	public void delete() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public void save() {

	}

	public Persistent search() {
		return null;
	}
	
	public void save(boolean salvar) {
		new AnnotationDAO().saveAnnotation(this, salvar);
	}
}
