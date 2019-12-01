package br.com.job.view;

import java.util.List;

import br.com.job.control.MenuControl;
import br.com.job.dao.TaskDAO;
import br.com.job.model.Task;
import br.com.job.utils.StyleUtils;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class ConsultCalendars extends FlowPane {

    MenuControl controller;
    

    public ConsultCalendars(MenuControl controller) {
        this.controller = controller;
        setStyle(StyleUtils.CONSULTCALENDARS);
        List<Task> tasklist = new TaskDAO().getTasks();
        setOrientation(Orientation.VERTICAL);
        setVgap(20);

        
        for (Task task : tasklist) {
            Label taskLabel = new Label("Compromisso no dia: " + task.getIniDate().toString() + "\n " + task.getTitle() + " - " + task.getDescription());

            taskLabel.setTextFill(Color.WHITE);
            taskLabel.setTextAlignment(TextAlignment.CENTER);

            taskLabel.setStyle(StyleUtils.TASK_CALENDAR);


            getChildren().add(taskLabel);
        }

        Button btnBack = new Button("Voltar");
        btnBack.setStyle(StyleUtils.BTN_LOGIN);
        btnBack.setTextAlignment(TextAlignment.CENTER);

        btnBack.setOnAction(e -> controller.changeScreen(new CalendarPane(controller)));

        getChildren().add(btnBack);


    }

}
