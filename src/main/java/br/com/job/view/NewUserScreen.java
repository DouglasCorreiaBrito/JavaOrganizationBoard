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
	
	
	
	@Override
	public void start(Stage arg0) throws Exception {
		
		initComponents();
		initLayout();
		Scene scene = new Scene(basePane);
		arg0.setResizable(false);
		arg0.setTitle("JOB - Novo Usu�rio");
		arg0.setScene(scene);
		arg0.show();

	}



	private void initLayout() {
		
		formPane.setLayoutX(70);
		formPane.setLayoutY(50);
		
		nameLabel.setLayoutX(100);
		nameLabel.setLayoutY(200);
		nameTextField.setLayoutX(140);
		nameTextField.setLayoutY(195);
		
		userLabel.setLayoutX(90);
		userLabel.setLayoutY(250);
		userTextField.setLayoutX(140);
		userTextField.setLayoutY(245);
		
		passwordField.setLayoutX(140);
		passwordField.setLayoutY(290);
		passwordLabel.setLayoutX(90);
		passwordLabel.setLayoutY(295);
		
		
		saveButton.setLayoutX(280);
		saveButton.setLayoutY(350);
		cleanButton.setLayoutX(330);
		cleanButton.setLayoutY(350);
		
		fotoButton.setLayoutX(305);
		fotoButton.setLayoutY(140);
		
		userImageView.setLayoutX(300);
		userImageView.setLayoutY(30);
		
		
		
		formPane.getChildren().addAll(nameLabel,userLabel,passwordLabel,nameTextField,userTextField,passwordField,saveButton,cleanButton,fotoButton,userImageView);
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
		userLabel = new Label("Usu�rio: ");
		passwordLabel = new Label("Senha: ");
		
		nameTextField = new TextField();
		nameTextField.setPrefWidth(400);
		passwordField = new PasswordField();
		passwordField.setPrefWidth(400);
		userTextField = new TextField();
		userTextField.setPrefWidth(400);
		
		saveButton = new Button("Salvar");
		cleanButton = new Button("Limpar");
		fotoButton = new Button("Inserir foto");
		
		userImage = new Image(getClass().getResourceAsStream("images\\profile.png"));
		userImageView = new ImageView(userImage);
		userImageView.setFitHeight(100);
		userImageView.setFitWidth(100);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
