package br.com.job.view;

import java.util.ArrayList;
import java.util.List;

import br.com.job.control.MenuControl;
import br.com.job.model.Sprint;
import br.com.job.model.Status;
import br.com.job.model.Task;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class SprintPane extends FlowPane {

    MenuControl controller;

    public SprintPane(MenuControl controller) {
        this.controller = controller;

        setOrientation(Orientation.VERTICAL);
        setVgap(20);

        Sprint sprint = new Sprint();

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

        sprint.getTasks().forEach(task -> {
            Label taskLabel = new Label(task.getTitle() + " " + task.getDescription());

            taskLabel.setTextFill(Color.BLACK);

            taskLabel.setMaxWidth(900);
            taskLabel.setMinWidth(900);

            taskLabel.setStyle("-fx-background-color: #588ed6;" +
                    "-fx-min-height: 40px; " +
                    "-fx-max-height: 40px; ");

            getChildren().add(taskLabel);
        });

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
