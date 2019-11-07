package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.model.Annotation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import java.util.Date;

public class AnnotationPane extends FlowPane {

	MenuControl controller;

	public AnnotationPane(MenuControl controller) {

		this.controller = controller;

		setVgap(50);
		setHgap(50);

		for (int i = 0; i < 10; i++) {
			Annotation annotation = new Annotation();

			annotation.setTitle("Título " + i);
			annotation
					.setDescription("Little description about the annotation. I will write something here just to test"
							+ " this functionality. This is just a test, we will have more things to write with the proper classes");
			annotation.setExpireDate(new Date());

			getChildren().add(new AnnotationCard(annotation));
		}

		FlowPane newCardContainter = new FlowPane();
		newCardContainter.setMinWidth(250);
		newCardContainter.setMaxWidth(250);

		Button newCard = new Button("+");
		newCard.setStyle("-fx-background-radius: 0em; " + "-fx-background-color: #588ed6; " + "-fx-max-height: 100px;"
				+ "-fx-min-height: 100px; " + "-fx-min-width: 100px; " + "-fx-max-width: 100px; ");
		newCard.setOnAction(e -> controller.changeScreen(new AnnotationEdit(controller)));

		newCardContainter.setAlignment(Pos.CENTER);
		newCardContainter.getChildren().add(newCard);

		getChildren().add(newCardContainter);

	}

}
