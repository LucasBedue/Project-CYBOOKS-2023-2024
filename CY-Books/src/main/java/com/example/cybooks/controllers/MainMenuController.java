package com.example.cybooks.controllers;

import com.example.cybooks.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    /**
     * To call the main instance of CYBooks
     * @param cyBooks the main instance of CYBooks
     */
    public void setCYBooks(CYBooks cyBooks) {
        this.cyBooks = cyBooks;
    }

    /**
     * To call the functions to switch the center node
     */
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
    @FXML
    private void switchBookSearch2Scene(Search search) {
        cyBooks.switchBookSearch2Scene(search);
    }


    /**
     * To reset the database
     */
    @FXML
    private void resetDatabase(){
        try {
            //make the statement
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            Statement statement = connection.createStatement();

            statement.execute("DROP TABLE books;");
            statement.execute("DROP TABLE user;");
            statement.execute("DROP TABLE borrows;");

            SQLExecutor sqlExecutor = new SQLExecutor("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            sqlExecutor.executeFile("./src/main/resources/com/example/cybooks/BDDCreation.sql");

            Request request = new Request();
            List<Book> booksToTreat=new ArrayList<Book>();
            //multi search multi
            Search query = new Search.Builder().setMaximumRecords(100).build();
            ResultSet resultSet;

            for(int iquery=0;iquery<10;iquery++){//we could retrieve all the books, but it would be too long, so let's take only the first 1000
                query.changeStartRecord(iquery*100);
                booksToTreat = request.search(query);//we are getting books
                for (int i = 0; i < booksToTreat.size(); i++) {
                    resultSet=statement.executeQuery("SELECT 1 FROM books WHERE isbn=\""+booksToTreat.get(i).getISBN()+"\";");//to not take duplicates
                    if (!resultSet.isBeforeFirst() ) {
                        statement.executeUpdate("INSERT INTO books (`isbn`) VALUES (\""+booksToTreat.get(i).getISBN()+"\");");

                    }
                }
            }

            System.out.println("End reset");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
