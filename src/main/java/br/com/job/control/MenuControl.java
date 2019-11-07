package br.com.job.control;

import br.com.job.model.User;
import br.com.job.view.BaseStage;
import br.com.job.view.LoginScreen;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuControl {

    private User user;
    private GridPane backgroundPane;
    private ScrollPane secondScreen;

    public MenuControl(GridPane backgroundPane, Pane secondScreen, User loggedUser) {

        secondScreen.setMinWidth(backgroundPane.getWidth() - 250);
        secondScreen.setPrefWidth(backgroundPane.getWidth() - 250);

        secondScreen.setPadding(new Insets(30));

        this.backgroundPane = backgroundPane;
        this.secondScreen = new ScrollPane();
    }

    public void changeScreen(Pane secondScreen){
        backgroundPane.getChildren().remove(this.secondScreen);

        secondScreen.setMinWidth(backgroundPane.getWidth() - 250);
        secondScreen.setPrefWidth(backgroundPane.getWidth() - 250);

        secondScreen.setPadding(new Insets(30));

        ScrollPane scrollPane = new ScrollPane(secondScreen);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setFitToHeight(true);
        secondScreen.setStyle(secondScreen.getStyle() + "-fx-background-color: #444444;");

        backgroundPane.add(scrollPane, 1, 0);
        this.secondScreen = scrollPane;
    }

    public void logout() {
        try {
            new LoginScreen().start(new Stage());
            BaseStage.getStage().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
