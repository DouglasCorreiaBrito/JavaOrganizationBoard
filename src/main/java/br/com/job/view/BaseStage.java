package br.com.job.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import br.com.job.model.User;
import br.com.job.utils.FileHandler;
import br.com.job.utils.StyleUtils;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BaseStage extends Application{
	
	private static Stage stage;
	private static GridPane basePane;

	private User loggedUser;

	private Pane telaDaDireita;
	private Pane menu;
	private Image gif;
	private ImageView gifView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		initComponets();
		BaseStage.stage = primaryStage;
		Scene scene = new Scene(basePane);

		stage.setResizable(false);
		stage.setScene(scene);
		stage.setTitle("JOB - Java Organization Board");
		stage.show();
	}

	private void initComponets() {
		
		Dimension d = getScreenResolution();
		basePane = new GridPane();
		basePane.setMinSize( d.getWidth() * 0.75,d.getHeight() * 0.75);

		basePane.setStyle(StyleUtils.BASE_BLANK);

		telaDaDireita = new Pane();
		menu = new MenuView(basePane, telaDaDireita, loggedUser);
		
		gif = new Image(FileHandler.getImage("giphy.gif"));
		gifView = new ImageView(gif);
		
		basePane.add(menu, 0, 0);
		basePane.add(telaDaDireita, 1, 0);
		basePane.add(gifView, 1, 0);
		

	}

	static Dimension getScreenResolution() {
		
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

	public BaseStage(User loggedUser){
		this.loggedUser = loggedUser;
	}

}
