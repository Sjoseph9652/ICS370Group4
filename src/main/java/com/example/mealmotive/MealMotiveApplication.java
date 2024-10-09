package com.example.mealmotive;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MealMotiveApplication extends Application
{
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException
    {
        this.stage = stage;
        FXMLLoader mainLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(mainLoader.load(), 800, 450);
        stage.setTitle("MealMotive");
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getStage()
    {
        return stage;
    }

    public static void main(String[] args)
    {
        launch();
    }
}