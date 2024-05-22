package com.example.cybooks.controllers;

import com.example.cybooks.Borrow;
import com.example.cybooks.CYBooks;
import com.example.cybooks.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;

public class ShowUserDetailsController {

    /**
     * The list of books
     */
    @FXML
    private TableView<Borrow> BookList;

    /**
     * Values to be shown in the table containing the list of books
     */

    @FXML
    private TableColumn<Borrow, Integer> ISBNColumn;
    @FXML
    private TableColumn<Borrow, String> TitleColumn;
    @FXML
    private TableColumn<Borrow,String> AuthorColumn;
    @FXML
    private TableColumn<Borrow, LocalDate> PublishingDateColumn;
    @FXML
    private TableColumn<Borrow, LocalDate> ReturnByColumn;

    @FXML
    private Label IDLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label mailLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label DOBLabel;
    private CYBooks cyBooks;
    private User user;
    public ShowUserDetailsController(User user) {
    }

    /**
     * To initialize the values to be shown
     */
    @FXML
    private void initialize(){
        showUser(user);
    }
    public void setCYBooks(CYBooks cyBooks) {
        this.cyBooks = cyBooks;
    }

    public void setUser(User user){
        this.user = user;
    }

    /**
     * To show more information for a given book
     * @param user
     */
    private void showUser(User user){
        if( user != null ){
            IDLabel.setText(Integer.toString(user.getID()));
            firstNameLabel.setText(user.getFirstName().toString());
            lastNameLabel.setText(user.getLastName().toString());
            mailLabel.setText(user.getMail().toString());
            phoneLabel.setText(user.getPhone().toString());
            addressLabel.setText(user.getAddress().toString());
            DOBLabel.setText(user.getDOB().toString());

        } else {
            IDLabel.setText("");
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            mailLabel.setText("");
            phoneLabel.setText("");
            addressLabel.setText("");
            DOBLabel.setText("");

        }

    }
}
