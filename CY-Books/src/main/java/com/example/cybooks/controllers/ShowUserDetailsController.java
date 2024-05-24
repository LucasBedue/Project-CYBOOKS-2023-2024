package com.example.cybooks.controllers;

import com.example.cybooks.Book;
import com.example.cybooks.Borrow;
import com.example.cybooks.CYBooks;
import com.example.cybooks.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.List;

public class ShowUserDetailsController {

    /**
     * The list of books
     */
    @FXML
    private TableView<Borrow> BookList;

    private ObservableList<Borrow> BookData = FXCollections.observableArrayList();
    /**
     * Values to be shown in the table containing the list of books
     */

    @FXML
    private TableColumn<Borrow, String> ISBNColumn;
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
    public User user;
    private UserSearchController SearchController;
    public ShowUserDetailsController() {
    }

    /**
     * To call the main instance of CYBooks
     * @param cyBooks the main instance of CYBooks
     */
    public void setCYBooks(CYBooks cyBooks) {
        this.cyBooks = cyBooks;
    }

    /**
     * To set the user whose data will be shown and get their currently borrowed books
     * @param user the user whose data will be shown
     */
    public void setUser(User user){
        this.user = user;
        showUser(user);
        List<Borrow> BorrowList = user.getCurrentBorrows();

        for (Borrow borrow: BorrowList) {
            BookData.add(borrow);
        }

        BookList.setItems(BookData);
    }

    /**
     * To initialize the values to be shown
     */
    @FXML
    private void initialize(){
        ISBNColumn.setCellValueFactory(cellData -> cellData.getValue().getBook().ISBNProperty());
        TitleColumn.setCellValueFactory(cellData -> cellData.getValue().getBook().TitleProperty());
        AuthorColumn.setCellValueFactory(cellData -> cellData.getValue().getBook().AuthorProperty().asString());
        PublishingDateColumn.setCellValueFactory(cellData -> cellData.getValue().getBook().PublishingProperty());
        ReturnByColumn.setCellValueFactory(cellData -> cellData.getValue().ReturnByProperty());
    }



    /**
     * To show more information for a given user
     * @param user the user
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
