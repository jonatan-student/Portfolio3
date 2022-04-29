package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Controller {
    public Database model;
    public View view;
    public String CurrentScreen;

    public Controller(Database db){
        this.model = db;
    }

    public void setView(View view) {
        this.view = view;
        CurrentScreen = "Main";

        EventHandler<ActionEvent> CoursesBtnClk = e-> coursesSwitch();
        EventHandler<ActionEvent> HomeClicked = e-> HomeSwitch();
        EventHandler<ActionEvent> StudentsClicked = e-> StudentsSwitch();
        EventHandler<ActionEvent> TeachersClicked = e-> TeachersSwitch();
       // EventHandler<ActionEvent> InfoChosen = e-> InfoSwitch();

        this.view.CoursesBtn.setOnAction(CoursesBtnClk);
        this.view.HomeBtn.setOnAction(HomeClicked);
        this.view.StudentsBtn.setOnAction(StudentsClicked);
        this.view.TeachersBtn.setOnAction(TeachersClicked);
    }


    public void setInfo(String type){
        this.view.Info.getItems().clear();
        switch (type){
            case "Students":
                getStudents();
                break;
            case "Teachers":
                getTeachers();
                break;
            case "Courses":
                getCourses();
                break;
        }
    }

    public void coursesSwitch(){
        CurrentScreen = "courses";
        this.view.DisplayInfo.clear();
        this.view.HomeBtn.setVisible(true);
        this.view.DisplayInfo.setVisible(true);
        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);
        this.view.Info.setVisible(true);
        setInfo(CurrentScreen);
    }

    public void HomeSwitch(){
        CurrentScreen = "Main";
        this.view.DisplayInfo.clear();
        this.view.Info.setVisible(false);
        this.view.HomeBtn.setVisible(false);
        this.view.DisplayInfo.setVisible(false);
        this.view.StudentsBtn.setVisible(true);
        this.view.TeachersBtn.setVisible(true);
        this.view.CoursesBtn.setVisible(true);

    }

    public void StudentsSwitch(){
        CurrentScreen = "Students";
        this.view.DisplayInfo.clear();
        this.view.HomeBtn.setVisible(true);
        this.view.DisplayInfo.setVisible(true);
        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);
        this.view.Info.setVisible(true);
        setInfo(CurrentScreen);
    }

    public void TeachersSwitch(){
        CurrentScreen = "Teachers";
        this.view.DisplayInfo.clear();
        this.view.HomeBtn.setVisible(true);
        this.view.DisplayInfo.setVisible(true);
        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);
        this.view.Info.setVisible(true);
        setInfo(CurrentScreen);
        this.view.DisplayInfo.appendText("All Teachers \n----------");
    }

    public void getStudents(){
        for (String s:this.model.getNamesWithOccupation("Student")) {
            this.view.Info.getItems().add(s);
        }
    }

    public void getTeachers(){
        for (String s: this.model.getNamesWithOccupation("Professor")){
            this.view.Info.getItems().add(s);
        }
    }

    public void getCourses(){
        for (String s: this.model.getCourseName()){
            this.view.Info.getItems().add(s);
        }
    }
}
