package com.example.mealmotive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NutritionDetailTest {

    @Test
    void NutritionTest(){
        List<Meal> mealList = new ArrayList<>();

        Meal M = new Meal.MealBuilder()
                .setName("Chicken")
                .setCalories(25)
                .setProteins(50)
                .setFats(75)
                .setCarbs(100)
                .setUsername(LoginController.currentUser)
                .build();

        mealList.add(M);

        NutritionDetail ND1 = new NutritionDetail();

        ND1.calculateNutritionReport((ArrayList<Meal>) DataManager.mealList);

        /*
        * work
        * in
        * progress
         */
    }
}