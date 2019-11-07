package br.com.job.control;

import java.io.File;

import br.com.job.dao.UserDAO;
import br.com.job.model.User;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class ControlNewUserScreen {

	public void create(String name, String username, String password, Image userImage, ImageView userImageView) {
		User user = new User(name, username, password, userImage, userImageView);
		UserDAO dao = new UserDAO();
		dao.saveUser(user);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Tela de Informação");
		alert.setHeaderText("Sucesso");
		alert.setContentText("Você acaba de criar um novo usuário");
		alert.showAndWait();
	}

	public Image insertImageProfileUser() {
		
		FileChooser fileChooser = new FileChooser();
		File selectImage = fileChooser.showOpenDialog(null);
		Image image = new Image(selectImage.toURI().toString());
		return image;
	}

}
