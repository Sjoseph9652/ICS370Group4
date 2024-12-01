package com.example.mealmotive;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.fxml.FXML;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AccountController
{
    public TextField fNameTextField;
    public TextField lNameTextField;
    public TextField uNameTextField;
    public PasswordField pWordField;


    @FXML
    protected void onCreateAccountButtonClicked() throws IOException
    {
        String firstName = fNameTextField.getText();
        String lastName = lNameTextField.getText();
        String username = uNameTextField.getText();
        String password = pWordField.getText();

        UserDataManager.userList = UserDataManager.loadUsers();

        User placeholder = new User(firstName, lastName, username, password);

        UserDataManager.saveUser(placeholder);

        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("account-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }
}
