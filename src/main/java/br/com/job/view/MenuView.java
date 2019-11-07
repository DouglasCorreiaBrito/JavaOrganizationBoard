package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.model.User;
import br.com.job.utils.FileHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MenuView extends FlowPane {

    public MenuView(GridPane basePane, Pane dynamicPane, User loggedUser) {
        Button btnAnnotation = new Button("Anotações");
        Button btnSprint = new Button("Sprints");
        Button btnAgenda = new Button("Agenda");
        Button btnDesempenho = new Button("Desempenho");
        Button btnLogout = new Button("Logout");

        Label userName = new Label(loggedUser.getName());
        userName.setStyle("-fx-max-height: 50px;" +
                "-fx-min-height: 50px; " +
                "-fx-min-width: 250px; " +
                "-fx-max-width: 250px; ");
        userName.setTextFill(Color.WHITE);
        userName.setAlignment(Pos.CENTER);

        ImageView userImageView = loggedUser.getViewerImage();
        userImageView.setFitWidth(250);
        userImageView.setFitHeight(250);

        setMinWidth(250);
        setMaxWidth(250);

        MenuControl controller = new MenuControl(basePane, dynamicPane, loggedUser);

        String btnStyle = "-fx-background-radius: 0em; " +
                "-fx-background-color: #588ed6; " +
                "-fx-max-height: 50px;" +
                "-fx-min-height: 50px; " +
                "-fx-min-width: 250px; " +
                "-fx-max-width: 250px; ";

        btnAnnotation.setStyle(btnStyle);
        btnSprint.setStyle(btnStyle);
        btnAgenda.setStyle(btnStyle);
        btnDesempenho.setStyle(btnStyle);
        btnLogout.setStyle(btnStyle);

        btnAnnotation.setOnAction(e -> controller.changeScreen(new AnnotationPane(controller)));

        btnSprint.setOnAction(e -> controller.changeScreen(new SprintPane(controller)));

        btnAgenda.setOnAction(e -> controller.changeScreen(new Pane()));

        btnDesempenho.setOnAction(e -> controller.changeScreen(new Pane()));

        btnLogout.setOnAction(e -> controller.logout());

        getChildren().addAll(userImageView, userName, btnAnnotation, btnSprint, btnLogout);

        setStyle("-fx-background-color: #000;");

        basePane.autosize();
        setMinHeight(basePane.getHeight());
    }

}
