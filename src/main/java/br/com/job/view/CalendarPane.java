package br.com.job.view;

import java.awt.Dimension;
import java.time.LocalDate;

import br.com.job.control.MenuControl;
import javafx.scene.layout.FlowPane;
import jfxtras.scene.control.CalendarPicker;

public class CalendarPane extends FlowPane {
	
	
	MenuControl controller;

	public CalendarPane(MenuControl controller) {
		this.controller = controller;
		setStyle("-fx-background-color: #FFFFFF");
		CalendarPicker cp = new CalendarPicker();
		loadCalendar(cp);
		initListeners(cp);
		getChildren().add(cp);
		
	}

	private void initListeners(CalendarPicker cp) {
		
		cp.setOnMousePressed(e-> callScheduleBuilder(cp));
	}

	private void callScheduleBuilder(CalendarPicker cp) {
		System.out.println("teste");
	}

	private void loadCalendar(CalendarPicker cp) {
		Dimension d = BaseStage.getScreenResolution();
		double width = d.getWidth()*0.52;
		double heigth = d.getHeight()*0.40;
		cp.setMinSize(width, heigth);
	}
	
}
