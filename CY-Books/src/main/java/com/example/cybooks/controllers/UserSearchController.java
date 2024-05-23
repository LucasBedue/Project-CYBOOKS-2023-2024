package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
import com.example.cybooks.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
    public void setCYBooks(CYBooks cyBooks) {
        this.cyBooks = cyBooks;
    }

    @FXML
    private void search(){
        try {
            User user = findUser();
            if (user != null) {
                System.out.println("OK");
                cyBooks.switchShowUserDetailsScene();
            } else {
                System.out.println("NOT OK");

            }
        }
        catch(IOException e){

            e.printStackTrace();
        }

    }

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
                User newUser = new User(resultSet.getString("lastName"),resultSet.getString("firstName"),resultSet.getString("mail"),resultSet.getString("phone"),resultSet.getString("address"),resultSet.getDate("dob").toLocalDate());
                return newUser;
            }


        } catch (Exception e){
            errorField.setText("Error. Please try again later.");
            return null;
        }
        return null;
    }
}

