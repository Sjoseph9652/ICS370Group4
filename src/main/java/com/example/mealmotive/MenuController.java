package com.example.mealmotive;

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

    public void onAccountButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("create-account.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }

    public void onMealHistoryButtonCLick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("MealManager.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);

        // instance of meal history controller to call relevant method
        MealManager controller = fxmlLoader.getController();
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

        NutritionController controller = fxmlLoader.getController();
        controller.getNutritionDetail();
        controller.suggestAMeal();

    }

    public void onAddGoalButtonClick() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("Make-Goal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }
}