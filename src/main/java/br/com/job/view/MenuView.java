package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.model.User;
import br.com.job.utils.FileHandler;
import br.com.job.utils.StyleUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MenuView extends FlowPane {

    public MenuView(GridPane basePane, Pane dynamicPane, User loggedUser) {
        Button btnAnnotation = new Button("Anotações");
        Button btnSprint = new Button("Sprints");
        Button btnAgenda = new Button("Agenda");
        Button btnDesempenho = new Button("Desempenho");
        Button btnLogout = new Button("Logout");

        Label userName = new Label(loggedUser.getName());
        userName.setStyle(StyleUtils.USER_NAME);
        userName.setTextFill(Color.WHITE);
        userName.setAlignment(Pos.CENTER);

        ImageView userImageView = new ImageView(loggedUser.getProfileImage());
        userImageView.setFitWidth(250);
        userImageView.setFitHeight(250);

        setMinWidth(250);
        setMaxWidth(250);

        MenuControl controller = new MenuControl(basePane, dynamicPane, loggedUser);

        btnAnnotation.setStyle(StyleUtils.BTN_MENU);
        btnSprint.setStyle(StyleUtils.BTN_MENU);
        btnAgenda.setStyle(StyleUtils.BTN_MENU);
        btnDesempenho.setStyle(StyleUtils.BTN_MENU);
        btnLogout.setStyle(StyleUtils.BTN_LOGOUT);

        btnAnnotation.setOnAction(e -> controller.changeScreen(new AnnotationPane(controller)));

        btnSprint.setOnAction(e -> controller.changeScreen(new SprintPane(controller)));

        btnAgenda.setOnAction(e -> controller.changeScreen(new CalendarPane(controller)));

        btnDesempenho.setOnAction(e -> controller.changeScreen(new Pane()));

        btnLogout.setOnAction(e -> logout());

        getChildren().addAll(userImageView, userName, btnAnnotation, btnSprint, btnAgenda, btnLogout);

        setStyle(StyleUtils.MENU_LAT);

        basePane.autosize();
        setMinHeight(basePane.getHeight());
    }

    private void logout() {
        try {
            new LoginScreen().start(new Stage());
            BaseStage.getStage().close();
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }

}
