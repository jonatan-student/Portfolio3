package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.util.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String url = "jdbc:sqlite:StudentsDB.db"; // Making a string path to the SQL Database
        // Instantializing our classes:
        Model Db =   new Model(url);
        Controller  control =   new Controller(Db);
        View view    =   new View(control);  //,primaryStage);

        // JavaFX setup
        control.setView(view);
        Stage.setTitle("Student Course Administration");
        Stage.setScene(new Scene(view.asParent(), 600, 450));
        Stage.show();
        Stage.setResizable(false);

    }

    public static void main(String[] args) {
        launch(args);
    }
}