package com.example.mealmotive;

import javafx.scene.chart.PieChart;

public class MealSuggestions {

    public final String name;
    public final int calories;
    public final int proteins;
    public final int fats;
    public final int carbs;
    public String feedback;

    private MealSuggestions(MealSuggestions.SuggestionBuilder builder)
    {
        this.name = builder.name;
        this.calories = builder.calories;
        this.proteins = builder.proteins;
        this.fats = builder.fats;
        this.carbs = builder.carbs;
        this.feedback = builder.feedback;
    }

    /*public static ArrayList<MealSuggestions>LoadSuggestions()
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
    }*/

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
    /// If not then they get a message saying something positive.

    public static String CalCompare() {
        String HealthMessage = "";
        StringBuilder mealSuggestions = new StringBuilder();
        DataManager.goalList = DataManager.loadGoals();

        Goal g = null;
        for (Goal i : DataManager.goalList)
        {
            if (i.getUsername().equals(LoginController.currentUser))
            {
                g = i;
            }
        }
        if(g == null)
        {
            g = new Goal(2300, LoginController.currentUser);
        }

        if (NutritionDetail.CalorieCount(DataManager.mealList) > g.getTargetCalories()) {
            HealthMessage = "Keeping calories down could help reduce weight loss. Consider trying some of our healthy suggestions";

            DataManager.MealSuggestionList = DataManager.loadSuggestedMeals();

            for (MealSuggestions i : DataManager.MealSuggestionList) {
                mealSuggestions.append(i.toString());
                System.out.println(mealSuggestions.toString());
                System.out.println("test");
            }

            mealSuggestions.append("\n");

            String mealSuggestionText = mealSuggestions.toString();

            HealthMessage = HealthMessage + "\n" + mealSuggestionText;
            System.out.println(HealthMessage);
        }
        else
        {
            HealthMessage = "Your calorie count is in a good place for the meals you have logged!";

        }
        return HealthMessage;

    }

    public String toString()
    {
        return "\n" + name + " \n calories " + calories + " \n proteins " + proteins + " \n fats " + fats + " \n carbs " + carbs + "\n" + feedback;
    }
}

