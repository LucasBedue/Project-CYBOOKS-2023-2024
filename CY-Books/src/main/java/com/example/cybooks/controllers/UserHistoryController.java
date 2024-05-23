package com.example.cybooks.controllers;

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

public class UserHistoryController {


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
    private TableColumn<Borrow, Integer> ISBNColumn;
    @FXML
    private TableColumn<Borrow, String> TitleColumn;
    @FXML
    private TableColumn<Borrow,String> AuthorColumn;
    @FXML
    private TableColumn<Borrow, LocalDate> PublishingDateColumn;
    @FXML
    private TableColumn<Borrow, LocalDate> ReturnByColumn;

    /**
     * More detailed information about the chosen book
     */

    @FXML
    private Label TitleLabel;
    @FXML
    private Label AuthorLabel;
    @FXML
    private Label ISBNLabel;
    @FXML
    private Label PublishingLabel;
    @FXML
    private Label EditionLabel;
    @FXML
    private Label GenreLabel;
    private CYBooks cyBooks;
    private User user;

    /**
     * Constructor for the controller
     */
    public UserHistoryController() {
    }

    /**
     * To call the main instance of CYBooks
     * @param cyBooks the main instance of CYBooks
     */
    public void setCYBooks(CYBooks cyBooks) {
        this.cyBooks = cyBooks;
    }

    /**
     * To set the user whose data will be shown and get their borrow history
     * @param user the user whose data will be shown
     */
    public void setUser(User user){
        this.user = user;

        List<Borrow> BorrowList = user.getBorrowHistory();

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
        ISBNColumn.setCellValueFactory(cellData -> cellData.getValue().getBook().ISBNProperty().asObject());
        TitleColumn.setCellValueFactory(cellData -> cellData.getValue().getBook().TitleProperty());
        AuthorColumn.setCellValueFactory(cellData -> cellData.getValue().getBook().AuthorProperty().asString());
        PublishingDateColumn.setCellValueFactory(cellData -> cellData.getValue().getBook().PublishingProperty());
        ReturnByColumn.setCellValueFactory(cellData -> cellData.getValue().ReturnByProperty());


        /**
         * As default no detailed information will be shown as no book would have been chosen yet
         */
        showBookDetails(null);

        /**
         * Update the left side by changing the listener when clicking on a book on the right
         */
        BookList.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> showBookDetails(newValue));

    }

    /**
     * To show more information for a given book
     * @param borrow
     */
    private void showBookDetails(Borrow borrow){
        if( borrow != null ){
            TitleLabel.setText(borrow.getBook().getTitle());
            AuthorLabel.setText(borrow.getBook().getAuthor().toString());
            ISBNLabel.setText(Integer.toString(borrow.getBook().getISBN()));
            PublishingLabel.setText(borrow.getBook().getPublishingDate().toString());
            EditionLabel.setText(borrow.getBook().getEdition());
            GenreLabel.setText(borrow.getBook().getGenre().toString());

        } else {
            TitleLabel.setText("");
            AuthorLabel.setText("");
            ISBNLabel.setText("");
            PublishingLabel.setText("");
            EditionLabel.setText("");
            GenreLabel.setText("");

        }

    }
}
