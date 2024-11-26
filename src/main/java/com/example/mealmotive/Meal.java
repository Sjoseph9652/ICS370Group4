package com.example.mealmotive;

public class Meal
{
    public final String name;
    public final int calories;
    public final int proteins;
    public final int fats;
    public final int carbs;
    public final String username;

    private Meal(MealBuilder builder)
    {
        this.name = builder.name;
        this.calories = builder.calories;
        this.proteins = builder.proteins;
        this.fats = builder.fats;
        this.carbs = builder.carbs;
        this.username = builder.username;
    }

    public static class MealBuilder
    {
        private String name;
        private int calories;
        private int proteins;
        private int fats;
        private int carbs;
        private String username;

        public MealBuilder setName(String name)
        {
            this.name = name;
            return this;
        }

        public MealBuilder setCalories(int calories)
        {
            this.calories = calories;
            return this;
        }

        public MealBuilder setProteins(int proteins)
        {
            this.proteins = proteins;
            return this;
        }

        public MealBuilder setFats(int fats)
        {
            this.fats = fats;
            return this;
        }

        public MealBuilder setCarbs(int carbs)
        {
            this.carbs = carbs;
            return this;
        }

        public MealBuilder setUsername(String username)
        {
            this.username = username;
            return this;
        }

        public Meal build()
        {
            return new Meal(this);
        }
    }


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

    //public static List<Meal> mealList = new ArrayList<>();

    /*public Meal(String name, int calories, int proteins, int fats, int carbs, String username)
    {
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbs = carbs;
        this.username = username;

        // Taken from NutritionDetail Class[NEW!]
        totalNutrients = this.proteins + this.fats + this.carbs;
        proteinRatio = (double)this.proteins / this.totalNutrients * 100;
        fatRatio = (double)this.fats / this.totalNutrients * 100;
        carbRatio = (double)this.carbs / this.totalNutrients * 100;
    }*/

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

    public String getUsername()
    {
        return username;
    }

    public String toString()
    {
        return "\n" + name + " \n calories " + calories + " \n proteins " + proteins + " \n fats " + fats + " \n carbs " + carbs + "\n";
    }
    // https://www.youtube.com/watch?v=sZYfZrA-gA0 - builder design
}
