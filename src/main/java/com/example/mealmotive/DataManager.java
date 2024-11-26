package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataManager
{
    private static String mealFile = "meal.json";
    public static ArrayList<Meal> mealList = new ArrayList<>();

    private static String userFile = "user.json";
    public static ArrayList<User>userList = new ArrayList<>();

    private static String goalFile = "goals.json";
    public static ArrayList<Goal>goalList = new ArrayList<>();

    //private static String mealSuggestionFile = "mealSuggestion.json";
    public static ArrayList<MealSuggestions> MealSuggestionList = new ArrayList<>();

    /// NEW!
    private static String mealSuggestionFile = "MealSuggestion.json";
    //public static ArrayList<MealSuggestions>MealSuggestionList = new ArrayList<>();



    static Gson gson = new Gson();
    //static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    public static ArrayList<Meal> loadMeals()
    {
        try(FileReader fr = new FileReader(mealFile))
        {
            Type listType = new TypeToken<ArrayList<Meal>>() {}.getType();
            ArrayList<Meal> list = gson.fromJson(fr, listType);
            ArrayList<Meal> userMeals = new ArrayList<>();

            if(list == null)
            {
                return new ArrayList<>();
            }

            for(Meal i : list)
            {
                if(i.getUsername() != null && i.getUsername().equals(LoginController.currentUser))
                {
                    userMeals.add(i);
                }
            }
            return userMeals;

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
            gson.toJson(DataManager.goalList, fw);
            fw.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<MealSuggestions> loadSuggestedMeals()
    {
        try(FileReader fr = new FileReader(mealSuggestionFile))
        {
            Type listType = new TypeToken<ArrayList<MealSuggestions>>() {}.getType();
            ArrayList<MealSuggestions> mealSuggestionsLists = gson.fromJson(fr, listType);
            if(mealSuggestionsLists != null)
            {
                return mealSuggestionsLists;
            } else
            {
                return new ArrayList<>();
            }
        } catch (IOException e)
        {
            return new ArrayList<>();
        }
    }



}
