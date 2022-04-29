package com.company;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

//used to create a complete view for all needed elements of the stage
public class View {
    private Controller controller;
    public Pane view;

    //all buttons that are needed for the system
    Button HomeBtn = new Button("HomePage");
    Button CoursesBtn = new Button("Courses");
    Button TeachersBtn = new Button("Teachers");
    Button StudentsBtn = new Button("Students");
    Button SelectBtn = new Button("Select");

    //Creating the text area that print our information for students, teachers, and courses
    TextArea DisplayInfo = new TextArea();
    ComboBox<String> Info = new ComboBox<>();


    //Sets elements visible or not from the controller
    public View(Controller control){
        this.controller = control;
        HomeBtn.setVisible(false);
        DisplayInfo.setVisible(false);
        Info.setVisible(false);
        SelectBtn.setVisible(false);
        Create();
    }

    //creates the entire system and all elements made
    public void Create(){
        //makes the initial screen and fonts for buttons
        this.view = new Pane();
        Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 36);
        this.view.setMinSize(750,500);
        this.view.setStyle("-fx-border-color:rgba(0,0,0); -fx-border-width:20px; -fx-background-color:rgba(245,222,179, 0.87);");

        //sets position and fonts for initial buttons
        CoursesBtn.relocate(300,200);
        CoursesBtn.setFont(font);
        TeachersBtn.relocate(300, 50);
        TeachersBtn.setFont(font);
        StudentsBtn.relocate(300, 350);
        StudentsBtn.setFont(font);

        HomeBtn.relocate(22.5,22.5);
        SelectBtn.relocate(400, 22.5);

        Info.relocate(100, 22.5);
        Info.setMaxSize(200,500);
        Info.setStyle("-fx-border-color:rgba(0,0,0); -fx-border-width:1px; -fx-background-color:rgba(245,222,179, 0.87);");

        DisplayInfo.relocate(20,50);
        DisplayInfo.setEditable(false);
        DisplayInfo.setMinSize(710,410);

        //access the "children" of a node
        this.view.getChildren().add(CoursesBtn);
        this.view.getChildren().add(TeachersBtn);
        this.view.getChildren().add(StudentsBtn);
        this.view.getChildren().add(Info);


        this.view.getChildren().add(HomeBtn);
        this.view.getChildren().add(SelectBtn);


        this.view.getChildren().add(DisplayInfo);
    }

    //To cast the pane node as a parent node for the main class to run
    public Parent asParent(){
        return this.view;
    }
}
