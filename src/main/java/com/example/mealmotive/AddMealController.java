package com.example.mealmotive;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileWriter;
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
    Gson gson = new Gson();

    /*
    Takes user information based on meal
    adds inputted meal to the meal ArrayList
    */
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

        try
        {
            String myJson = gson.toJson(placeholder);
            FileWriter fw = new FileWriter("meal.json");
            gson.toJson(myJson, fw);
            fw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

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
