package com.example.mealmotive;

import java.util.ArrayList;
import java.util.List;

public class Meal
{
    public String name;
    public int calories;
    public int proteins;
    public int fats;
    public int carbs;

    // NEW!
    public int totalNutrients;
    public double proteinRatio;
    public double fatRatio;
    public double carbRatio;

    // get methods
    public double getFatRatio() {
        return fatRatio;
    }

    public double getCarbRatio(){
        return carbRatio;
    }

    public double getProteinRatio(){
    return proteinRatio;
}







    public static List<Meal> mealList = new ArrayList<>();

    public Meal(String name, int calories, int proteins, int fats, int carbs)
    {
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;

        // Taken from NutritionDetail Class[NEW!]
        totalNutrients = this.proteins + this.fats + this.carbs;
        proteinRatio = (double)this.proteins / this.totalNutrients * 100;
        fatRatio = (double)this.fats / this.totalNutrients * 100;
        carbRatio = (double)this.carbs / this.totalNutrients * 100;
    }

    public String getName()
    {
        return name;
    }

    public int getCalories() {return calories;}

    public int getProteins()
    {
        return proteins;
    }

    public int getFats()
    {
        return fats;
    }

    public int getCarbs()
    {
        return carbs;
    }

    public String toString()
    {
        return "\n name " + name + " \n calories " + calories + " \n proteins " + proteins + " \n fats " + fats + " \n carbs " + carbs + "\n";
    }
}
