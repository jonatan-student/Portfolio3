package com.company;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class View {
    private Controller controller;
    public Pane view;

    Button HomeBtn = new Button("HomePage");
    Button CoursesBtn = new Button("Courses");
    Button TeachersBtn = new Button("Teachers");
    Button StudentsBtn = new Button("Students");




    public View(Controller control){
        this.controller = control;
        HomeBtn.setVisible(false);

        Create();
    }

    public void Create(){
        this.view = new Pane();
        this.view.setMinSize(750,500);

        CoursesBtn.relocate(375,250);
        TeachersBtn.relocate(275, 250);
        StudentsBtn.relocate(475, 250);

        HomeBtn.relocate(100,100);


        this.view.getChildren().add(CoursesBtn);
        this.view.getChildren().add(TeachersBtn);
        this.view.getChildren().add(StudentsBtn);


        this.view.getChildren().add(HomeBtn);

    }


    public Parent asParent(){
        return this.view;
    }
}
