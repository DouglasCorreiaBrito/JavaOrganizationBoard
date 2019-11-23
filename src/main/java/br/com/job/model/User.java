package br.com.job.model;

import br.com.job.utils.FileHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class User {

    private int id;
	private String name;
	private String username;
	private String password;
	private Image profileImage;

	public User() {

	}

	public User(String name, String user, String password, Image profileImage) {
		this.name = name;
		this.username = user;
		this.password = password;
		this.profileImage = profileImage;
	}

    public User(String name, String user, String password, String viewerImage) {
        this.name = name;
        this.username = user;
        this.password = password;
        this.profileImage = new Image(FileHandler.getImage(viewerImage));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public void setProfileImage(String viewerImage) {
        this.profileImage = new Image(FileHandler.getImage(viewerImage));
    }
}
