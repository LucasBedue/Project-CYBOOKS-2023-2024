package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
import com.example.cybooks.User;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;


public class RegisterUserController {

    private CYBooks cyBooks;

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField mailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField addressField;
    @FXML
    private DatePicker DOBField;
    @FXML
    private Label errorField;

    public RegisterUserController() {
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
     * To try to register a new user
     */
    @FXML
    public void registerUser(){
        try {
            if (checkUserRegistering()) {
                System.out.println("OK");
            } else {
                System.out.println("NOT OK");
            }
        }
        catch(IOException e){

            e.printStackTrace();
        }
    }

    public boolean checkUserRegistering() throws IOException{

        try{
            /**
             * retrieve the data from the form
             */

            User tmpUser=new User();
            /**
             * The firstname
             */
            String firstnametmp=firstNameField.getText().toString();
            SimpleStringProperty wrongField = new SimpleStringProperty("");
            SimpleObjectProperty<LocalDate> wrongDate = new SimpleObjectProperty<LocalDate>(null);
            if(firstnametmp.equals("")){
                errorField.setText("Enter a firstname.");
                return false;
            }
            else{
                if(tmpUser.setFirstNameConstruct(firstnametmp).getValue().equals(wrongField.getValue())){
                    errorField.setText("Enter a VALID firstname.");
                    return false;
                }
            }
            /**
             * the lastname
             */
            String lastnametmp=lastNameField.getText().toString();
            if(lastnametmp.equals("")){
                errorField.setText("Enter a lastname.");
                return false;
            }
            else{
                if(tmpUser.setLastNameConstruct(lastnametmp).getValue().equals(wrongField.getValue())){
                    errorField.setText("Enter a VALID lastname.");
                    return false;
                }
            }

            /**
             * the mail
             */
            String mailtmp=mailField.getText().toString();
            if(!mailtmp.equals("")){

                if(tmpUser.setMailConstruct(mailtmp).getValue().equals(wrongField.getValue())){
                    errorField.setText("Enter a VALID mail.");
                    return false;
                }

            }
            /**
             * the phone number
             */
            String phonetmp=phoneField.getText().toString();
            if(!phonetmp.equals("")){

                if(tmpUser.setPhoneConstruct(phonetmp).getValue().equals(wrongField.getValue())){
                    errorField.setText("Enter a VALID phone number.");
                    return false;
                }

            }
            /**
             * the address
             */
            String addresstmp=addressField.getText().toString();

            /**
             * the date of birth
             */
            String dobtmp;
            if(DOBField.getValue()==null){
                errorField.setText("Enter a birth date.");
                return false;
            }
            else {
                if(DOBField.getValue().isAfter(LocalDate.now())){
                    errorField.setText("Enter a VALID birth date.");
                    return false;
                }
            }
            dobtmp=DOBField.getValue().toString();


            /**
             * make the statement
             */
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            Statement statement = connection.createStatement();

            /**
             * check if the user already existS
             */
            String retrieveQuerySQL="SELECT * FROM user WHERE firstName=\""+firstnametmp+"\" AND lastName=\""+lastnametmp+"\" AND address=\""+addresstmp+"\" AND dob=\""+dobtmp+"\";";

            ResultSet resultSet = statement.executeQuery(retrieveQuerySQL);


            if (resultSet.isBeforeFirst() ) {
                errorField.setText("The same user already exist.");
                return false;
            }

            /**
             * if everything is okay
             */
            String addUserStatement="INSERT INTO `user` (`firstName`,`lastName`,`mail`,`phone`,`address`,`dob`) VALUES (\""+firstnametmp+"\",\""+lastnametmp+"\",\""+mailtmp+"\",\""+phonetmp+"\",\""+addresstmp+"\",\""+dobtmp+"\");";

            Statement statementadd = connection.createStatement();
            statementadd.executeUpdate(addUserStatement);
            errorField.setText("User registered with success.");
            /**
             * if everything went fine
             */
            return true;
        }
        catch(Exception e){
            /**
             * if there is an error
             */
            e.printStackTrace();
            errorField.setText("Error. Please try again later.");

            return false;
        }


    }
}

