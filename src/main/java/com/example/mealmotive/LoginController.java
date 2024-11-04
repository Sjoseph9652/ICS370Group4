package com.example.mealmotive;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
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

        FXMLLoader fxmlLoader = new FXMLLoader(MealMotiveApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 450);
        MealMotiveApplication.getStage().setScene(scene);
    }
}
