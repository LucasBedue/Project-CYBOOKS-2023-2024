package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.Date;

public class BookSearchController {

    @FXML
    private TextField TitleField;
    @FXML
    private TextField AuthorField;
    @FXML
    private TextField ISBNField;
    @FXML
    private DatePicker PublishingDatePicker;
    @FXML
    private TextField EditionField;
    @FXML
    private TextField GenreField;
    @FXML

    private CYBooks cyBooks;
    public BookSearchController() {
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
        System.out.println(TitleField.getText() + " " + AuthorField.getText() + " " + ISBNField.getText() + " " +  PublishingDatePicker.getValue() + " " +  EditionField.getText() + " " +  GenreField.getText() );
    }
}

