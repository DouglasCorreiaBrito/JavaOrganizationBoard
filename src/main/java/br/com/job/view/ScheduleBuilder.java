package br.com.job.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.job.model.Schedule;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ScheduleBuilder extends Application {

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
	private static Stage stage;

	public ScheduleBuilder(Date dateToSchedule) {
		sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		this.dateToSchedule = dateToSchedule;
	}

	@Override
	public void start(Stage stage) throws Exception {
		ScheduleBuilder.stage = stage;
		initComponents();
		initLayout();
		initListeners();
		Scene scene = new Scene(pane);
		stage.setResizable(false);
		stage.setTitle("Agende seu compromisso");
		stage.setScene(scene);
		stage.show();

	}

	private void initListeners() {
		
		btnClose.setOnAction(e-> stage.close());
	}

	private void initLayout() {

		pane.add(lbTitle, 0, 0);
		pane.add(tfTitle, 0, 1);
		pane.add(lbDesc, 0, 2);
		pane.add(taDesc, 0, 3);
		pane.add(labelDateToSchedule, 0, 4);
		pane.add(btnSave, 0, 5);
		pane.add(btnClose, 0, 6);

	}

	private void initComponents() {
		lbTitle = new Label("Título da tarefa");
		lbTitle.setStyle("-fx-font-size: 24px;" +
            " -fx-text-fill: #FFF;" +
            " -fx-font-family: 'Times New Roman';");
		
		lbDesc = new Label("Descreva seu agendamento");
		lbDesc.setStyle("-fx-font-size: 18px;" +
            " -fx-text-fill: #FFF;" +
            " -fx-font-family: 'Times New Roman';");
		
		taDesc = new TextArea();
		tfTitle = new TextField();
		labelDateToSchedule = new Label(" Você está agendando seu compromisso para: " + sdf.format(dateToSchedule));
		labelDateToSchedule.setStyle("-fx-font-size: 18px;" +
            " -fx-text-fill: #FFF;" +
            " -fx-font-family: 'Times New Roman';");
		btnClose = new Button("Cancelar");
		btnSave = new Button("Salvar");
		pane = new GridPane();
		pane.setPrefSize(600, 300);
		pane.setStyle("-fx-background-color: #222222;"
        		+ "-fx-border-color: white;"
        		+ "-fx-border-width: 2;");
		

	}

}
