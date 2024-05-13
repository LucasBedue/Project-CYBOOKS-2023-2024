package com.example.cybooks;

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
    @FXML
    private TableView<Book> BookList;

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

    private CYBooks cyBooks;

    public BookOverviewController() {
    }

    @FXML
    private void initialize(){
        ISBNColumn.setCellValueFactory(cellData -> cellData.getValue().ISBNProperty().asObject());
        TitleColumn.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
        AuthorColumn.setCellValueFactory(cellData -> cellData.getValue().AuthorProperty().asString());
        PublishingDateColumn.setCellValueFactory(cellData -> cellData.getValue().PublishingProperty());
        AvailableColumn.setCellValueFactory(cellData -> cellData.getValue().AvailableProperty());
    }

    public void setCYBooks(CYBooks cyBooks){
        this.cyBooks = cyBooks;
        BookList.setItems(cyBooks.getBookData());
    }
}
