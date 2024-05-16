package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
import javafx.fxml.FXML;

public class SearchToModifyController {

    private CYBooks cyBooks;
    public SearchToModifyController() {
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
}

