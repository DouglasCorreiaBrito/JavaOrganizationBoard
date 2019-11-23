package br.com.job.view;

import br.com.job.control.ControlLoginScreen;
import br.com.job.utils.FileHandler;
import br.com.job.utils.StyleUtils;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
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
	private static Stage stage;

	ControlLoginScreen cls = new ControlLoginScreen();

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initLayout();
		iniListeners();
		LoginScreen.stage = stage;

		Scene scene = new Scene(basePane);
		stage.setResizable(false);
		stage.setTitle("JOB - LOGIN");
		stage.setScene(scene);
		stage.show();

	}

	private void iniListeners() {

		newUserButton.setOnAction(e -> callCreateNewUserScreen());
		loginButton.setOnAction(e -> validateUser());
	}

	private void validateUser() {
		if (cls.userAuthentication(loginTextField.getText(), passwordField.getText())) {
			callBaseStage();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Erro");
			alert.setContentText("Usuário ou senha inválida");
			alert.show();
		}
	}

	private void callBaseStage() {
		try {
			new BaseStage(cls.getLoggedUser()).start(new Stage());
			LoginScreen.getStage().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void callCreateNewUserScreen() {

		try {
			new NewUserScreen().start(new Stage());
			LoginScreen.getStage().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		LoginScreen.stage = stage;
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
		formPane.getChildren().addAll(loginTextField, passwordField, loginButton, newUserButton, welcomeLabel);
		basePane.getChildren().addAll(formPane, logoJobView, jobLabel);
	}

	private void initComponents() {

		basePane = new AnchorPane();
		basePane.setPrefSize(800, 600);
		basePane.setStyle("-fx-background-color : linear-gradient(#16EDEB,#175B60);");

		formPane = new AnchorPane();
		formPane.setPrefSize(300, 500);
		formPane.setStyle("-fx-background-color : #0A2C2E;");

		welcomeLabel = new Label("Bem-vindo!");
		welcomeLabel.setStyle(StyleUtils.WLCM_LABEL);
		welcomeLabel.setAlignment(Pos.CENTER);

		jobLabel = new Label("JAVA ORGANIZATION BOARD");
		jobLabel.setStyle(StyleUtils.JOB_LABEL);
		jobLabel.setAlignment(Pos.CENTER);

		logoJob = new Image(FileHandler.getImage("logoJOB.png"));
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
		loginButton.setStyle(StyleUtils.BTN_LOGIN);

		newUserButton = new Button("Criar Usuário");
		newUserButton.setPrefWidth(200);
		newUserButton.setStyle(StyleUtils.BTN_NEWUSER);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
