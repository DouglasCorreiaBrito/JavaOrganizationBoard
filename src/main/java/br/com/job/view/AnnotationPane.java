package br.com.job.view;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.HTMLEditor;

public class AnnotationPane extends FlowPane {

    public AnnotationPane() {

        setVgap(10);
        setHgap(10);

        for(int i = 0; i < 5; i++){
            getChildren().add(new Label("Annotation" + i));
        }
    }

}
