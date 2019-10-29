package br.com.job.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class SprintScene extends Scene {

	public SprintScene(Parent root) {
		super(new FlowPane(), 600, 600);

		initComponents();
	}

	private void initComponents() {
		
		Button btn = new Button("GOTO Annotation");

		((FlowPane) getRoot()).getChildren().add(btn);
	}
	
	
}
