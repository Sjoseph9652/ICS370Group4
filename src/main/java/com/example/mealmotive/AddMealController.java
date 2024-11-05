package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
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

    private static String path = "meal.json";
    static Gson gson = new Gson();

    /*
    Takes user information based on meal
    ArrayList takes current meals from JSON if there is any
    adds inputted meal to the meal ArrayList
    Array list is written to JSON file
    */
    @FXML
    protected void onAddButtonClicked() throws IOException
    {
        String name = nameTextField.getText();
        int calorie = Integer.parseInt(calorieTextField.getText());
        int protein = Integer.parseInt(proteinTextFiled.getText());
        int fats = Integer.parseInt(fatTextField.getText());
        int carbs = Integer.parseInt(carbsTextField.getText());

        Meal.mealList = loadMeals(); // mealList takes data from the JSON file

        Meal placeholder = new Meal(name, calorie, protein, fats, carbs);
        Meal.mealList.add(placeholder); // meal added to array list

        try // load meal
        {
            FileWriter fw = new FileWriter(path);
            gson.toJson(Meal.mealList, fw);
            fw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }

    //
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

    //https://www.baeldung.com/gson-list
}
