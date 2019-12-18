package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.dao.TaskDAO;
import br.com.job.model.Sprint;
import br.com.job.model.Task;
import br.com.job.utils.StyleUtils;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class SprintPane extends FlowPane {

    MenuControl controller;

    public SprintPane(MenuControl controller) {
        this.controller = controller;
        setStyle(StyleUtils.SPRINT_PANE);

        setOrientation(Orientation.VERTICAL);
        setVgap(20);

        Sprint sprint = new Sprint();
        sprint.setNumber(1);
        sprint.setDescription("Faculdade");
        sprint.setTag("FZL");
        sprint.setTasks(new TaskDAO().getTasks());

        for (Task task : sprint.getTasks()) {
            Label taskLabel = new Label("[" + task.getStatus().name() + "] " + task.getTitle() + " - " + task.getDescription());

            taskLabel.setTextFill(Color.BLACK);

            taskLabel.setMaxWidth(900);
            taskLabel.setMinWidth(900);

            taskLabel.setStyle(StyleUtils.TASK_LABEL);

            taskLabel.setOnMouseClicked(event -> {
                controller.changeScreen(new TaskEdit(controller, task));
            });

            getChildren().add(taskLabel);
        }

        Button btnNewTask = new Button("✚ Nova Sprint");
        btnNewTask.setStyle(StyleUtils.BTN_ADDSPRINT);
        btnNewTask.setTextAlignment(TextAlignment.CENTER);

        btnNewTask.setOnAction(e -> controller.changeScreen(new TaskEdit(controller)));

        getChildren().add(btnNewTask);


    }

}
