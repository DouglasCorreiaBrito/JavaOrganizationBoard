package br.com.job.view;

import br.com.job.model.Annotation;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;

public class AnnotationCard extends Pane {

    private double width = 250;
    private double height = 280;

    public AnnotationCard(Annotation annotation) {

        setStyle("-fx-background-color: #588ed6");
        setMinWidth(width);
        setMinHeight(height);
        setMaxWidth(width);
        setMaxHeight(height);

        Label title = new Label(annotation.getTitle());
        Text desc = new Text(annotation.getDescription());
        Label date = new Label(new SimpleDateFormat("dd/MM/YYYY").format(annotation.getExpireDate()));

        title.setLayoutX(height / 2);
        title.setLayoutY(5);

        date.setLayoutX(10);
        date.setLayoutY(5);

        desc.setX(10);
        desc.setY(40);
        desc.setWrappingWidth(width - 20);

        getChildren().addAll(title, desc, date);

    }

}
