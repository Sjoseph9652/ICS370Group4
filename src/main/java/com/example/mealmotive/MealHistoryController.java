package com.example.mealmotive;
import com.google.gson.Gson; //install using maven
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MealHistoryController
{
    @FXML
    public Button backButton;
    @FXML
    Text foodHistoryText;
    Gson gson = new Gson();

    /*
    Takes meal class array list
    Prints meal information to Text in the GUI
     */
    public void showMealHistory()
    {
        try
        {
            FileReader fr = new FileReader("meal.json");
            //Meal addedMeal = gson.fromJson(fr, Meal.class);
            //foodHistoryText.setText(gson.toJson(addedMeal));
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }


        /*StringBuilder mealHistory = new StringBuilder();

        for (Meal i : Meal.mealList)
        {
            mealHistory.append(i.toString()).append("\n");
        }
        foodHistoryText.setText(mealHistory.toString());*/
    }

    public void onBackButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }
}
