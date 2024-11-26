package com.example.mealmotive;

public class Goal // phase 4
{
    public int targetCalories;
    public String username;

    public Goal(int cal, String uname)
    {
        targetCalories = cal;
        username = uname;
    }

    public int getTargetCalories()
    {
        return targetCalories;
    }

    public String getUsername() { return username; }

    @Override
    public String toString()
    {
        return "\n target calories " + targetCalories;
    }
}
