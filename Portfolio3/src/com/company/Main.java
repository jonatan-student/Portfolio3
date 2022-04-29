package com.company;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import javax.swing.*;


public class Main extends Application {

    //The Whole main method is as made to be as simple as possible
    //JavaFx launches the program and initializes start method elsewhere
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception { //The start method sets our database
        String path = "jdbc:sqlite:SchoolScheduling.db";// the classes are initialized inorder of their dependencies
        Database db = new Database(path);
        Controller control = new Controller(db);
        View view = new View(control);
        control.setView(view);


        stage.setTitle("School DataBase Browser"); //here we set the title and the initialize the popup visuals
        stage.setScene(new Scene(view.asParent(), 750, 500));
        stage.show();
    }
}