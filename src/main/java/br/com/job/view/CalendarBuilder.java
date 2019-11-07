package br.com.job.view;

import java.awt.Dimension;
import java.time.LocalDate;

import com.sun.javafx.scene.control.skin.DatePickerSkin;

import br.com.job.model.Schedule;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class CalendarBuilder extends BorderPane {
	
	Schedule schedule;
	BorderPane borderPane;

	public CalendarBuilder(Schedule schedule) {
		this.schedule = schedule;
		DatePickerSkin datePickerSkin = new DatePickerSkin(new DatePicker(LocalDate.now()));
		Node popupContent = datePickerSkin.getPopupContent();
		setCenter(popupContent);
		Dimension d = BaseStage.obterResolucaoTela();
		setMinSize( d.getWidth() * 0.75,d.getHeight() * 0.75);
		
	}
	
	
	
	
}
