package br.com.job.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.job.control.MenuControl;
import br.com.job.dao.UserDAO;
import br.com.job.model.Status;
import br.com.job.model.Task;
import br.com.job.utils.StyleUtils;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class TaskEdit extends GridPane {

    MenuControl controller;
    Task task;

    SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public TaskEdit(MenuControl controller) {
        this.controller = controller;
        loadElements();
    }

    public TaskEdit(MenuControl controller, Task task){
        this.controller = controller;
        this.task = task;
        loadElements();
    }

    public void loadElements() {
        Label lblTitle = new Label("Título");
        TextField txtTitle = new TextField();

        Label lblDesc = new Label("Descrição");
        TextField txtDesc = new TextField();

        Label lblStatus = new Label("Status");
        ChoiceBox<Status> selectStatus = new ChoiceBox<>(FXCollections.observableArrayList(
                Status.values())
        );

        Label lblHoursToSpend = new Label("Horas previstas");
        TextField txtHoursToSpend = new TextField("");

        Label lblHoursSpent = new Label("Horas gastas");
        TextField txtHoursSpent = new TextField("");

        Label lblAssignee = new Label("Responsável");
        TextField txtAssignee = new TextField("");

        Label lblIniDate = new Label("Data Inicial");
        TextField txtIniDate = new TextField("");

        Label lblEndDate = new Label("Data Final");
        TextField txtEndDate = new TextField("");

        lblTitle.setStyle(StyleUtils.LBL_TASK);
        lblDesc.setStyle(StyleUtils.LBL_TASK);
        lblStatus.setStyle(StyleUtils.LBL_TASK);

        lblTitle.setAlignment(Pos.CENTER);
        lblDesc.setAlignment(Pos.CENTER);

        //lblTitle.setTextFill(Color.WHITE);
        //lblDesc.setTextFill(Color.WHITE);

        txtTitle.setStyle(StyleUtils.TXT_TASK);
        txtDesc.setStyle(StyleUtils.TXT_TASK);

        //TODO aplicar calendário para seleção de data no dueDate;

        Button btnBack = new Button("❮ Voltar");
        Button btnSave = new Button("Salvar ✔");

        btnBack.setOnAction(e -> {
            controller.changeScreen(new SprintPane(controller));
        });

        btnSave.setOnAction(e -> {
            boolean salvar = true;
            if(task == null) {
                salvar = false;
                task = new Task();
            }

            task.setTitle(txtTitle.getText());
            task.setDescription(txtDesc.getText());
            task.setStatus(selectStatus.getValue());
            task.setHoursToSpend(1);
            task.setHoursSpent(1);
            //task.setAssignee(new UserDAO().getUser("1"));
            task.setIniDate(new Date());
            task.setEndDate(new Date());

            task.save(salvar);
            controller.changeScreen(new SprintPane(controller));
        });

        btnBack.setStyle(StyleUtils.BTN_TASK);
        btnSave.setStyle(StyleUtils.BTN_TASK);

        add(lblTitle, 0, 0);
        add(txtTitle, 1, 0);

        add(lblDesc, 0, 1);
        add(txtDesc, 1, 1);

        add(lblStatus, 0, 2);
        add(selectStatus, 1, 2);

        add(btnBack, 0, 7, 1, 4);
        add(btnSave, 1, 7, 1, 4);

        if (task != null) {
            // carregar os dados

            txtTitle.setText(task.getTitle());
            txtDesc.setText(task.getDescription());
            selectStatus.setValue(task.getStatus());
        }

    }

}
