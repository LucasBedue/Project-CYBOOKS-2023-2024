package com.example.cybooks.controllers;


import com.example.cybooks.*;
import javafx.beans.property.IntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

public class BorrowedBooksController {

    /**
     * The list of books
     */
    @FXML
    private TableView<Book> BookList;
    @FXML
    private TableView<User> ClientList;

    private int selecteduserId;

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
    @FXML
    private TableColumn<Book, LocalDate> ReturnByColumn;
    @FXML
    private TableColumn<User, Integer> idClientColumn;

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

    @FXML
    private Label labelPageNumber;
    /**
     * Constructor for the controller
     */
    public BorrowedBooksController() {
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
        ReturnByColumn.setCellValueFactory(cellData -> cellData.getValue().getBook().PublishingProperty());
        idClientColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
        this.selecteduserId=0;
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
    public void setCYBooks(CYBooks cyBooks){
        try{
            this.cyBooks = cyBooks;
            this.cyBooks.emptyBookData();
            this.cyBooks.emptyUserData();


            List<Book> tmpBookList;
            Request request=new Request();
            int nbNextPage = Integer.parseInt(labelPageNumber.getText()) ;
            Search search=new Search.Builder().build();
            search.changeStartRecord((nbNextPage-1)*10);

            //make the statement
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            PreparedStatement statement = connection.prepareStatement("SELECT books.isbn,borrows.id_client FROM books INNER JOIN borrows ON books.id=borrows.id_book AND borrows.dateReturn IS NULL ORDER BY books.id LIMIT ? OFFSET ?");
            //execute the retrive statement

            statement.setInt(1, 10);
            statement.setInt(2, (Integer.parseInt(labelPageNumber.getText()) - 1) * 10);

            ResultSet resultSet = statement.executeQuery();//we have borrowed books isbn

            if(resultSet.isBeforeFirst() ){
                while(resultSet.next()){

                    search.changeIsbn(resultSet.getString("books.isbn"));//search by ISBN


                    tmpBookList = request.search(search);//we have the book
                    if(tmpBookList!=null) {
                        this.cyBooks.addBook(tmpBookList.get(0));
                        User tmpuser=new User();
                        tmpuser.setID(resultSet.getInt("borrows.id_client"));
                        this.cyBooks.addUser(tmpuser);
                    }
                    tmpBookList.clear();

                }
            }



            BookList.setItems(this.cyBooks.getBookData());
            ClientList.setItems(this.cyBooks.getUserData());

        }
        catch(Exception e){
            e.printStackTrace();

        }


    }


    /**
     * To show more information for a given book
     * @param book
     */
    @FXML
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
            this.selecteduserId= 0;

        }

    }

    /**
     * To show the informations of the next page
     */
    @FXML
    private void nextPage(){
        try{

            int nbNextPage = Integer.parseInt(labelPageNumber.getText()) +1;

            List<Book> tmpBookList;
            Request request=new Request();
            Search search=new Search.Builder().build();
            //search.changeStartRecord((nbNextPage-1)*10);

            //make the statement
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            PreparedStatement statement = connection.prepareStatement("SELECT books.isbn,borrows.id_client FROM books INNER JOIN borrows ON books.id=borrows.id_book AND borrows.dateReturn IS NULL ORDER BY books.id LIMIT ? OFFSET ?");
            //execute the retrive statement

            statement.setInt(1, 10);
            statement.setInt(2, (Integer.parseInt(labelPageNumber.getText()) ) * 10);

            ResultSet resultSet = statement.executeQuery();//we have borrowed books isbn

            if(resultSet.isBeforeFirst() ){
                this.cyBooks.emptyBookData();
                this.cyBooks.emptyUserData();
                labelPageNumber.setText(Integer.toString(nbNextPage));
                while(resultSet.next()){

                    search.changeIsbn(resultSet.getString("books.isbn"));//search by ISBN


                    tmpBookList = request.search(search);//we have the book
                    if(tmpBookList!=null) {
                        this.cyBooks.addBook(tmpBookList.get(0));
                        User tmpuser=new User();
                        tmpuser.setID(resultSet.getInt("borrows.id_client"));
                        this.cyBooks.addUser(tmpuser);
                        tmpBookList.clear();
                    }


                }
                BookList.setItems(this.cyBooks.getBookData());
                ClientList.setItems(this.cyBooks.getUserData());
            }




            }
        catch(Exception e){
            e.printStackTrace();

        }
    }

    /**
     * To show the informations of the previous page
     */
    @FXML
    private void previousPage(){
        try{

            int nbNextPage = Integer.parseInt(labelPageNumber.getText()) -1;
            if(nbNextPage>0) {
                this.cyBooks.emptyBookData();
                this.cyBooks.emptyUserData();


                List<Book> tmpBookList;
                Request request=new Request();


                Search search = new Search.Builder().build();
                //search.changeStartRecord((nbNextPage-1) * 10);

                //make the statement
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
                PreparedStatement statement = connection.prepareStatement("SELECT books.isbn,borrows.id_client FROM books INNER JOIN borrows ON books.id=borrows.id_book AND borrows.dateReturn IS NULL ORDER BY books.id LIMIT ? OFFSET ?");
                //execute the retrive statement

                statement.setInt(1, 10);
                statement.setInt(2, (Integer.parseInt(labelPageNumber.getText()) - 2) * 10);

                ResultSet resultSet = statement.executeQuery();//we have borrowed books isbn

                if (resultSet.isBeforeFirst()) {
                    labelPageNumber.setText(Integer.toString(nbNextPage ));

                    while (resultSet.next()) {

                        search.changeIsbn(resultSet.getString("books.isbn"));//search by ISBN


                        tmpBookList = request.search(search);//we have the book
                        if (tmpBookList!=null) {
                            this.cyBooks.addBook(tmpBookList.get(0));
                            User tmpuser = new User();
                            tmpuser.setID(resultSet.getInt("borrows.id_client"));
                            this.cyBooks.addUser(tmpuser);
                            tmpBookList.clear();
                        }


                    }
                }


                BookList.setItems(this.cyBooks.getBookData());
                ClientList.setItems(this.cyBooks.getUserData());
            }
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }

    /**
     * To return a book, not functional
     */
    @FXML
    private void returnBook(){
        try{


        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
}
