package com.example.mealmotive;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.*;
import java.io.IOException;

//to do: replace empty values with 0,
public class AddMealController
{
    public TextField nameTextField;
    public TextField proteinTextFiled;
    public TextField calorieTextField;
    public TextField fatTextField;
    public TextField carbsTextField;
    public Button addButton;

    @FXML
    protected void onAddButtonClicked() throws IOException
    {
        String name = nameTextField.getText();
        int calorie = Integer.parseInt(calorieTextField.getText());
        int protein = Integer.parseInt(proteinTextFiled.getText());
        int fats = Integer.parseInt(fatTextField.getText());
        int carbs = Integer.parseInt(carbsTextField.getText());

        Meal placeholder = new Meal(name, calorie, protein, fats, carbs);
        Meal.mealList.add(placeholder);
        System.out.println("Added Meal!");
    }
    
    public void onBackButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }
}
