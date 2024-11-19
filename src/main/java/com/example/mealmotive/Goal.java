package com.example.mealmotive;

public class Goal // phase 4
{
    public int targetCalories;
    public int targetProtein;
    public int targetFat;
    public int targetCarbs;
    public String username;

    public Goal(int cal, int pro, int fat, int carbs, String uname)
    {
        targetCalories = cal;
        targetProtein = pro;
        targetFat = fat;
        targetCarbs = carbs;
        username = uname;
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

    public String getUsername() { return username; }

    @Override
    public String toString()
    {
        return "\n target calories " + targetCalories + " \n target proteins " + targetProtein + " \n target fats " + targetFat + " \n target carbs " + targetCarbs + "\n";
    }
}
