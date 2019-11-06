package br.com.job.control;

import br.com.job.model.User;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MenuControl {

    private User user;
    private GridPane backgroundPane;
    private Pane secondScreen;

    public MenuControl(GridPane backgroundPane, Pane secondScreen, User loggedUser) {

        secondScreen.setMinWidth(backgroundPane.getWidth() - 250);
        secondScreen.setPrefWidth(backgroundPane.getWidth() - 250);

        secondScreen.setPadding(new Insets(30));

        this.backgroundPane = backgroundPane;
        this.secondScreen = secondScreen;
    }

    public void changeScreen(Pane secondScreen){
        backgroundPane.getChildren().remove(this.secondScreen);

        secondScreen.setMinWidth(backgroundPane.getWidth() - 250);
        secondScreen.setPrefWidth(backgroundPane.getWidth() - 250);

        secondScreen.setPadding(new Insets(30));

        backgroundPane.add(secondScreen, 1, 0);
        this.secondScreen = secondScreen;



    }
}
