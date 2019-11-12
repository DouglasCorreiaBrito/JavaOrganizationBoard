package br.com.job.view;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Random;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CalendarFx extends Application {


    @Override
    public void start(Stage primaryStage) {

       DatePicker date_picker=new DatePicker();
       date_picker.setShowWeekNumbers(false);
     
       date_picker.setDayCellFactory(new Callback<DatePicker,DateCell>(){

           @Override
           public DateCell call(DatePicker param) {
           
             return new DateCell(){
             @Override
             public void updateItem(LocalDate item, boolean empty){
             super.updateItem(item, empty);
       
             if (empty || item == null) {
                 setText(null);
                 setGraphic(null);
               
                 } else {
               
                StackPane cell_pane = new StackPane();
               
                Random r=new Random();
               
               
                Circle circle=new Circle(20);
               
                Label label=new Label();
                label.setText(getText());
                label.setTextFill(Color.AQUA);
                label.setLabelFor(circle);
               

                cell_pane.getChildren().addAll(circle,label);

                //item.get(ChronoField.DAY_OF_WEEK) returns an int from 1 to 7(Monday-Sunday)
                //DayOfWeek.of(int) return the name of the day of week. type ENUM.

                DayOfWeek day=DayOfWeek.of(item.get(ChronoField.DAY_OF_WEEK));
               
               
                if(day.equals(DayOfWeek.SATURDAY)){
                    setStyle("-fx-background-color:blue;");//saturday cells blue background
                }else if(day.equals(DayOfWeek.SUNDAY)){
                    setStyle("-fx-background-color:green;");//sunday cells green background
                }else{
                   setStyle("-fx-background-color:grey;"); //weekdays grey
                }
                setGraphic(cell_pane);
                setText("");//dont show any text in the cells
               
                 }

            }
             };
       };
       });

        StackPane root = new StackPane();
        root.getChildren().addAll(date_picker);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Calendar/Weather");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
		launch(args);
	}

}
