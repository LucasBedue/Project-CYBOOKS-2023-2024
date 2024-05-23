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
    /**
     * To call the main instance of CYBooks
     * @param cyBooks the main instance of CYBooks
     */
    public void setCYBooks(CYBooks cyBooks) {
        this.cyBooks = cyBooks;
    }

    /**
     * TEST FUNCTION
     */
    @FXML
    public void searchBook(){
        cyBooks.switchBookSearch2Scene();
    }
}

