package br.com.job.view;

import java.text.SimpleDateFormat;

import br.com.job.control.MenuControl;
import br.com.job.model.Status;
import br.com.job.model.Task;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class TaskEdit extends GridPane {

    MenuControl controller;
    Task task;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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


        String labelStyle = "-fx-max-height: 50px;" +
                "-fx-min-height: 50px; " +
                "-fx-min-width: 250px; " +
                "-fx-max-width: 250px; ";

        String textFieldStyle = "-fx-max-height: 50px;" +
                "-fx-min-height: 50px; " +
                "-fx-min-width: 250px; " +
                "-fx-max-width: 250px; ";

        String buttonStyle = "-fx-background-radius: 0em; " +
                "-fx-background-color: #588ed6; " +
                "-fx-max-height: 50px;" +
                "-fx-min-height: 50px; " +
                "-fx-min-width: 250px; " +
                "-fx-max-width: 250px; ";

        lblTitle.setStyle(labelStyle);
        lblDesc.setStyle(labelStyle);

        lblTitle.setAlignment(Pos.CENTER);
        lblDesc.setAlignment(Pos.CENTER);

        //lblTitle.setTextFill(Color.WHITE);
        //lblDesc.setTextFill(Color.WHITE);

        txtTitle.setStyle(textFieldStyle);
        txtDesc.setStyle(textFieldStyle);

        //TODO aplicar calendário para seleção de data no dueDate;

        Button btnBack = new Button("Voltar");
        Button btnSave = new Button("Salvar");

        btnBack.setOnAction(e -> {
            controller.changeScreen(new SprintPane(controller));
        });

        btnSave.setOnAction(e -> {
            task.setTitle(txtTitle.getText());
            task.setDescription(txtTitle.getText());
            task.save();
        });

        btnBack.setStyle(buttonStyle);
        btnSave.setStyle(buttonStyle);

        add(lblTitle, 0, 0);
        add(txtTitle, 1, 0);

        add(lblDesc, 0, 1);
        add(txtDesc, 1, 1);

        add(selectStatus, 0, 4);

        add(btnBack, 0, 5, 1, 4);
        add(btnSave, 1, 5, 1, 4);


        if (task != null) {
            // carregar os dados

            SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");

            txtTitle.setText(task.getTitle());
            txtDesc.setText(task.getDescription());
            txtHoursToSpend.setText(hourFormat.format(task.getHoursToSpend()));
            txtHoursSpent.setText(hourFormat.format(task.getHoursToSpend()));

            //Label lblHoursToSpend = new Label("Horas previstas");
            //TextField txtHoursToSpend = new TextField("");

            //Label lblHoursSpent = new Label("Horas gastas");
            //TextField txtHoursSpent = new TextField("");

            //Label lblAssignee = new Label("Responsável");
            //TextField txtAssignee = new TextField("");

            //Label lblIniDate = new Label("Data Inicial");
            //TextField txtIniDate = new TextField("");

            //Label lblEndDate = new Label("Data Final");
            //TextField txtEndDate = new TextField("");

        }

    }

}
