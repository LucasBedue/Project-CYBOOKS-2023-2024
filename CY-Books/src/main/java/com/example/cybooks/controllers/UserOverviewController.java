package com.example.cybooks.controllers;

import com.example.cybooks.User;
import com.example.cybooks.CYBooks;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class UserOverviewController {


    /**
     * The list of users
     */
    @FXML
    private TableView<User> UserList;

    /**
     * Values to be shown in the table containing the list of books

    */
    @FXML
    private TableColumn<User, Integer> IDColumn;
    @FXML
    private TableColumn<User, String> LastNameColumn;
    @FXML
    private TableColumn<User,String> FirstNameColumn;
    @FXML
    private TableColumn<User,String> MailColumn;
    @FXML
    private TableColumn<User,String> PhoneColumn;
    @FXML
    private TableColumn<User,String> AddressColumn;
    @FXML
    private TableColumn<User,Integer> NumberBorrowedBooksColumn;


    private CYBooks cyBooks;

    public UserOverviewController() {

    }


    /**
     * To initialize the values to be shown
     */
    @FXML
    private void initialize(){
        IDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
        LastNameColumn.setCellValueFactory(cellData -> cellData.getValue().LastNameProperty());
        FirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().FirstNameProperty());
        MailColumn.setCellValueFactory(cellData -> cellData.getValue().MailProperty());
        PhoneColumn.setCellValueFactory(cellData -> cellData.getValue().PhoneProperty());
        AddressColumn.setCellValueFactory(cellData -> cellData.getValue().AddressProperty());
        NumberBorrowedBooksColumn.setCellValueFactory(cellData -> cellData.getValue().nbBorrowedBooksProperty().asObject());

    }

    /**
     * Get the data to be shown
     * @param cyBooks
     */
    public void setCYBooks(CYBooks cyBooks) {
        try {
            this.cyBooks = cyBooks;
            UserList.setItems(cyBooks.getUserData());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
