package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


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
        EventHandler<ActionEvent> InfoChosen = e-> InfoSwitch();

        this.view.CoursesBtn.setOnAction(CoursesBtnClk);
        this.view.HomeBtn.setOnAction(HomeClicked);
        this.view.StudentsBtn.setOnAction(StudentsClicked);
        this.view.TeachersBtn.setOnAction(TeachersClicked);
        this.view.SelectBtn.setOnAction(InfoChosen);
    }

    private void InfoSwitch() {
        this.view.DisplayInfo.clear();
        switch (CurrentScreen){
            case "Students":
                getStudentInfo();
                break;
            case "Teachers":
                //getTeacherInfo();
                break;
            case "Courses":
                //getCourseInfo();
                break;
        }
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
        CurrentScreen = "Courses";
        this.view.DisplayInfo.clear();
        this.view.HomeBtn.setVisible(true);
        this.view.DisplayInfo.setVisible(true);
        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);
        this.view.Info.setVisible(true);
        this.view.SelectBtn.setVisible(true);
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
        this.view.SelectBtn.setVisible(false);
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
        this.view.SelectBtn.setVisible(true);
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
        this.view.SelectBtn.setVisible(true);
        this.view.Info.setVisible(true);
        setInfo(CurrentScreen);
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

    private void getStudentInfo() {

        String Student = this.view.Info.getValue();
        ArrayList<String> Courses = this.model.getRegCourseIDsWithPeopleID(this.model.getIDUsingName(Student));
        String courses = "";
        for (String s: Courses) {
            courses += "--> " + s + "\n";
        }
        String toDisplay = "Student Name: " + Student + "\n Current Courses: \n" + courses;
        this.view.DisplayInfo.appendText(toDisplay);
    }

    private void getTeacherInfo(){
        String Teacher = this.view.Info.getValue();

        String toDisplay = "Teacher Name: " + Teacher;
        this.view.DisplayInfo.appendText(toDisplay);
    }

    private void getCourseInfo(){
        String Course = this.view.Info.getValue();

        String toDisplay = "Course Name: " + Course;
        this.view.DisplayInfo.appendText(toDisplay);
    }
}
