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

    public static List<Meal> mealList = new ArrayList<>(); //temp

    public Meal(String name, int calories, int proteins, int fats, int carbs)
    {
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
    }

    public String getName()
    {
        return name;
    }

    public int getCalories()
    {
        return calories;
    }

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
