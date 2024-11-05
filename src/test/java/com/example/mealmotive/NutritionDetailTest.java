package com.example.mealmotive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NutritionDetailTest {

    @Test
    void NutritionTest(){
        List<Meal> mealList = new ArrayList<>();

        Meal M = new Meal("Chicken", 25, 50, 75, 100);

        mealList.add(M);

        NutritionDetail ND1 = new NutritionDetail();

        ND1.calculateNutritionReport((ArrayList<Meal>) Meal.mealList);

        /*
        * work
        * in
        * progress
         */
    }
}