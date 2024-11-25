package com.example.mealmotive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


// This unit test shows the other message if the calories are greater than 2300.
// That message being "Keeping calories down could help reduce weight loss. Consider trying some of our healthy suggestions"
class MealSuggestOver2300Calories {

    @Test
    void calCompare() {

        // Creating a Meal object Turkey
        Meal M = new Meal.MealBuilder()
                .setName("Turkey")
                .setCalories(1000)
                .setProteins(200)
                .setFats(300)
                .setCarbs(400)
                .setUsername(LoginController.currentUser)
                .build();

        // Creating a Meal object Tuna
        Meal M1 = new Meal.MealBuilder()
                .setName("Tuna")
                .setCalories(500)
                .setProteins(400)
                .setFats(1100)
                .setCarbs(4030)
                .setUsername(LoginController.currentUser)
                .build();

        // Creating a Meal object Chicken
        Meal M2= new Meal.MealBuilder()
                .setName("Chicken")
                .setCalories(1000)
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

        // takes the string and splits up based on the new lines in the string
        // For comparing S1[0] it just compares the first line of the string
        String S =  MealSuggestions.CalCompare();
        String S1[] = S.split("\n");
        assertEquals(S1[0],"Keeping calories down could help reduce weight loss. Consider trying some of our healthy suggestions");
        System.out.print(S1[0]);
    }
}

