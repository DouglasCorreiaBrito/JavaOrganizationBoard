package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.model.Annotation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AnnotationEdit extends GridPane {

    MenuControl controller;
    Annotation annotation;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public AnnotationEdit(MenuControl controller) {
        this.controller = controller;
        loadElements();
    }

    public AnnotationEdit(MenuControl controller, Annotation annotation){
        this.controller = controller;
        this.annotation = annotation;
        loadElements();
    }

    public void loadElements() {
        Label lblTitle = new Label("Título");
        TextField txtTitle = new TextField();

        Label lblDesc = new Label("Descrição");
        TextField txtDesc = new TextField();

        Label lblDueDate = new Label("Prazo");
        TextField txtDueDate = new TextField();

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
        lblDueDate.setStyle(labelStyle);

        lblTitle.setAlignment(Pos.CENTER);
        lblDesc.setAlignment(Pos.CENTER);
        lblDueDate.setAlignment(Pos.CENTER);

        lblTitle.setTextFill(Color.WHITE);
        lblDesc.setTextFill(Color.WHITE);
        lblDueDate.setTextFill(Color.WHITE);

        txtTitle.setStyle(textFieldStyle);
        txtDesc.setStyle(textFieldStyle);
        txtDueDate.setStyle(textFieldStyle);

        //TODO aplicar calendário para seleção de data no dueDate;

        Button btnBack = new Button("Voltar");
        Button btnSave = new Button("Salvar");

        btnBack.setOnAction(e -> {
            controller.changeScreen(new AnnotationPane(controller));
        });

        btnSave.setOnAction(e -> {
            try {
                annotation.setExpireDate(sdf.parse(txtDueDate.getText()));
                annotation.setTitle(txtTitle.getText());
                annotation.setDescription(txtTitle.getText());
                annotation.save();
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        });

        btnBack.setStyle(buttonStyle);
        btnSave.setStyle(buttonStyle);

        add(lblTitle, 0, 0);
        add(txtTitle, 1, 0);

        add(lblDesc, 0, 1);
        add(txtDesc, 1, 1);

        add(lblDueDate, 0, 2);
        add(txtDueDate, 1, 2);

        add(btnBack, 0, 4, 1, 4);
        add(btnSave, 1, 4, 1, 4);

        if (annotation != null) {
            // carregar os dados
            txtTitle.setText(annotation.getTitle());
            txtDesc.setText(annotation.getDescription());
            txtDueDate.setText(sdf.format(annotation.getExpireDate()));
        }

    }

}
