package br.com.job.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class User {

	private String name;
	private String user;
	private String password;
	private Image profileImage;
	private ImageView viewerImage;

	public User(String name, String user, String password, Image profileImage, ImageView viewerImage) {
		this.name = name;
		this.user = user;
		this.password = password;
		this.profileImage = profileImage;
		this.viewerImage = viewerImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Image getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(Image profileImage) {
		this.profileImage = profileImage;
	}

	public ImageView getViewerImage() {
		return viewerImage;
	}

	public void setViewerImage(ImageView viewerImage) {
		this.viewerImage = viewerImage;
	}
}
