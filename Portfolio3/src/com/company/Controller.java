package com.company;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Controller {
    public View view;
    public String CurrentScreen;
    public ObservableList<String> info;

    public Controller(){}

    public void setView(View view) {
        this.view = view;
        CurrentScreen = "main";

        EventHandler<ActionEvent> CoursesBtnClk = e-> coursesSwitch();
        EventHandler<ActionEvent> HomeClicked = e-> HomeSwitch();
        EventHandler<ActionEvent> StudentsClicked = e-> StudentsSwitch();
        EventHandler<ActionEvent> TeachersClicked = e-> TeachersSwitch();
        EventHandler<ActionEvent> InfoChosen = e-> InfoSwitch();

        this.view.CoursesBtn.setOnAction(CoursesBtnClk);
        this.view.HomeBtn.setOnAction(HomeClicked);
        this.view.StudentsBtn.setOnAction(StudentsClicked);
        this.view.TeachersBtn.setOnAction(TeachersClicked);
    }

    private void InfoSwitch() {

        if(CurrentScreen.contains("Students")){
            info = getStudents();
        } else if (CurrentScreen.contains("Teachers")){
            info = getTeachers();
        } else if (CurrentScreen.contains("Courses")){
            info = getCourses();
        }
            this.view.Info.getItems().add(info);
    }

    private void setInfo(String type){
        switch (type){
            case "Students":
                info = getStudents();
        }
    }

    public void coursesSwitch(){
        this.view.DisplayInfo.clear();
        this.view.HomeBtn.setVisible(true);
        this.view.DisplayInfo.setVisible(true);
        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);

    }

    public void HomeSwitch(){
        this.view.DisplayInfo.clear();
        this.view.HomeBtn.setVisible(false);
        this.view.DisplayInfo.setVisible(false);
        this.view.StudentsBtn.setVisible(true);
        this.view.TeachersBtn.setVisible(true);
        this.view.CoursesBtn.setVisible(true);

    }

    public void StudentsSwitch(){
        this.view.DisplayInfo.clear();
        this.view.HomeBtn.setVisible(true);
        this.view.DisplayInfo.setVisible(true);
        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);
        this.view.DisplayInfo.appendText("All Students \n------------");
    }

    public void TeachersSwitch(){
        this.view.DisplayInfo.clear();
        this.view.HomeBtn.setVisible(true);
        this.view.DisplayInfo.setVisible(true);
        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);
        this.view.DisplayInfo.appendText("All Teachers \n----------");
    }

    public ObservableList<String> getStudents(){

        return null;
    }

    public ObservableList<String> getTeachers(){
        return null;
    }

    public ObservableList<String> getCourses(){
        return null;
    }
}
