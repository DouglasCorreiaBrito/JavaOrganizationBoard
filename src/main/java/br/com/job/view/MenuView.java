package br.com.job.view;

import br.com.job.control.MenuControl;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MenuView extends FlowPane {

    public MenuView(GridPane basePane, Pane dynamicPane) {
        Button btnAnnotation = new Button("Annotations");
        Button btnSprint = new Button("Sprints");

        MenuControl controler = new MenuControl(basePane, dynamicPane);

        btnAnnotation.setOnAction(e -> {
            controler.changeScreen(new AnnotationPane());
        });

        btnSprint.setOnAction(e -> {
            controler.changeScreen(new SprintPane());
        });

        getChildren().addAll(btnAnnotation, btnSprint);

    }

}
