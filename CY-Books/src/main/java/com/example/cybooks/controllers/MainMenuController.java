package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
import com.example.cybooks.Request;
import com.example.cybooks.SQLExecutor;
import com.example.cybooks.Search;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

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
    private void switchBookSearch2Scene() {
        cyBooks.switchBookSearch2Scene();
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
            sqlExecutor.executeFile("./CY-Books/src/main/resources/com/example/cybooks/BDDCreation.sql");

            Request request = new Request();

            // exemple du multi search multi
            Search query = new Search.Builder()

                    .build();
            String responseByQuery = request.search(query);

            System.out.println(responseByQuery);




        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
