package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.example.mealmotive.AccountController.getUsers;

public class LoginController
{
    private static String path = "user.json";
    static Gson gson = new Gson();

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onSubmitButtonClick() throws IOException {
        String username = usernameTextField.getText().trim(); // whitespace in username
        String password = passwordField.getText().trim();
        System.out.println(username);
        System.out.println(password);

        User.userList = loadUsers();
        System.out.println(User.userList);

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
        return getUsers(path, gson);
    }

}
