package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.model.Annotation;
import br.com.job.utils.StyleUtils;
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


        lblTitle.setStyle(StyleUtils.LBL_STYLE);
        lblDesc.setStyle(StyleUtils.LBL_STYLE);
        lblDueDate.setStyle(StyleUtils.LBL_STYLE);

        lblTitle.setAlignment(Pos.CENTER);
        lblDesc.setAlignment(Pos.CENTER);
        lblDueDate.setAlignment(Pos.CENTER);

        txtTitle.setStyle(StyleUtils.TXT_STYLE1);
        txtDesc.setStyle(StyleUtils.TXT_STYLE2);
        txtDueDate.setStyle(StyleUtils.TXT_STYLE3);

        //TODO aplicar calendário para seleção de data no dueDate;

        Button btnBack = new Button("❮ Voltar");
        Button btnSave = new Button("Salvar ✔");

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

        btnBack.setStyle(StyleUtils.BTN_STYLE);
        btnSave.setStyle(StyleUtils.BTN_STYLE);

        add(lblTitle, 2, 0);
        add(txtTitle, 3, 0);

        add(lblDesc, 0, 1);
        add(txtDesc, 1, 1);

        add(lblDueDate, 0, 0);
        add(txtDueDate, 1, 0);

        add(btnBack, 1, 7, 1, 4);
        add(btnSave, 2, 7, 1, 4);

        if (annotation != null) {
            // carregar os dados
            txtTitle.setText(annotation.getTitle());
            txtDesc.setText(annotation.getDescription());
            txtDueDate.setText(sdf.format(annotation.getExpireDate()));
        }

    }

}
