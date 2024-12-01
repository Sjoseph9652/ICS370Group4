package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GoalDataManager
{
    private static String goalFile = "goals.json";
    public static ArrayList<Goal>goalList = new ArrayList<>();

    static Gson gson = new Gson();

    public static ArrayList<Goal>loadGoals()
    {
        try(FileReader fr = new FileReader(goalFile))
        {
            Type listType = new TypeToken<ArrayList<Goal>>() {}.getType();
            ArrayList<Goal> list = gson.fromJson(fr, listType);
            ArrayList<Goal> userGoals = new ArrayList<>();

            if(list == null)
            {
                return new ArrayList<>();
            }

            for(Goal i : list)
            {
                if(i.getUsername() != null && i.getUsername().equals(LoginController.currentUser))
                {
                    userGoals.add(i);
                    if (userGoals.size() > 1)
                    {
                        userGoals.remove(0);
                    }
                }
            }
            return userGoals;

        } catch (IOException e)
        {
            return new ArrayList<>();
        }
    }

    public static void saveGoal(Goal goal)
    {
        try
        {
            FileWriter fw = new FileWriter(goalFile);
            goalList.add(goal);
            gson.toJson(goalList, fw);
            fw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
