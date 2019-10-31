package br.com.job.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class PanelTeste extends FlowPane {

    public PanelTeste() {
        this.setMinHeight(200);
        this.setMinWidth(200);
    }

    public PanelTeste(String label) {
        this.getChildren().add(new Label(label));
    }

}
