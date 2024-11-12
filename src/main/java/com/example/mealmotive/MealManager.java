package com.example.mealmotive;
import com.google.gson.Gson; //install using maven
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MealManager
{
    @FXML
    public Button backButton;
    @FXML
    Text foodHistoryText;

    /*
    Takes meal data from JSON folder
    Prints meal information to Text in the GUI
     */
    public void showMealHistory()
    {
        DataManager.mealList = DataManager.loadMeals();

        StringBuilder mealHistory = new StringBuilder();

        for (Meal i : DataManager.mealList)
        {
            mealHistory.append(i.toString());
        }
        foodHistoryText.setText(mealHistory.toString());
    }


    public void onBackButtonClick() throws IOException
    {
        System.out.println("Back button clicked");
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }
}