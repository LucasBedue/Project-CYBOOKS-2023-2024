package com.example.cybooks.controllers;

import com.example.cybooks.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookSearch2Controller {

    /**
     * The list of books
     */
    @FXML
    private TableView<Book> BookList;

    /**
     * Values to be shown in the table containing the list of books
     */

    @FXML
    private TableColumn<Book, String> ISBNColumn;
    @FXML
    private TableColumn<Book, String> TitleColumn;
    @FXML
    private TableColumn<Book,String> AuthorColumn;
    @FXML
    private TableColumn<Book, LocalDate> PublishingDateColumn;

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
    private Search search;

    @FXML
    private Label numberPageLabel;
    /**
     * Constructor for the controller
     */
    public BookSearch2Controller() {
    }

    /**
     * To initialize the values to be shown
     */
    @FXML
    private void initialize(){
        ISBNColumn.setCellValueFactory(cellData -> cellData.getValue().ISBNProperty());
        TitleColumn.setCellValueFactory(cellData -> cellData.getValue().TitleProperty());
        AuthorColumn.setCellValueFactory(cellData -> cellData.getValue().AuthorProperty().asString());
        PublishingDateColumn.setCellValueFactory(cellData -> cellData.getValue().PublishingProperty());

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
     * To call the main instance of CYBooks and the data to be shown
     * @param cyBooks the main instance of CYBooks
     */
    public void setCYBooks(CYBooks cyBooks, Search search){

        this.cyBooks = cyBooks;
        this.cyBooks.emptyBookData();
        this.search=search;
        Request request=new Request();

        List<Book> tmpBookList;
        tmpBookList = request.search(search);


            for (int i = 0; i < tmpBookList.size(); i++) {
                this.cyBooks.addBook(tmpBookList.get(i));
            }


            BookList.setItems(this.cyBooks.getBookData());

    }


    /**
     * To show more information for a given book
     * @param book
     */
    private void showBookDetails(Book book){
        if( book != null ){
            TitleLabel.setText(book.getTitle());
            AuthorLabel.setText(book.getAuthor().toString());
            ISBNLabel.setText(book.getISBN());
            PublishingLabel.setText(book.getPublishingDate().toString());
            EditionLabel.setText(book.getEdition());
            GenreLabel.setText(book.getGenre().toString());

        } else {
            TitleLabel.setText("");
            AuthorLabel.setText("");
            ISBNLabel.setText("");
            PublishingLabel.setText("");
            EditionLabel.setText("");
            GenreLabel.setText("");

        }

    }

    public void previousPage(){
        try{
            this.cyBooks.emptyBookData();
            Request request=new Request();
            List<Book> tmpBookList;
            int nbNextPage = Integer.parseInt(numberPageLabel.getText()) - 1;
            this.search.changeStartRecord((nbNextPage-1)*10);
            tmpBookList = request.search(this.search);

            if(nbNextPage<1){
                nbNextPage=1;
            }


            this.search.changeStartRecord((nbNextPage-1)*10);
            tmpBookList = request.search(this.search);

            if(tmpBookList!=null) {
                numberPageLabel.setText(String.valueOf(nbNextPage));


                for (int i = 0; i < tmpBookList.size(); i++) {
                    this.cyBooks.addBook(tmpBookList.get(i));
                }

                BookList.setItems(this.cyBooks.getBookData());
            }



        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void nextPage(){
        try{

            Request request=new Request();
            List<Book> tmpBookList;
            int nbNextPage = Integer.parseInt(numberPageLabel.getText()) + 1;
            this.search.changeStartRecord((nbNextPage-1)*10);
            tmpBookList = request.search(this.search);

            if(tmpBookList!=null) {
                this.cyBooks.emptyBookData();
                numberPageLabel.setText(String.valueOf(nbNextPage));


                for (int i = 0; i < tmpBookList.size(); i++) {
                    this.cyBooks.addBook(tmpBookList.get(i));
                }

                BookList.setItems(this.cyBooks.getBookData());

            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
