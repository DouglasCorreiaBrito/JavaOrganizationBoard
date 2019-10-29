package br.com.job.view;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class AnnotationScene extends Scene {

	public AnnotationScene(Parent root) {
		super(new FlowPane(), 600, 600);

		initComponents();

	}

	public void initComponents() {

		Button btn = new Button("GOTO Sprint");

		((FlowPane) getRoot()).getChildren().add(btn);
	}
}
