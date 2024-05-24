package com.example.cybooks.controllers;

import com.example.cybooks.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class UserSearchController {

    @FXML
    private TextField IDField;
    @FXML
    private Label errorField;
    private CYBooks cyBooks;


    public UserSearchController() {
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
     * Find an user and send it to be shown in ShowUserDetails.fxml
     */
    @FXML
    private void search(){
        try {
            User user = findUser();

            Genre Conte = new Genre("Conte");
            Author Fontaine = new Author("de la Fontaine","Jean","ui","26579102","France",LocalDate.of(1724,12,11),LocalDate.of(1824,12,11));
            Book book1 = new Book("3856226","Corbeau & Renard", Fontaine, Conte, LocalDate.of(1700, 01, 01), "1ST",true);

            Borrow borrow1 = new Borrow(LocalDate.now(), user, book1);

            user.BorrowBook(borrow1);

            if (user != null) {
                System.out.println("OK");
                cyBooks.switchShowUserDetailsScene(user);
            } else {
                System.out.println("NOT OK");

            }
        }
        catch(IOException e){

            e.printStackTrace();
        }

    }

    /**
     * Reads the ID in the IDField and finds the user linked to it in the database
     * @return returns the user
     * @throws IOException
     */
    public User findUser() throws IOException{
        try{
            /**
             * retrieve the data from the form
             */
            /**
             * User's id
             */
            String IDtmp = IDField.getText().toString();
            if(IDtmp.equals("")){
                errorField.setText("Enter ID.");
                return null;
            }



            /**
             * make the statement
             */
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            Statement statement = connection.createStatement();

            /**
             * check if the user already existS
             */
            String retrieveQuerySQL="SELECT * FROM user WHERE id =\""+IDtmp+"\";";
            ResultSet resultSet = statement.executeQuery(retrieveQuerySQL);


            if (!resultSet.isBeforeFirst() ) {
                errorField.setText("User doesn't exist");
                return null;
            }

            while(resultSet.next()) {
                User newUser = new User(resultSet.getInt("id"),resultSet.getString("lastName"),resultSet.getString("firstName"),resultSet.getString("mail"),resultSet.getString("phone"),resultSet.getString("address"),resultSet.getDate("dob").toLocalDate());
                return newUser;
            }


        } catch (Exception e){
            errorField.setText("Error. Please try again later.");
            return null;
        }
        return null;
    }
}

