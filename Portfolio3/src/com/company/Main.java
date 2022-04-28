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


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Controller control = new Controller();
        View view = new View(control);
        control.setView(view);
        stage.setTitle("School DataBase Browser");
        stage.setScene(new Scene(view.asParent(), 750, 500));
        stage.show();
    }
}