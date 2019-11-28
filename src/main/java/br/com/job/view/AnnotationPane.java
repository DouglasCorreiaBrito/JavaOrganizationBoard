package br.com.job.view;

import java.util.Date;

import br.com.job.control.MenuControl;
import br.com.job.model.Annotation;
import br.com.job.utils.StyleUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.TextAlignment;

public class AnnotationPane extends FlowPane {

	MenuControl controller;

	public AnnotationPane(MenuControl controller) {

		this.controller = controller;
		setStyle(StyleUtils.ANTN_PANE);
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

		Button newCard = new Button("✚ Nova Anotação");
		newCard.setStyle(StyleUtils.BTN_NEW);
//		newCard.setAlignment(Pos.CENTER);
		newCard.setTextAlignment(TextAlignment.CENTER);
		newCard.setOnAction(e -> controller.changeScreen(new AnnotationEdit(controller)));

		newCardContainter.setAlignment(Pos.BOTTOM_CENTER);
		newCardContainter.getChildren().add(newCard);
		newCardContainter.setStyle(StyleUtils.BTN_BOTTOM);

		getChildren().add(newCardContainter);

	}

}
