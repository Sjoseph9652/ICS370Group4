package com.example.mealmotive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// This unit test gets the text when the calorie count is under our recommended 2300
//  The meals are put in a test arraylist called [mealList].
class MealSuggestionsTestCalCompare {

    @Test
    void calCompare() {

        // Creating a Meal object Turkey
        Meal M = new Meal.MealBuilder()
                .setName("Turkey")
                .setCalories(100)
                .setProteins(200)
                .setFats(300)
                .setCarbs(400)
                .setUsername(LoginController.currentUser)
                .build();

        // Creating a Meal object Tuna
        Meal M1 = new Meal.MealBuilder()
                .setName("Tuna")
                .setCalories(300)
                .setProteins(400)
                .setFats(1100)
                .setCarbs(4030)
                .setUsername(LoginController.currentUser)
                .build();

        // Creating a Meal object Chicken
        Meal M2= new Meal.MealBuilder()
                .setName("Chicken")
                .setCalories(500)
                .setProteins(2400)
                .setFats(3500)
                .setCarbs(4800)
                .setUsername(LoginController.currentUser)
                .build();

        // Creating an arraylist of the three meals Turkey, Chicken, Tuna,
        ArrayList<Meal> mealList = new ArrayList<Meal>();

        DataManager.mealList.add(M);
        DataManager.mealList.add(M1);
        DataManager.mealList.add(M2);

       String S =  MealSuggestions.CalCompare();
       assertEquals(S,"Your calorie count is in a good place for the meals you have logged!");
       System.out.print(S);
    }
}