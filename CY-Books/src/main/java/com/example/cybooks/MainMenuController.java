package com.example.cybooks;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

    @FXML

    private Button BookOverviewButton;


    @FXML

    private Button UserOverviewButton;
    private CYBooks cyBooks;
    public MainMenuController() {
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

    @FXML
    private void switchBookScene() {
        cyBooks.switchBookScene();
    }


    @FXML
    private void switchUserScene() {
        cyBooks.switchUserScene();
    }
}
