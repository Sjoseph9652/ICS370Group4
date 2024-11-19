package com.example.mealmotive;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddGoalController
{
    public TextField targetProteinTextFiled;
    public TextField targetCalorieTextField;
    public TextField targetFatTextField;
    public TextField targetCarbsTextField;
    public Button addButton;

    protected void onGoalButtonClicked() throws IOException
    {
        int calorie = Integer.parseInt(targetCalorieTextField.getText());
        int protein = Integer.parseInt(targetProteinTextFiled.getText());
        int fats = Integer.parseInt(targetFatTextField.getText());
        int carbs = Integer.parseInt(targetCarbsTextField.getText());

        DataManager.goalList = DataManager.loadGoals();

        Goal placeholder = new Goal(calorie, protein, fats, carbs, LoginController.currentUser);

        DataManager.saveGoal(placeholder);

        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }

    public void onBackButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }

}
