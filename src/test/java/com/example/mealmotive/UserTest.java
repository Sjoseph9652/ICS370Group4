package com.example.mealmotive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
This Checks that the user entries are correct
 */
class UserTest {
    @Test
    void UserTest(){

        // Creating a user object
        User U = new User("Jim","Anderson","JA", "abc123");

        // String varible called S that contains the results from the getFirstanme method.
        String S = U.getFirstName();
        assertEquals(S,"Jim");

        String S2 = U.getLastName();
        assertEquals(S2,"Anderson");

        String S3 = U.getUsername();
        assertEquals(S3,"JA");

        String S4 = U.getPassword();
        assertEquals(S4,"abc123");


    }
}