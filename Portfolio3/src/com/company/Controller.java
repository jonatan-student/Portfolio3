package com.company;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class Controller {
    public View view;
    public ArrayList<Button> InfoButtons = new ArrayList<>();

    public Controller(){}

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
        this.view.DisplayInfo.clear();
        this.view.HomeBtn.setVisible(true);
        this.view.DisplayInfo.setVisible(true);
        this.view.StudentsBtn.setVisible(false);
        this.view.TeachersBtn.setVisible(false);
        this.view.CoursesBtn.setVisible(false);
        this.view.DisplayInfo.appendText("All Courses \n------------");
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

    public void setInfoButtons(ArrayList<String> info) {
        int LineBreak = 0;
        int xpos;
        int ypos;
        for (int i = 0 ; i<= info.size(); i++) {
            if(i == 5*i){nextline+=20;}
            Button infobtn = new Button(info.get(i));
            infobtn.relocate(5+nextline, 55);
            InfoButtons.add(infobtn);

        }
    }
}
