package com.example.mealmotive;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.ArrayList;

public class MenuController{

    public MealMotiveApplication main = new MealMotiveApplication();

    public void onLoginButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("login-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }

    public void onMealHistoryButtonCLick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("meal-history.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);

        // instance of meal history controller to call relevant method
        MealHistoryController controller = fxmlLoader.getController();
        controller.showMealHistory();
    }

    public void onAddMealButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("add-meal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }

    public void onNutritionDetailButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("nutrition-detail.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);

        NutritionDetail controller = fxmlLoader.getController();
        controller.calculateNutritionReport((ArrayList<Meal>) Meal.mealList);

    }

    //To add: Login. Delete Meal.
}