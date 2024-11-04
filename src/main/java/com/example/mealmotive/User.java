package com.example.mealmotive;

public class User
{
    private String firstName;
    private String lastName;
    public String username;
    private double height;
    private double weight;

    public User(String fname, String lName, String uname, double height, double weight)
    {
        firstName = fname;
        lastName = lName;
        username = uname;
        this.height = height;
        this.weight = weight;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public double getHeight()
    {
        return height;
    }

    public double getWeight()
    {
        return weight;
    }

    public String toString()
    {
        return "\n name " + firstName + " " + lastName + " \n username " + username + " \n height " + height + " \n weight " + weight + "\n";
    }

}
