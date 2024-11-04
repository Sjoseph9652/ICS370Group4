package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javafx.scene.control.TextField;

public class AccountController
{

    public TextField fNameTextField;
    public TextField lNameTextField;
    public TextField uNameTextField;
    public TextField pWordTextField;

    private static String path = "user.json";
    static Gson gson = new Gson();

    @FXML
    protected void onCreateAccountButtonClicked() throws IOException
    {
        String firstName = fNameTextField.getText();
        String lastName = lNameTextField.getText();
        String username = uNameTextField.getText();
        String password = pWordTextField.getText();

        User.userList = loadUsers();

        User placeholder = new User(firstName, lastName, username, password);
        User.userList.add(placeholder);

        try
        {
            FileWriter fw = new FileWriter(path);
            gson.toJson(User.userList, fw);
            fw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> loadUsers()
    {
        try(FileReader fr = new FileReader(path))
        {
            Type listType = new TypeToken<ArrayList<User>>() {}.getType();
            ArrayList<User> list = gson.fromJson(fr, listType);
            return (list != null) ? list : new ArrayList<>(); // returns new array list if the json is empty
        } catch (IOException e)
        {
            return new ArrayList<>();
        }
    }
}
