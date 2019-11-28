package br.com.job.view;

import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;

import br.com.job.control.MenuControl;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import jfxtras.scene.control.CalendarPicker;

public class CalendarPane extends FlowPane {

	MenuControl controller;
	private CalendarPicker cp = new CalendarPicker();
	private Button btnschedule = new Button("Agendar novo compromisso");
	private Button btnListschedule = new Button("Consultar compromissos");
	private Date dateToSchedule;

	public CalendarPane(MenuControl controller) {
		this.controller = controller;
		setStyle("-fx-background-color: #00FF7F");
		loadCalendar(cp);
		initListeners(cp, btnschedule);
		getChildren().addAll(cp, btnschedule,btnListschedule);
	}

	private void initListeners(CalendarPicker cp, Button btnschedule) {
		
		cp.calendarProperty().addListener(new ChangeListener<Calendar>() {
			@Override
			public void changed(ObservableValue<? extends Calendar> observable, Calendar oldValueDate, Calendar newValueDate) {
				dateToSchedule = newValueDate.getTime();
			}
		});

//		btnschedule.setOnAction(e -> callScheduleBuilder(dateToSchedule));
		btnschedule.setOnAction(e-> controller.changeScreen(new ScheduleBuilder(dateToSchedule,controller)));
		
		btnListschedule.setOnAction(e-> controller.changeScreen(new Scheduledcalendars(controller)));
	}

	private void loadCalendar(CalendarPicker cp) {
		cp.withCalendar(Calendar.getInstance());
		cp.withShowTime(Boolean.TRUE);
		Dimension d = BaseStage.getScreenResolution();
		double width = d.getWidth() * 0.52;
		double heigth = d.getHeight() * 0.40;
		cp.setMinSize(width, heigth);
	}

}
