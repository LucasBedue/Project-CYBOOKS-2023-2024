package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
import com.example.cybooks.Request;
import com.example.cybooks.Search;
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
        Search search = new Search.Builder()

                .build();

        if(!AuthorField.getText().equals("")){
            search.changeAuthor(AuthorField.getText());

        }
        if(!GenreField.getText().equals("")){
            search.changeGenre(GenreField.getText());

        }
        if(!ISBNField.getText().equals("")){
            search.changeIsbn(ISBNField.getText());

        }
        if(!TitleField.getText().equals("")){
            search.changeTitle(TitleField.getText());

        }
        if(!EditionField.getText().equals("")){
            search.changePublisher(EditionField.getText());

        }



        cyBooks.switchBookSearch2Scene(search);
    }
}

