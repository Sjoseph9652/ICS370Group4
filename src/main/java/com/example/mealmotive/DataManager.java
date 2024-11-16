package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataManager
{
    private static String mealFile = "meals.json";
    public static ArrayList<Meal> mealList = new ArrayList<>();

    private static String userFile = "user.json";
    public static ArrayList<User>userList = new ArrayList<>();

    static Gson gson = new Gson();

    public static ArrayList<Meal> loadMeals()
    {
        try(FileReader fr = new FileReader(mealFile))
        {
            Type listType = new TypeToken<ArrayList<Meal>>() {}.getType();
            ArrayList<Meal> list = gson.fromJson(fr, listType);
            if(list != null)
            {
                return list;
            } else
            {
                return new ArrayList<>();
            }
        } catch (IOException e)
        {
            return new ArrayList<>();
        }
    }

    public static void saveMeal(Meal meal)
    {
        try
        {
            FileWriter fw = new FileWriter(mealFile);
            mealList.add(meal); // meal added to array list
            gson.toJson(mealList, fw);
            fw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> loadUsers()
    {
        try(FileReader fr = new FileReader(userFile))
        {
            Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            ArrayList<User> list = gson.fromJson(fr, listType);
            if(list != null)
            {
                return list;
            } else
            {
                return new ArrayList<>();
            }
        } catch (IOException e)
        {
            return new ArrayList<>();
        }
    }

    public static void saveUser(User user)
    {
        try
        {
            FileWriter fw = new FileWriter(userFile);
            userList.add(user);
            gson.toJson(DataManager.userList, fw);
            fw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
