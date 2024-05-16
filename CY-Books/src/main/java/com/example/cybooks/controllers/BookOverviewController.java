package com.example.cybooks.controllers;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.example.cybooks.CYBooks;
import com.example.cybooks.Book;

import java.time.LocalDate;

public class BookOverviewController {

    /**
     * The list of books
     */
    @FXML
    private TableView<Book> BookList;

    /**
     * Values to be shown in the table containing the list of books
     */

    @FXML
    private TableColumn<Book, Integer> ISBNColumn;
    @FXML
    private TableColumn<Book, String> TitleColumn;
    @FXML
    private TableColumn<Book,String> AuthorColumn;
    @FXML
    private TableColumn<Book, LocalDate> PublishingDateColumn;
    @FXML
    private TableColumn<Book, Boolean> AvailableColumn;

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
    @FXML
    private Label AvailableLabel;
    private CYBooks cyBooks;

    /**
     * Constructor for the controller
     */
    public BookOverviewController() {
    }

    /**
     * To initialize the values to be shown
     */
    @FXML
    private void initialize(){
        ISBNColumn.setCellValueFactory(cellData -> cellData.getValue().ISBNProperty().asObject());
        TitleColumn.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
        AuthorColumn.setCellValueFactory(cellData -> cellData.getValue().AuthorProperty().asString());
        PublishingDateColumn.setCellValueFactory(cellData -> cellData.getValue().PublishingProperty());
        AvailableColumn.setCellValueFactory(cellData -> cellData.getValue().AvailableProperty());

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
     * Get the data to be shown
     * @param cyBooks
     */
    public void setCYBooks(CYBooks cyBooks){
        this.cyBooks = cyBooks;
        BookList.setItems(cyBooks.getBookData());
    }


    /**
     * To show more information for a given book
     * @param book
     */
    private void showBookDetails(Book book){
        if( book != null ){
            TitleLabel.setText(book.getTitle());
            AuthorLabel.setText(book.getAuthor().toString());
            ISBNLabel.setText(Integer.toString(book.getISBN()));
            PublishingLabel.setText(book.getPublishingDate().toString());
            EditionLabel.setText(book.getEdition());
            GenreLabel.setText(book.getGenre().toString());
            AvailableLabel.setText(Boolean.toString(book.isAvailable()));
        } else {
            TitleLabel.setText("");
            AuthorLabel.setText("");
            ISBNLabel.setText("");
            PublishingLabel.setText("");
            EditionLabel.setText("");
            GenreLabel.setText("");
            AvailableLabel.setText("");

        }

    }
}
