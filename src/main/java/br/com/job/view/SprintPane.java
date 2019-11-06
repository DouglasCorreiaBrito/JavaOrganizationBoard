package br.com.job.view;

import br.com.job.control.MenuControl;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class SprintPane extends Pane {

    MenuControl controller;

    public SprintPane(MenuControl controller) {
        this.controller = controller;
        getChildren().add(new Label("Sprints"));
    }

}
