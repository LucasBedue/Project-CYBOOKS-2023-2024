package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
import javafx.fxml.FXML;

public class LateReturnsController {

    private CYBooks cyBooks;
    public LateReturnsController() {
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
}

