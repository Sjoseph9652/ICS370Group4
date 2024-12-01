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

public class LoginController
{
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    public static String currentUser;

    @FXML
    protected void onSubmitButtonClick() throws IOException {
        String username = usernameTextField.getText().trim(); // whitespace in username
        String password = passwordField.getText().trim();
        System.out.println(username);
        System.out.println(password);

        UserDataManager.userList = UserDataManager.loadUsers();
        //System.out.println(UserDataManager.userList);

        for (User i : UserDataManager.userList)
        {
            if(i.getUsername().equals(username) && i.getPassword().equals(password))
            {
                currentUser = i.getUsername();
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


}