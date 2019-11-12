package br.com.job.view;

import br.com.job.control.MenuControl;
import br.com.job.model.Schedule;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

public class CalendarPane extends FlowPane {
	
	
	MenuControl controller;

	public CalendarPane(MenuControl controller) {
		Schedule schedule = new Schedule(null);
		this.controller = controller;
		setStyle("-fx-background-color: #FFFFFF");
		getChildren().add(new CalendarBuilder(schedule));
		
	}
	
}
