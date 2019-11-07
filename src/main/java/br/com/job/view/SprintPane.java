package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.model.Sprint;
import br.com.job.model.Task;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class SprintPane extends Pane {

    MenuControl controller;

    public SprintPane(MenuControl controller) {
        this.controller = controller;

        Sprint sprint = new Sprint();
        List<Task> tasks = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Task task = new Task();

            task.setId(1);
            task.setDescription("Descrição da tarefa");

            tasks.add(task);
        }

    }

}
