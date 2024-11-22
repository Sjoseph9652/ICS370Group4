package com.example.mealmotive;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class NutritionController
{
    @FXML
    private Text nutritionText;

    @FXML
    private Button backButton;

    @FXML
    private Text mealSuggestionText;

    public void getNutritionDetail()
    {
        DataManager.mealList = DataManager.loadMeals();
        String textTracker = NutritionDetail.calculateNutritionReport(DataManager.mealList);
        nutritionText.setText(textTracker);
    }

    public void suggestAMeal()
    {

        mealSuggestionText.setText("Here is a meal suggestion");
    }

    public void onBackButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }
}
