package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.*;
import java.util.ArrayList;

///the Controller class handles everything what and when and how everything is presented
///the class also handles our database and all the logic related to displaying given information at certain times

public class Controller {
    public Database model;
    public View view;
    public String CurrentScreen;

    public Controller(Database db){ //the constructor conects our database to our controller
        this.model = db;
    }


    public void setView(View view) { //setView handles all the logic
        this.view = view;
        CurrentScreen = "Main";

        //eventhandlers are initialized and set to functions below
        EventHandler<ActionEvent> CoursesBtnClk = e-> coursesSwitch();
        EventHandler<ActionEvent> HomeClicked = e-> HomeSwitch();
        EventHandler<ActionEvent> StudentsClicked = e-> StudentsSwitch();
        EventHandler<ActionEvent> TeachersClicked = e-> TeachersSwitch();
        EventHandler<ActionEvent> InfoChosen = e-> InfoSwitch();

        //connecting buttons to the specific actions we want taken when button is pressed
        this.view.CoursesBtn.setOnAction(CoursesBtnClk);
        this.view.HomeBtn.setOnAction(HomeClicked);
        this.view.StudentsBtn.setOnAction(StudentsClicked);
        this.view.TeachersBtn.setOnAction(TeachersClicked);
        this.view.SelectBtn.setOnAction(InfoChosen);
    }

    //method to call method based on current screen to show specific information
    private void InfoSwitch() {
        this.view.DisplayInfo.clear();
        switch (CurrentScreen){
            case "Students":
                getStudentInfo();
                break;
            case "Teachers":
                getTeacherInfo();
                break;
            case "Courses":
                getCourseInfo();
                break;
        }
    }



    //this function sets information into the dropdown menu(comboBox) when called depending on screen
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

    //initializes logic for courses screen
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

    //initializes logic for main screen
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

    //initializes logic for students screen
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

    //initializes logic for Teachers screen
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

    //method to return all students used for setInfo
    public void getStudents(){
        for (String s:this.model.getNamesWithOccupation("Student")) {
            this.view.Info.getItems().add(s);
        }
    }
    //method to return all Teachers used for setInfo
    public void getTeachers(){
        for (String s: this.model.getNamesWithOccupation("Professor")){
            this.view.Info.getItems().add(s);
        }
    }
    //method to return all courses used for setInfo
    public void getCourses(){
        for (String s: this.model.getCourseName()){
            this.view.Info.getItems().add(s);
        }
    }

    //the following methods format information retrieved by the database class for a specific student
    //they also handle checking overbookings
    private void getStudentInfo() {
        String Student = this.view.Info.getValue();
        ArrayList<String> Courses = this.model.getRegCourseIDsWithPeopleID(this.model.getIDUsingName(Student));
        ArrayList<String> Schedule = new ArrayList<>();
        String courses = "";
        String Warning = "";
        for (String s: Courses) {
            courses += "--> " + this.model.getAllCourseStuffWithID(s).get(0) + "---" + time(this.model.getAllCourseStuffWithID(s).get(1));
            courses += "\nRoom #" + this.model.getAllCourseStuffWithID(s).get(2) + "\n";
            if(Schedule.contains(this.model.getAllCourseStuffWithID(s).get(1))){
                Warning = "\n\n\n---<OVERBOOKING DETECTED>----\n\n";
            }
            Schedule.add(this.model.getAllCourseStuffWithID(s).get(1));
        }
        String toDisplay = "Student Name: " + Student + "\nCurrent Courses: \n" + courses + Warning;
        this.view.DisplayInfo.appendText(toDisplay);
    }

    private void getTeacherInfo() {
        String Teacher = this.view.Info.getValue();
        ArrayList<String> Courses = this.model.getRegCourseIDsWithPeopleID(this.model.getIDUsingName(Teacher));
        ArrayList<String> Schedule = new ArrayList<>();
        String courses = "";
        String Warning = "";
        for (String s: Courses) {
            courses += "--> " + this.model.getAllCourseStuffWithID(s).get(0) + "---" + time(this.model.getAllCourseStuffWithID(s).get(1));
            courses += "\nRoom #" + this.model.getAllCourseStuffWithID(s).get(2) + "\n";
            if(Schedule.contains(this.model.getAllCourseStuffWithID(s).get(1))){
                Warning = "\n\n\n---<OVERBOOKING DETECTED>----\n\n";
            }
            Schedule.add(this.model.getAllCourseStuffWithID(s).get(1));
        }
        String toDisplay = "Teacher Name: " + Teacher + "\nIs Teaching Course(s): \n" + courses + Warning;
        this.view.DisplayInfo.appendText(toDisplay);
    }


    private void getCourseInfo(){
        String Course = this.view.Info.getValue();
        String students = "";
        String teachers = "";
        String Warning = "\n";
        String Studentcount =""; int studentcount = 0;
        ArrayList<String> People = this.model.getRegPeopleIDsWithCourseID(this.model.getCourseIDWithName(Course).get(0));
        String info = this.model.getAllCourseStuffWithID(model.getCourseIDWithName(Course).get(0)).get(4);
        for (String s: People) {
            if(this.model.getOccupationWithID(s).contains("Professor")){
                teachers += this.model.getNameWithID(s)+ "\n";
            } else if (this.model.getOccupationWithID(s).contains("Student")){
                students += this.model.getNameWithID(s) +"\n";
                studentcount++;
            }
        }
        Studentcount += studentcount;
       if (this.model.getAllCourseStuffWithID(this.model.getCourseIDWithName(Course).get(0)).get(4).contains(Studentcount)){
           Warning = "\n\n\n---<OVER STUDENT CAPACITY>----\n\n";
       }

        String toDisplay = "Course Name: " + Course + "\n"+ time(this.model.getAllCourseStuffWithID(this.model.getCourseIDWithName(Course).get(0)).get(1)) + "\nAssigned Teacher(s):"+ teachers +"\nEnrolled Students:\n----------\n" + students + "\nLocated in Room #"+ this.model.getAllCourseStuffWithID(this.model.getCourseIDWithName(Course).get(0)).get(2) + Warning+ "\n" + info;
        this.view.DisplayInfo.appendText(toDisplay);
    }

    //simple function to set a block to be represented by a much nicer string
    public String time(String Block){
        String tid = "";
        if(Block.contains("A"))return  "Monday 8-12 and Tuesday 12-16";
        if(Block.contains("B"))return  "Monday 12-16 and Friday 12-16";
        if(Block.contains("C"))return  "Tuesday 8-12 and Thursday 8-12";
        if(Block.contains("D"))return "Wednesday 8-12 and Friday 8-12";
        if(Block.contains("E"))return "Wednesday 12-16 and Thursday 12-16";
        else return null;
    }
}
