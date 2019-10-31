package br.com.job.control;

import br.com.job.view.BaseStage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class BaseStageControl {

    GridPane backgroundPane;
    Pane secondScreen;

    public BaseStageControl(GridPane backgroundPane, Pane secondScreen){
        this.backgroundPane = backgroundPane;
        this.secondScreen = secondScreen;
    }

    public void changeScreen(Pane secondScreen){
        backgroundPane.getChildren().remove(this.secondScreen);
        backgroundPane.add(secondScreen, 1, 0);

        this.secondScreen = secondScreen;

    }

}
