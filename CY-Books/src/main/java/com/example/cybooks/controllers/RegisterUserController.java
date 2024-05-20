package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
import com.example.cybooks.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


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
    private TextField adressField;
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
    public void setCYBooks(CYBooks cyBooks) {
        this.cyBooks = cyBooks;
    }

    public void registerUser(ActionEvent event) throws IOException {
        try {
            if (checkUserRegistering()) {
                System.out.println("OK");
            } else {
                System.out.println("NOT OK");
            }
        }
        catch(IOException e){
            throw e;
        }
    }

    public boolean checkUserRegistering() throws IOException{

        try{
            //retrive the datas from the form
            //The firstname
            String firstnametmp=firstNameField.getText().toString();
            if(firstnametmp.equals("")){
                errorField.setText("Enter a firstname.");
                return false;
            }
            //the latname
            String lastnametmp=lastNameField.getText().toString();
            if(lastnametmp.equals("")){
                errorField.setText("Enter a lastname.");
                return false;
            }
            //the mail
            String mailtmp=mailField.getText().toString();
            //the phone number
            String phonetmp=phoneField.getText().toString();
            //the address
            String addresstmp=adressField.getText().toString();
            if(addresstmp.equals("")){
                errorField.setText("Enter an address.");
                return false;
            }
            //the date of birth
            String dobtmp;
            if(DOBField.getValue()==null){
                errorField.setText("Enter a date of birth.");
                return false;
            }
            else{
                dobtmp=DOBField.getValue().toString();
            }
            /////////

            //make the statement
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            Statement statement = connection.createStatement();

            //check if the user already exist
            String retrieveQuerySQL="SELECT * FROM user WHERE firstName=\""+firstnametmp+"\" AND lastName=\""+lastnametmp+"\" AND address=\""+addresstmp+"\" AND dob=\""+dobtmp+"\";";
            ResultSet resultSet = statement.executeQuery(retrieveQuerySQL);


            if (resultSet.isBeforeFirst() ) {
                errorField.setText("The same user already exist.");
                return false;
            }

            //if everything is okay
            String addUserStatement="INSERT INTO `user` (`firstName`,`lastName`,`mail`,`phone`,`address`,`dob`) VALUES (\""+firstnametmp+"\",\""+lastnametmp+"\",\""+mailtmp+"\",\""+phonetmp+"\",\""+addresstmp+"\",\""+dobtmp+"\");";
            Statement statementadd = connection.createStatement();
            statementadd.executeUpdate(addUserStatement);
            errorField.setText("User registered with success.");
            return true; //if everything went fine
        }
        catch(Exception e){//if there is an error
            errorField.setText("Error. Please try again later.");

            return false;
        }


    }
}

