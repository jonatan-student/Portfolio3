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


public class View {
    private Controller controller;
    public Pane view;

    Button HomeBtn = new Button("HomePage");
    Button CoursesBtn = new Button("Courses");
    Button TeachersBtn = new Button("Teachers");
    Button StudentsBtn = new Button("Students");

    TextArea DisplayInfo = new TextArea();
    ComboBox<ObservableList> Info = new ComboBox<>();


    public View(Controller control){
        this.controller = control;
        HomeBtn.setVisible(false);
        DisplayInfo.setVisible(false);
        Info.setVisible(false);
        Create();
    }

    public void Create(){
        this.view = new Pane();
        Font font = Font.font("Comic Sans MS", FontWeight.BOLD, 36);
        this.view.setMinSize(750,500);
        this.view.setStyle("-fx-border-color:rgba(0,0,0); -fx-border-width:20px; -fx-background-color:rgba(245,222,179, 0.87);");

        CoursesBtn.relocate(300,200);
        CoursesBtn.setFont(font);
        TeachersBtn.relocate(300, 50);
        TeachersBtn.setFont(font);
        StudentsBtn.relocate(300, 350);
        StudentsBtn.setFont(font);

        HomeBtn.relocate(22.5,22.5);
        Info.relocate(50, 22.5);
        DisplayInfo.relocate(20,50);
        DisplayInfo.setEditable(false);
        DisplayInfo.setMinSize(710,410);

        this.view.getChildren().add(CoursesBtn);
        this.view.getChildren().add(TeachersBtn);
        this.view.getChildren().add(StudentsBtn);
        this.view.getChildren().add(Info);


        this.view.getChildren().add(HomeBtn);


        this.view.getChildren().add(DisplayInfo);
    }


    public Parent asParent(){
        return this.view;
    }
}
