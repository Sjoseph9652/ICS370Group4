package com.example.mealmotive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTest {
        @Test
        void mealTest() {

            // Creating a Meal object
            Meal M = new Meal("Turkey", 100, 200, 300, 400);

            // String variable called S that contains the results from the getName method.
            String S = M.getName();
            assertEquals(S,"Turkey" );

            int S1 = M.getCalories();
            assertEquals(S1,100 );

            int S2 = M.getProteins();
            assertEquals(S2,200 );

            int S3 = M.getFats();
            assertEquals(S3,300);

            int S4 = M.getCarbs();
            assertEquals(S4,400);


        }
    }