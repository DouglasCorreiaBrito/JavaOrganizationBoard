package br.com.job.view;

import br.com.job.control.ControlNewUserScreen;
import br.com.job.utils.FileHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewUserScreen extends Application {

	private AnchorPane basePane;
	private AnchorPane formPane;
	private Label nameLabel;
	private Label userLabel;
	private Label passwordLabel;
	private TextField nameTextField;
	private TextField userTextField;
	private PasswordField passwordField;
	private Button saveButton;
	private Button cleanButton;
	private Button fotoButton;
	private Image userImage;
	private ImageView userImageView;
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initLayout();
		initListeners();
		NewUserScreen.stage = stage;
		Scene scene = new Scene(basePane);
		stage.setResizable(false);
		stage.setTitle("JOB - Novo Usuário");
		stage.setScene(scene);
		stage.show();

	}

	private void initListeners() {
		saveButton.setOnAction(e -> createNewUser());
		cleanButton.setOnAction(e -> clearTextFields());
		fotoButton.setOnAction(e -> insertImage());
	}

	private void insertImage() {
		ControlNewUserScreen cnus = new ControlNewUserScreen();
		userImage = cnus.insertImageProfileUser();
		userImageView = new ImageView(userImage);
		//TODO enviar essa imagem pro usuário, tentar trocar a imagem no pane
	}

	private void clearTextFields() {
		nameTextField.setText("");
		userTextField.setText("");
		passwordField.setText("");
	}

	private void createNewUser() {
		ControlNewUserScreen cnus = new ControlNewUserScreen();
		boolean isCreate = cnus.create(nameTextField.getText(), userTextField.getText(), passwordField.getText(),
				userImage);

		if (isCreate) {
			try {
				new LoginScreen().start(new Stage());
				NewUserScreen.getStage().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static Stage getStage() {
		return stage;
	}

	private void initLayout() {

		formPane.setLayoutX(70);
		formPane.setLayoutY(50);

		nameLabel.setLayoutX(100);
		nameLabel.setLayoutY(200);
		nameTextField.setLayoutX(150);
		nameTextField.setLayoutY(195);

		userLabel.setLayoutX(90);
		userLabel.setLayoutY(250);
		userTextField.setLayoutX(150);
		userTextField.setLayoutY(245);

		passwordLabel.setLayoutX(100);
		passwordLabel.setLayoutY(295);
		passwordField.setLayoutX(150);
		passwordField.setLayoutY(290);


		saveButton.setLayoutX(270);
		saveButton.setLayoutY(350);
		cleanButton.setLayoutX(340);
		cleanButton.setLayoutY(350);

		fotoButton.setLayoutX(305);
		fotoButton.setLayoutY(140);

		userImageView.setLayoutX(300);
		userImageView.setLayoutY(30);

		formPane.getChildren().addAll(nameLabel, userLabel, passwordLabel, nameTextField, userTextField, passwordField,
				saveButton, cleanButton, fotoButton, userImageView);
		basePane.getChildren().add(formPane);

	}

	private void initComponents() {

		basePane = new AnchorPane();
		basePane.setPrefSize(800, 600);
		basePane.setStyle("-fx-background-color : linear-gradient(#16EDEB,#175B60);");

		formPane = new AnchorPane();
		formPane.setPrefSize(650, 400);
		formPane.setStyle("-fx-background-color : #FFFFFF;");

		nameLabel = new Label("Nome: ");
		userLabel = new Label("Usuário: ");
		passwordLabel = new Label("Senha: ");

		nameTextField = new TextField();
		nameTextField.setPrefWidth(400);
		//nameTextField.relocate(1,1);
		passwordField = new PasswordField();
		passwordField.setPrefWidth(400);
		userTextField = new TextField();
		userTextField.setPrefWidth(400);

		String svBtn = "-fx-background-color : #16ED5E;" + "-fx-font-weight: bold;";
		saveButton = new Button("Salvar");
		saveButton.setStyle(svBtn);

		String clBtn = "-fx-background-color : #16ED5E;" + "-fx-font-weight: bold;";
		cleanButton = new Button("Limpar");
		cleanButton.setStyle(clBtn);

		String ftBtn = "-fx-background-color : #16ED5E;" + "-fx-font-weight: bold;";
		fotoButton = new Button("Inserir foto");
		fotoButton.setStyle(ftBtn);

		userImage = new Image(FileHandler.getImage("profile.png"));
		userImageView = new ImageView(userImage);
		userImageView.setFitHeight(100);
		userImageView.setFitWidth(100);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
