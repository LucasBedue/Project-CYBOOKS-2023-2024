package com.example.cybooks.controllers;

import com.example.cybooks.CYBooks;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchToModifyController {


    @FXML
    private TextField IDField;
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
    private Label IDLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label mailLabel;
    @FXML
    private Label phoneLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label DOBLabel;
    @FXML
    private Label errorField;
    @FXML
    private Label TitleLabel;

    @FXML
    private Button button;

    private CYBooks cyBooks;
    public SearchToModifyController() {
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
    public void SearchToModifyUser(){
        try {
            if (checkUserModifying()) {
                System.out.println("OK");
            } else {
                System.out.println("NOT OK");
            }
        }
        catch(IOException e){

            e.printStackTrace();
        }
    }


    public boolean checkUserModifying() throws IOException{

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
                return false;
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
                return false;
            }

            while(resultSet.next()) {

                TitleLabel.setText("Modify user");
                IDLabel.setVisible(false);
                IDField.setVisible(true);

                firstNameLabel.setVisible(true);
                firstNameField.setVisible(true);
                firstNameField.setText(resultSet.getString("firstName"));

                lastNameLabel.setVisible(true);
                lastNameField.setVisible(true);
                lastNameField.setText(resultSet.getString("lastName"));

                mailLabel.setVisible(true);
                mailField.setVisible(true);
                mailField.setText(resultSet.getString("mail"));

                phoneLabel.setVisible(true);
                phoneField.setVisible(true);
                phoneField.setText(resultSet.getString("phone"));

                addressLabel.setVisible(true);
                addressField.setVisible(true);
                addressField.setText(resultSet.getString("address"));

                DOBLabel.setVisible(true);
                DOBField.setVisible(true);
                DOBField.setValue(resultSet.getDate("dob").toLocalDate());

                button.setText("Modify");
                button.setOnAction(event -> {modifyUser();});


                /**
                 * if everything is okay
                 */
                //String modifyUserStatement = "INSERT INTO `user` (`firstName`,`lastName`) VALUES (\""+firstnametmp+"\",\""+lastnametmp+"\");";
                //Statement statementadd = connection.createStatement();
                //statementadd.executeUpdate(modifyUserStatement);
                //errorField.setText("User registered with success.");
                /**
                 * if everything went fine
                 */
            }
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

    @FXML
    public void modifyUser(){
        try {
            if (UserModifying()) {
                System.out.println("OK");
            } else {
                System.out.println("NOT OK");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public boolean UserModifying(){
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
                return false;
            }
            /**
             * The firstname
             */
            String firstnametmp = firstNameField.getText().toString();
            if(firstnametmp.equals("")){
                errorField.setText("Enter a firstname.");
                return false;
            }
            /**
             * the lastname
             */
            String lastnametmp = lastNameField.getText().toString();
            if(lastnametmp.equals("")){
                errorField.setText("Enter a lastname.");
                return false;
            }

            /**
             * the mail
             */
            String mailtmp = mailField.getText().toString();

            /**
             * the phone number
             */
            String phonetmp = phoneField.getText().toString();
            /**
             * the address
             */
            String addresstmp = addressField.getText().toString();
            if(addresstmp.equals("")){
                errorField.setText("Enter an address.");
                return false;
            }
            /**
             * the date of birth
             */
            String dobtmp;
            if(DOBField.getValue()==null){
                errorField.setText("Enter a date of birth.");
                return false;
            }
            else{
                dobtmp=DOBField.getValue().toString();
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
                return false;
            }

            while (resultSet.next()){

                String modifyUserStatement = "UPDATE `user` SET firstName = \""+ firstnametmp +"\" ,lastName = \""+ lastnametmp +"\", mail = \"" + mailtmp + "\", phone = \"" + phonetmp + "\", address = \"" + addresstmp + "\", dob = \"" + dobtmp +"\" WHERE id =\""+IDtmp+"\";";
                Statement statementadd = connection.createStatement();
                statementadd.executeUpdate(modifyUserStatement);
                errorField.setText("User modified with success.");

            }
            return true;

        } catch (Exception e) {
            /**
             * if there is an error
             */
            e.printStackTrace();
            errorField.setText("Error. Please try again later.");

            return false;
        }
    }

}

