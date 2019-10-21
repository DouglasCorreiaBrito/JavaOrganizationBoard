package br.com.job.view;

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

public class LoginScreen extends Application {

	private AnchorPane basePane;
	private AnchorPane formPane;
	private Label welcomeLabel;
	private Label jobLabel;
	private Image logoJob;
	private ImageView logoJobView;
	private TextField loginTextField;
	private PasswordField passwordField;
	private Button loginButton;
	private Button newUserButton;
	private Stage stage;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();

		initLayout();

		Scene scene = new Scene(basePane);
		stage.setTitle("JOB - LOGIN");
		stage.setScene(scene);
		stage.show();

	}

	private void initLayout() {
		// posicionamento dos nodes
		formPane.setLayoutX(450);
		formPane.setLayoutY(50);

		logoJobView.setLayoutX(80);
		logoJobView.setLayoutY(100);

		jobLabel.setLayoutX(80);
		jobLabel.setLayoutY(400);

		welcomeLabel.setLayoutX(55);
		welcomeLabel.setLayoutY(50);

		loginTextField.setLayoutX(55);
		loginTextField.setLayoutY(150);

		passwordField.setLayoutX(55);
		passwordField.setLayoutY(200);

		loginButton.setLayoutX(55);
		loginButton.setLayoutY(250);

		newUserButton.setLayoutX(55);
		newUserButton.setLayoutY(450);
		formPane.getChildren().addAll(loginTextField, passwordField, newUserButton, loginButton, welcomeLabel);
		basePane.getChildren().addAll(formPane, logoJobView, jobLabel);
	}

	private void initComponents() {

		basePane = new AnchorPane();
		basePane.setPrefSize(800, 600);
		basePane.setStyle("-fx-background-color : linear-gradient(#16EDEB,#175B60);");

		formPane = new AnchorPane();
		formPane.setPrefSize(300, 500);
		formPane.setStyle("-fx-background-color : #0A2C2E;");
		welcomeLabel = new Label("BEM-VINDO");
		welcomeLabel.setStyle("-fx-font-size : 36px; -fx-font-color : #FFFFFF ");

		jobLabel = new Label("JAVA ORGANIZATION BOARD");
		jobLabel.setStyle("-fx-font-size : 24px; -fx-font-color : #FFFFFF ");

		logoJob = new Image(getClass().getResourceAsStream("logoJOB.png"));
		logoJobView = new ImageView(logoJob);
		logoJobView.setFitHeight(250);
		logoJobView.setFitWidth(250);

		loginTextField = new TextField();
		loginTextField.setPrefWidth(200);
		loginTextField.setPromptText("insira seu login...");

		passwordField = new PasswordField();
		passwordField.setPromptText("insira sua senha...");
		passwordField.setPrefWidth(200);

		loginButton = new Button("Login");
		loginButton.setPrefWidth(200);
		loginButton.setStyle("-fx-background-color : #16ED5E;");

		newUserButton = new Button("Criar Usuário");
		newUserButton.setPrefWidth(200);
		newUserButton.setStyle("-fx-background-color : #16ED5E;");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
