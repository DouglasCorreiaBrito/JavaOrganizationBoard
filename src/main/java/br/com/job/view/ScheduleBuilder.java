package br.com.job.view;

import java.util.Date;

import br.com.job.model.Schedule;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class ScheduleBuilder extends Application {

	private Schedule schedule;
	private Date dateToSchedule;
	private Label stringDateToSchedule;
	private Label lbTitle;
	private Label lbDesc;
	private TextField tfTitle;
	private HTMLEditor taDesc;
	private Button btnSave;
	private Button btnClose;
	private GridPane pane;
	
	public ScheduleBuilder(Date dateToSchedule) {
		this.dateToSchedule = dateToSchedule;
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		initComponents();
		initLayout();
		Scene scene = new Scene(pane);
		stage.setResizable(false);
		stage.setTitle("Agende seu compromisso");
		stage.setScene(scene);
		stage.show();
		
	}

	private void initLayout() {
		
		pane.add(lbTitle, 0, 0);
		pane.add(tfTitle, 0, 1);
		pane.add(lbDesc, 0, 2);
		pane.add(taDesc, 0, 3);
		pane.add(stringDateToSchedule, 0, 4);
		pane.add(btnSave, 0, 5);
		pane.add(btnClose, 0, 6);
		
	}

	private void initComponents() {
		lbTitle = new Label("Título da tarefa");
		lbDesc = new Label("Descreva seu agendamento");
		taDesc = new HTMLEditor();
		tfTitle = new TextField();
		stringDateToSchedule = new Label(dateToSchedule.toString());
		btnClose = new Button("Cancelar");
		btnSave = new Button("Salvar");
		pane = new GridPane();
		pane.setPrefSize(300, 600);
		pane.setStyle("-fx-background-color : linear-gradient(#16EDEB,#175B60)");
		
	}


}
