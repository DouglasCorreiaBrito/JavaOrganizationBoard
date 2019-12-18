package br.com.job.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.job.control.MenuControl;
import br.com.job.model.Task;
import br.com.job.utils.StyleUtils;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ScheduleBuilder extends GridPane {

	private Date dateToSchedule;
	private Label labelDateToSchedule;
	private Label lbTitle;
	private Label lbDesc;
	private TextField tfTitle;
	private TextArea taDesc;
	private Button btnSave;
	private Button btnClose;
	private GridPane pane;
	private SimpleDateFormat sdf;
	private MenuControl controller;
	private Task task;

	public ScheduleBuilder(Date dateToSchedule, MenuControl controller) {
		this.controller = controller;
		sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		this.dateToSchedule = dateToSchedule;
		initComponents();
		initLayout();
		initListeners();

	}

	private void initListeners() {

		btnClose.setOnAction(e -> controller.changeScreen(new CalendarPane(controller)));
		
		 btnSave.setOnAction(e -> {
	            boolean salvar = true;
	            if(task == null) {
	                salvar = false;
	                task = new Task();
	            }

	            task.setTitle(tfTitle.getText());
	            task.setDescription(taDesc.getText());
	            task.setIniDate(dateToSchedule);
	            task.saveTaskWithCalendar(salvar);
	            controller.changeScreen(new CalendarPane(controller));
	        });
	}

	private void initLayout() {

		add(labelDateToSchedule, 0, 0);
		add(lbTitle, 0, 1);
		add(tfTitle, 0, 2);
		add(lbDesc, 0, 3);
		add(taDesc, 0, 4);
		add(btnSave, 0, 6);
		add(btnClose, 0, 7);

	}

	private void initComponents() {
		lbTitle = new Label("Título da tarefa");
		lbTitle.setStyle("-fx-font-size: 24px;" + " -fx-text-fill: #000000;" + " -fx-font-family: 'Times New Roman';"
				+ "-fx-padding: 5px;" + "-fx-border-insets: 5px;" + "-fx-background-insets: 5px;");

		lbDesc = new Label("Descreva seu agendamento");
		lbDesc.setStyle("-fx-font-size: 18px;" + " -fx-text-fill: #000000;" + " -fx-font-family: 'Times New Roman';"
				+ "-fx-padding: 5px;" + "-fx-border-insets: 5px;" + "-fx-background-insets: 5px;");

		taDesc = new TextArea();
		taDesc.setStyle("-fx-padding: 5px;" + "-fx-border-insets: 5px;" + "-fx-background-insets: 5px;");

		tfTitle = new TextField();
		labelDateToSchedule = new Label(" Você está agendando seu compromisso para: " + sdf.format(dateToSchedule));
		labelDateToSchedule
				.setStyle("-fx-font-size: 18px;" + " -fx-text-fill: #000000;" + " -fx-font-family: 'Times New Roman';"
						+ "-fx-padding: 5px;" + "-fx-border-insets: 5px;" + "-fx-background-insets: 5px;");
		
		btnClose = new Button("Cancelar");
		btnClose.setStyle(StyleUtils.BTN_LOGIN + "-fx-padding: 5px;" + "-fx-border-insets: 5px;" + "-fx-background-insets: 5px;");
		
		btnSave = new Button("Salvar");
		btnSave.setStyle(StyleUtils.BTN_LOGIN+ "-fx-padding: 5px;" + "-fx-border-insets: 5px;" + "-fx-background-insets: 5px;");
	}

}
