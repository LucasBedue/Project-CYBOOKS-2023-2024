package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CheckUserController {

    @FXML
    private TextField LastNameField;
    @FXML
    private TextField FirstNameField;

    private CYBooks cyBooks;
    public CheckUserController() {
    }

    /**
     * To initialize the values to be shown
     */
    @FXML
    private void initialize(){
    }
    public void setCYBooks(CYBooks cyBooks) {
        this.cyBooks = cyBooks;
    }

    /**
     * TEST FUNCTION
     */
    @FXML
    public void print(){
        System.out.println(LastNameField.getText() + " " + FirstNameField.getText());
    }
}

