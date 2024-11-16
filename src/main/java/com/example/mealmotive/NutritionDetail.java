package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class NutritionDetail
{

    //public Button backButton;
    //public Text nutritionText;

    /*
     * Takes the users ArrayList of meals.
     * Gives feedback on amount of carbs, fats, and proteins consumed
     * Based on NIH health
     */

    // User class inside software sequence diagram
    public static String calculateNutritionReport(ArrayList<Meal> meals)
    {
        int totalProteins = 0;
        int totalFats = 0;
        int totalCarbs = 0;

        DataManager.mealList = DataManager.loadMeals();

        for(Meal i : meals)
        {
            totalProteins  += (int) i.getProteins();
            totalFats += (int) i.getFats();
            totalCarbs += (int) i.getCarbs();
        }

        int totalNutrients = totalProteins + totalFats + totalCarbs;
        double proteinRatio = (double)totalProteins / totalNutrients * 100;
        double fatRatio = (double)totalFats / totalNutrients * 100;
        double carbRatio = (double)totalCarbs / totalNutrients * 100;
        StringBuilder textTracker = new StringBuilder();

        if(proteinRatio < 10)
        {
             textTracker.append(Math.floor(proteinRatio) + " % Of your calories was made up of protein. Consider more protein dense foods. \n");
        }
        else if(proteinRatio > 35)
        {

            textTracker.append(Math.floor(proteinRatio) + " % Of your calories was made up of protein. Consider less protein dense foods. \n");
        }

        if(fatRatio < 25)
        {
            textTracker.append(Math.floor(fatRatio) + " % Of your calories was made up of fat. Consider more fat dense foods. \n");
        }
        else if(fatRatio > 35)
        {
            textTracker.append(Math.floor(fatRatio) + " % Of your calories was made up of fat. Consider less fat dense foods. \n");
        }

        if(carbRatio < 45)
        {
            textTracker.append(Math.floor(carbRatio) + " % Of your calories was made up of carbs. Consider more carbs. \n");
        }
        else if(carbRatio > 65)
        {
            textTracker.append(Math.floor(carbRatio) + " % Of your calories was made up of carbs. Consider less carbs. \n");
        }
        return  textTracker.toString();
    }
}