package com.example.mealmotive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MealTestRatioCheck {

    @Test
    void getFatRatio() {
        // Creating a Meal object
        Meal M = new Meal("Turkey", 100, 200, 300, 400);
        double check = M.getFatRatio();
        assertEquals(check, 3.0/9.0 * 100);
    }

    @Test
    void getCarbRatio() {
        // Creating a Meal object
        Meal M = new Meal("Turkey", 100, 200, 300, 400);
        double check2 = M.getCarbRatio();
        assertEquals(check2, 4.0/9.0 * 100);
    }

    @Test
    void getProteinRatio() {
        // Creating a Meal object
        Meal M = new Meal("Turkey", 100, 200, 300, 400);
        double check3 = M.getProteinRatio();
        assertEquals(check3, 2.0/9.0 * 100);
    }
}