package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.model.Annotation;
import br.com.job.model.Task;
import br.com.job.utils.StyleUtils;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class AnnotationEdit extends GridPane {

    MenuControl controller;
    Annotation annotation;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public AnnotationEdit(MenuControl controller) {
        this.controller = controller;
        try {
			loadElements();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }

    public AnnotationEdit(MenuControl controller, Annotation annotation){
        this.controller = controller;
        this.annotation = annotation;
        try {
			loadElements();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void loadElements() throws ParseException {
        Label lblTitle = new Label("Título");
        TextField txtTitle = new TextField();

        Label lblDesc = new Label("Descrição");
        TextField txtDesc = new TextField();

        Label lblDueDate = new Label("Prazo");
       // TextField txtDueDate = new TextField();
        DatePicker dpDueDate = new DatePicker();


        lblTitle.setStyle(StyleUtils.LBL_STYLE);
        lblDesc.setStyle(StyleUtils.LBL_STYLE);
        lblDueDate.setStyle(StyleUtils.LBL_STYLE);

        lblTitle.setAlignment(Pos.CENTER);
        lblDesc.setAlignment(Pos.CENTER);
        lblDueDate.setAlignment(Pos.CENTER);

        txtTitle.setStyle(StyleUtils.TXT_STYLE1);
        txtDesc.setStyle(StyleUtils.TXT_STYLE2);
        dpDueDate.setStyle(StyleUtils.TXT_STYLE3);

        //TODO aplicar calendário para seleção de data no dueDate;

        Button btnBack = new Button("❮ Voltar");
        Button btnSave = new Button("Salvar ✔");

        btnBack.setOnAction(e -> {
        	System.out.println(dpDueDate.getValue());
            controller.changeScreen(new AnnotationPane(controller));
        });

        btnSave.setOnAction(e -> {
        	boolean salvar = true;
            if(annotation == null) {
                salvar = false;
                annotation = new Annotation();
            }
        	
			annotation.setExpireDate(LocalDateToDate(dpDueDate.getValue()));
			annotation.setTitle(txtTitle.getText());
			annotation.setDescription(txtDesc.getText());
			annotation.save(salvar);
			controller.changeScreen(new AnnotationPane(controller));
        });

        btnBack.setStyle(StyleUtils.BTN_STYLE);
        btnSave.setStyle(StyleUtils.BTN_STYLE);

        add(lblTitle, 2, 0);
        add(txtTitle, 3, 0);

        add(lblDesc, 0, 1);
        add(txtDesc, 1, 1);

        add(lblDueDate, 0, 0);
        add(dpDueDate, 1, 0);

        add(btnBack, 1, 7, 1, 4);
        add(btnSave, 2, 7, 1, 4);

        if (annotation != null) {
            // carregar os dados
            txtTitle.setText(annotation.getTitle());
            txtDesc.setText(annotation.getDescription());
            dpDueDate.setPromptText(sdf.format(annotation.getExpireDate()));
        }

    }

	private Date LocalDateToDate(LocalDate localDate) {
		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		Date date = Date.from(instant);
		System.out.println(date);
		return date;
	}

}
