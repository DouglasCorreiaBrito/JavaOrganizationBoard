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

	public Boolean create(String name, String username, String password, Image userImage, ImageView userImageView) {

		if (validadeNullFields(name, username, password)) {

			User user = new User(name, username, password, userImage, userImageView);
			UserDAO dao = new UserDAO();
			dao.saveUser(user);
			sucessAlert();
			return true;
		} else {
			FailureAlet();
			return false;
		}

	}

	private boolean validadeNullFields(String name, String username, String password) {
		if (name.equals("")||username.equals("")||password.equals("")) {
			return false;
		}
		return true;
		
	}

	private void FailureAlet() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Tela de Informação");
		alert.setHeaderText("Erro");
		alert.setContentText("Verifique os campos informados");
		alert.showAndWait();
	}

	private void sucessAlert() {
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
