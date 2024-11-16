package com.example.mealmotive;

import java.util.ArrayList;
import java.util.List;

public class User
{
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public double height;
    public double weight;
    public Goal goal;

    public User(String fname, String lName, String uname, String pword)
    {
        firstName = fname;
        lastName = lName;
        username = uname;
        password = pword;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getUsername(){return username;}

    public String getPassword(){return password;}

    public double getHeight()
    {
        return height;
    }

    public double getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
