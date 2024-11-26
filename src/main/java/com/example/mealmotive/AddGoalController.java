package com.example.mealmotive;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddGoalController
{
    public TextField targetCalorieTextField;
    public Button addButton;

    @FXML
    protected void onAddButtonClicked() throws IOException
    {
        int calorie = Integer.parseInt(targetCalorieTextField.getText());

        DataManager.goalList = DataManager.loadGoals();

        Goal placeholder = new Goal(calorie, LoginController.currentUser);

        DataManager.saveGoal(placeholder);

        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
        System.out.println(placeholder.toString());
    }

    public void onBackButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }
}
