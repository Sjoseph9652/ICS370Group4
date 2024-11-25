package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.math.MathContext;

import static com.example.mealmotive.DataManager.gson;


public class MealSuggestions {

    public final String name;
    public final int calories;
    public final int proteins;
    public final int fats;
    public final int carbs;
    public static String feedback;

    private MealSuggestions(MealSuggestions.SuggestionBuilder builder)
    {
        this.name = builder.name;
        this.calories = builder.calories;
        this.proteins = builder.proteins;
        this.fats = builder.fats;
        this.carbs = builder.carbs;
        this.feedback = builder.feedback;
    }

    public static ArrayList<MealSuggestions>LoadSuggestions()
    {
        try(FileReader fr = new FileReader("MealSuggestion.json"))
        {
            Type listType = new TypeToken<ArrayList<MealSuggestions>>() {}.getType();
            ArrayList<MealSuggestions> list = gson.fromJson(fr, listType);
            ArrayList<MealSuggestions> mealsuggestions = new ArrayList<>();

            if(list == null)
            {
                return new ArrayList<>();
            }

            for(MealSuggestions i : list)
            {
                mealsuggestions.add(i);
            }
            return mealsuggestions;

        } catch (IOException e)
        {
            return new ArrayList<>();
        }
    }

    public static class SuggestionBuilder {
        private String name;
        private int calories;
        private int proteins;
        private int fats;
        private int carbs;
        private String username;
        private String feedback;

        public MealSuggestions.SuggestionBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MealSuggestions.SuggestionBuilder setCalories(int calories) {
            this.calories = calories;
            return this;
        }

        public MealSuggestions.SuggestionBuilder setProteins(int proteins) {
            this.proteins = proteins;
            return this;
        }

        public MealSuggestions.SuggestionBuilder setFats(int fats) {
            this.fats = fats;
            return this;
        }

        public MealSuggestions.SuggestionBuilder setCarbs(int carbs) {
            this.carbs = carbs;
            return this;
        }

        public MealSuggestions.SuggestionBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public MealSuggestions build() {
            if (name == null) {
                throw new IllegalArgumentException("name cannot be null");
            }
            if (calories < 0) {
                throw new IllegalArgumentException("calories cannot be negative");
            }
            return new MealSuggestions(this);
        }


    }
    /// Gets the total calories from the NutritionDetail
    /// Compare the total calories from the user and see if they are greater than 2300
    /// If so then they get a meal suggestions
    /// If not then they get a meesage saying something positive.

    public String CalCompare() {
        String HealthMessage = "";

        if (NutritionDetail.CalorieCount(DataManager.mealList) > 2300) {
            HealthMessage = "Keeping calories down could help reduce weight loss. Consider trying some of out healthy suggestions";
        }

        else {
            HealthMessage = "Your calorie count is in a good place for the meals you have logged!";

        }
        return HealthMessage;

    }
}
