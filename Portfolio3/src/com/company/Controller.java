package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {
    public View view;
    public Controller(){

    }

    public void setView(View view) {
        this.view = view;

        EventHandler<ActionEvent> CoursesBtnClk = e-> coursesSwitch();
        EventHandler<ActionEvent> HomeClicked = e-> HomeSwitch();
        EventHandler<ActionEvent> StudentsClicked = e-> StudentsSwitch();
        EventHandler<ActionEvent> TeachersClicked = e-> TeachersSwitch();

        this.view.CoursesBtn.setOnAction(CoursesBtnClk);
        this.view.HomeBtn.setOnAction(HomeClicked);
        this.view.StudentsBtn.setOnAction(StudentsClicked);
        this.view.TeachersBtn.setOnAction(TeachersClicked);

    }

    public void coursesSwitch(){
        this.view.HomeBtn.setVisible(true);

        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);

    }

    public void HomeSwitch(){
        this.view.HomeBtn.setVisible(false);
        this.view.StudentsBtn.setVisible(true);
        this.view.TeachersBtn.setVisible(true);
        this.view.CoursesBtn.setVisible(true);

    }

    public void StudentsSwitch(){
        this.view.HomeBtn.setVisible(true);
        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);
    }

    public void TeachersSwitch(){
        this.view.HomeBtn.setVisible(true);
        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);
    }
}
