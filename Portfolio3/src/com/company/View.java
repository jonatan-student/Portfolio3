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
    public Stage stage;


    Button HomeBtn = new Button("HomePage");
    Button CoursesBtn = new Button("Courses");
    Button TeachersBtn = new Button("Teachers");
    Button StudentsBtn = new Button("Students");


    public View(Controller control){
        this.controller = control;
        Create();
    }

    public void setStage(Stage stage){
        this.stage = stage;
    }

    private void Create(){
        this.view = new Pane();
        this.view.setMinSize(750,500);
        this.view.getChildren().add(mainScene());
        this.view.getChildren().add(CourseScreen());
    }

    private Group mainScene(){
        Group root = new Group();
        CoursesBtn.relocate(this.view.getMinWidth()/2-100, this.view.getMinHeight()/2);
        TeachersBtn.relocate(this.view.getMinWidth()/2, this.view.getMinHeight()/2);
        StudentsBtn.relocate(this.view.getMinWidth()/2+100, this.view.getMinHeight()/2);
        root.getChildren().add(CoursesBtn);
        root.getChildren().add(TeachersBtn);
        root.getChildren().add(StudentsBtn);
        return root;
    }

    private Group CourseScreen(){
        Group root = new Group();
        HomeBtn.relocate(this.view.getMinWidth()/10, this.view.getMinHeight()/10);
        root.getChildren().add(HomeBtn);
        return root;
    }

    public Parent asParent(){
        return this.view;
    }
}
