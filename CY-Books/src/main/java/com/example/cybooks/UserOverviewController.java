package com.example.cybooks;

import javafx.fxml.FXML;

public class UserOverviewController {

    private CYBooks cyBooks;
    public UserOverviewController() {
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