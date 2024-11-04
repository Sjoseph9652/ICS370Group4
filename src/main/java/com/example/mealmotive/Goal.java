package com.example.mealmotive;

public class Goal // phase 4
{
    private int targetCalories;
    private int targetProtein;
    private int targetFat;
    private int targetCarbs;

    public Goal(int cal, int pro, int fat, int carbs)
    {
        targetCalories = cal;
        targetProtein = pro;
        targetFat = fat;
        targetCarbs = carbs;
    }

    public int getTargetCarbs()
    {
        return targetCarbs;
    }

    public int getTargetFat()
    {
        return targetFat;
    }

    public int getTargetProtein()
    {
        return targetProtein;
    }

    public int getTargetCalories()
    {
        return targetCalories;
    }

    @Override
    public String toString()
    {
        return "\n target calories " + targetCalories + " \n target proteins " + targetProtein + " \n target fats " + targetFat + " \n target carbs " + targetCarbs + "\n";
    }
}
