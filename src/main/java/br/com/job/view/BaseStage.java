package br.com.job.view;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BaseStage extends Application{
	
	private static Stage stage;
	private static AnchorPane basePane;
	private AnnotationScene annotationScene;
	private SprintScene sprintScene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		initComponets();
		BaseStage.stage = primaryStage;
		AnnotationScene annotationScene = new AnnotationScene(basePane);
		stage.setScene(annotationScene);
		stage.setTitle("Anotações");
		stage.show();
	}

	private void initComponets() {
		
		Dimension d = obterResolucaoTela();
		basePane = new AnchorPane();
		basePane.setPrefSize( d.getWidth(),d.getHeight());
		
	}

	private Dimension obterResolucaoTela() {
		
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension dimensionScreen = tk.getScreenSize();
	    return dimensionScreen;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static Stage getStage() {
		return stage;
	}




}
