package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class LoginController
{
    private static String path = "meal.json";
    static Gson gson = new Gson();

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    @FXML
    protected void onSubmitButtonClick() throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        System.out.println(username);
        System.out.println(password);

        User.userList = loadUsers();

        for (User i : User.userList)
        {
            if(i.getUsername().equals(username) && i.getPassword().equals(password))
            {
                FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 450);
                MealMotiveApplication.getStage().setScene(scene);

            }
            else
            {
                System.out.println("Account not found");
            }
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
