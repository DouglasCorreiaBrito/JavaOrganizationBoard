package br.com.job.view;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;

import br.com.job.control.BaseStageControl;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BaseStage extends Application{
	
	private static Stage stage;
	private static GridPane basePane;

	Pane telaDaDireita;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		initComponets();
		BaseStage.stage = primaryStage;
		Scene scene = new Scene(basePane);

		stage.setScene(scene);
		stage.setTitle("JOB - Java Organization Board");
		stage.show();
	}

	private void initComponets() {
		
		Dimension d = obterResolucaoTela();
		basePane = new GridPane();
		basePane.setPrefSize( d.getWidth(),d.getHeight());

		telaDaDireita = new Pane();

		basePane.add(new MenuView(basePane, telaDaDireita), 0, 0);
		basePane.add(telaDaDireita, 1, 0);

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
