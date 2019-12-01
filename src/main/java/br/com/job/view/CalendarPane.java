package br.com.job.view;

import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;

import br.com.job.control.MenuControl;
import br.com.job.utils.StyleUtils;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import jfxtras.scene.control.CalendarPicker;

public class CalendarPane extends FlowPane {

	MenuControl controller;
	private CalendarPicker cp = new CalendarPicker();
	private Button btnschedule = new Button("Agendar novo compromisso");
	private Button btnListschedule = new Button("Consultar compromissos");
	private Date dateToSchedule;

	public CalendarPane(MenuControl controller) {
		this.controller = controller;
		setStyle(StyleUtils.CALENDAR_PANE);
		btnListschedule.setStyle(StyleUtils.CALENDAR_BTN_NEW);
		btnschedule.setStyle(StyleUtils.CALENDAR_BTN_NEW);
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

		btnschedule.setOnAction(e-> controller.changeScreen(new ScheduleBuilder(dateToSchedule,controller)));
		
		btnListschedule.setOnAction(e-> controller.changeScreen(new ConsultCalendars(controller)));
	}

	private void loadCalendar(CalendarPicker cp) {
		cp.withCalendar(Calendar.getInstance());
		cp.withShowTime(Boolean.TRUE);
		Dimension d = BaseStage.getScreenResolution();
		double width = d.getWidth() * 0.52;
		double heigth = d.getHeight() * 0.30;
		cp.setMinSize(width, heigth);
		cp.setStyle(StyleUtils.CALENDAR_PICKER);
	}

}
