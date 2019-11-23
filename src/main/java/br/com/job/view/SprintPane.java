package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.model.Sprint;
import br.com.job.model.Status;
import br.com.job.model.Task;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class SprintPane extends FlowPane {

    MenuControl controller;

    public SprintPane(MenuControl controller) {
        this.controller = controller;
        setStyle("-fx-background-color: #B0E0E6;");

        setOrientation(Orientation.VERTICAL);
        setVgap(20);

        Sprint sprint = new Sprint();
        // We will get sprint data here, with the database connection.
        // by now, we have only mocked data:

        // **** MODEL **** //

        List<Task> tasks = new ArrayList<>();

        sprint.setNumber(1);
        sprint.setDescription("Faculdade");
        sprint.setTag("FZL");

        for (int i = 0; i < 5; i++) {
            Task task = new Task();

            task.setId(i);
            task.setDescription("Descrição da tarefa " + i);
            task.setStatus(Status.ToDo);
            task.setTitle(sprint.getTag() + "-" + task.getId());

            tasks.add(task);
        }

        sprint.setTasks(tasks);

        // **** END MODEL **** //

        for (Task task : sprint.getTasks()) {
            Label taskLabel = new Label(task.getTitle() + " " + task.getDescription());

            taskLabel.setTextFill(Color.BLACK);

            taskLabel.setMaxWidth(900);
            taskLabel.setMinWidth(900);

            taskLabel.setStyle("-fx-background-color: #588ed6;" +
                    "-fx-min-height: 40px; " +
                    "-fx-max-height: 40px; ");

            taskLabel.setOnMouseClicked(event -> {
                controller.changeScreen(new TaskEdit(controller, task));
            });

            getChildren().add(taskLabel);
        }

        Button btnNewTask = new Button("+");
        btnNewTask.setStyle("-fx-background-radius: 0em; " +
                "-fx-background-color: #588ed6; " +
                "-fx-max-height: 40px;" +
                "-fx-min-height: 40px; " +
                "-fx-min-width: 40px; " +
                "-fx-max-width: 40px; ");

        btnNewTask.setOnAction(e -> controller.changeScreen(new TaskEdit(controller)));

        getChildren().add(btnNewTask);


    }

}
