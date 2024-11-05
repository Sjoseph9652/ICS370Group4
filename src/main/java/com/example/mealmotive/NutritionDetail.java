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

    public Button backButton;
    public Text nutritionText;
    static Gson gson = new Gson();
    private static String path = "meal.json";

    /*
     * Takes the users ArrayList of meals.
     * Gives feedback on amount of carbs, fats, and proteins consumed
     * Based on NIH health
     */
    public void calculateNutritionReport(ArrayList<Meal> meals)
    {
        int totalProteins = 0;
        int totalFats = 0;
        int totalCarbs = 0;

        Meal.mealList = loadMeals();

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
        String textTracker = "";

        if(proteinRatio < 10)
        {
            textTracker = nutritionText.getText();
            nutritionText.setText(textTracker + Math.floor(proteinRatio) + " % Of your calories was made up of protein. Consider more protein dense foods. \n");
        }
        else if(proteinRatio > 35)
        {
            textTracker = nutritionText.getText();
            nutritionText.setText(textTracker + Math.floor(proteinRatio) + " % Of your calories was made up of protein. Consider less protein dense foods. \n");
        }

        if(fatRatio < 25)
        {
            textTracker = nutritionText.getText();
            nutritionText.setText(textTracker + Math.floor(fatRatio) + " % Of your calories was made up of fat. Consider more fat dense foods. \n");
        }
        else if(fatRatio > 35)
        {
            textTracker = nutritionText.getText();
            nutritionText.setText(textTracker + Math.floor(fatRatio) + " % Of your calories was made up of fat. Consider less fat dense foods. \n");
        }

        if(carbRatio < 45)
        {
            textTracker = nutritionText.getText();
            nutritionText.setText(textTracker + Math.floor(carbRatio) + " % Of your calories was made up of carbs. Consider more carbs. \n");
        }
        else if(carbRatio > 65)
        {
            textTracker = nutritionText.getText();
            nutritionText.setText(textTracker + Math.floor(carbRatio) + " % Of your calories was made up of carbs. Consider less carbs. \n");
        }
    }

    public static ArrayList<Meal> loadMeals()
    {
        try(FileReader fr = new FileReader(path))
        {
            Type listType = new TypeToken<ArrayList<Meal>>() {}.getType();
            ArrayList<Meal> list = gson.fromJson(fr, listType);
            if(list != null)
            {
                return list;
            } else
            {
                return new ArrayList<>();
            }
        } catch (IOException e)
        {
            return new ArrayList<>();
        }
    }

    public void onBackButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }
}