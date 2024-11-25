package com.example.mealmotive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


// This is a unit that makes sure that the total calories are being calculated properly.
//  The test contains three meals that are put into an arraylist and calculates the total of all them
// to make sure they get the correct value of 900.
class CalorieCountTest {

    @Test
    void calorieCount() {

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
        ArrayList<Meal> MealPlans = new ArrayList<Meal>();

        MealPlans.add(M);
        MealPlans.add(M1);
        MealPlans.add(M2);

        int result = NutritionDetail.CalorieCount(MealPlans);
        System.out.println(result);
        assertEquals(result,900);
    }

}