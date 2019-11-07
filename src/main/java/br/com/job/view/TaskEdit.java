package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.model.Status;
import br.com.job.model.Task;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.text.SimpleDateFormat;

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

        SelectionModel<Status> selectionModel = new SingleSelectionModel<Status>() {
            @Override
            protected Status getModelItem(int index) {
                return Status.values()[index];
            }

            @Override
            protected int getItemCount() {
                return Status.values().length;
            }
        };

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

        lblTitle.setTextFill(Color.WHITE);
        lblDesc.setTextFill(Color.WHITE);

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

        add(btnBack, 0, 4, 1, 4);
        add(btnSave, 1, 4, 1, 4);

        if (task != null) {
            // carregar os dados
            txtTitle.setText(task.getTitle());
            txtDesc.setText(task.getDescription());
        }

    }

}
