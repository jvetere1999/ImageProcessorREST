package com.jvetere.application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage stage) {
        DropBox drop = new DropBox("Drop File Here");


        StackPane root = new StackPane();
        root.getChildren().add(drop.me);
        Scene scene = new Scene(root, 500, 250);

        stage.setTitle("Drag image");
        stage.setScene(scene);
        stage.show();
    }
    public static void main (String[] args) {
        launch(args);
    }
}
