package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
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
    private void switchBookViewScene() {
        cyBooks.switchBookViewScene();
    }
    @FXML
    private void switchBookSearchScene() {
        cyBooks.switchBookSearchScene();
    }
    @FXML
    private void switchMostBorrowedBooksScene() {
        cyBooks.switchMostBorrowedBooksScene();
    }
    @FXML
    private void switchLateReturnsBooksScene() {
        cyBooks.switchLateReturnsBooksScene();
    }
    @FXML
    private void switchUserViewScene() {
        cyBooks.switchUserViewScene();
    }
    @FXML
    private void switchUserSearchScene() {
        cyBooks.switchUserSearchScene();
    }
    @FXML
    private void switchCheckUserScene() {
        cyBooks.switchCheckUserScene();
    }
    @FXML
    private void switchSearchToModifyScene() {
        cyBooks.switchSearchToModifyScene();
    }
    @FXML
    private void switchRegisterUserScene() {
        cyBooks.switchRegisterUserScene();
    }
}
