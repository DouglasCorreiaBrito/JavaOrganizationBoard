package br.com.job.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

public class MainTeste extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        PanelTeste basePane = new PanelTeste();

        Scene scene = new Scene(basePane);
        stage.setResizable(false);
        stage.setTitle("JOB - LOGIN");
        stage.setScene(scene);
        stage.show();


    }
}
