package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class UserDataManager
{
    private static String userFile = "user.json";
    public static ArrayList<User>userList = new ArrayList<>();

    static Gson gson = new Gson();

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
            gson.toJson(userList, fw);
            fw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
