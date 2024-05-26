package com.example.cybooks.controllers;

import com.example.cybooks.Book;
import com.example.cybooks.User;
import com.example.cybooks.CYBooks;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;
import java.time.ZoneId;

public class UserOverviewController {


    /**
     * The list of users
     */
    @FXML
    private TableView<User> UserList;


    /**
     * Values to be shown in the table containing the list of books

    */
    @FXML
    private TableColumn<User, Integer> IDColumn;
    @FXML
    private TableColumn<User, String> LastNameColumn;
    @FXML
    private TableColumn<User,String> FirstNameColumn;
    @FXML
    private TableColumn<User,String> MailColumn;
    @FXML
    private TableColumn<User,String> PhoneColumn;
    @FXML
    private TableColumn<User,String> AddressColumn;
    @FXML
    private TableColumn<User,Integer> NumberBorrowedBooksColumn;
    @FXML
    private Label numberPageLabel;

    private CYBooks cyBooks;


    /**
     * To initialize the values to be shown
    */
    @FXML
    private void initialize(){
        IDColumn.setCellValueFactory(cellData -> cellData.getValue().IDProperty().asObject());
        LastNameColumn.setCellValueFactory(cellData -> cellData.getValue().LastNameProperty());
        FirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().FirstNameProperty());
        MailColumn.setCellValueFactory(cellData -> cellData.getValue().MailProperty());
        PhoneColumn.setCellValueFactory(cellData -> cellData.getValue().PhoneProperty());
        AddressColumn.setCellValueFactory(cellData -> cellData.getValue().AddressProperty());
        NumberBorrowedBooksColumn.setCellValueFactory(cellData -> cellData.getValue().nbBorrowedBooksProperty().asObject());
        numberPageLabel.setText("1");

    }




    /**
     * To call the main instance of CYBooks and get the data to be shown
     * @param cyBooks the main instance of CYBooks
     */
    public void setCYBooks(CYBooks cyBooks) {
        try {
            //initialize
            this.cyBooks = cyBooks;
            this.cyBooks.emptyUserData();

            //make the statement
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            PreparedStatement statement =connection.prepareStatement("SELECT * FROM user ORDER BY id LIMIT ? OFFSET ?");
            //execute the retrive statement
            //String retrieveQuerySQL="SELECT * FROM user ORDER BY id OFFSET "+numberPageLabel.getText()+" ROWS FETCH NEXT 12 ROWS ONLY;";
            statement.setInt(1,10);
            statement.setInt(2,(Integer.parseInt(numberPageLabel.getText())-1)*10);

            ResultSet resultSet = statement.executeQuery();


            if(resultSet.isBeforeFirst() ){
                while(resultSet.next()){
                    User userRetrieve = new User();
                    userRetrieve.setID(resultSet.getInt("id"));
                    userRetrieve.setFirstName(resultSet.getString("firstName"));
                    userRetrieve.setLastName(resultSet.getString("lastName"));
                    userRetrieve.setMail(resultSet.getString("mail"));
                    userRetrieve.setPhone(resultSet.getString("phone"));
                    userRetrieve.setAddress(resultSet.getString("address"));
                    userRetrieve.setDOB(resultSet.getDate("dob").toLocalDate());


                    //Add the user
                    this.cyBooks.addUser(userRetrieve);
                }

            }
            UserList.setItems(cyBooks.getUserData());


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void nextPage(){
        try {

            this.cyBooks=new CYBooks();

            int nbNextPage = Integer.parseInt(numberPageLabel.getText()) + 1;
            numberPageLabel.setText(String.valueOf(nbNextPage));
            //make the statement
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user ORDER BY id LIMIT ? OFFSET ?");
            //execute the retrive statement
            //String retrieveQuerySQL="SELECT * FROM user ORDER BY id OFFSET "+numberPageLabel.getText()+" ROWS FETCH NEXT 12 ROWS ONLY;";
            statement.setInt(1, 10);
            statement.setInt(2, (Integer.parseInt(numberPageLabel.getText()) - 1) * 10);

            ResultSet resultSet = statement.executeQuery();


            if(resultSet.isBeforeFirst() ){
                while(resultSet.next()){
                    User userRetrieve = new User();
                    userRetrieve.setID(resultSet.getInt("id"));
                    userRetrieve.setFirstName(resultSet.getString("firstName"));
                    userRetrieve.setLastName(resultSet.getString("lastName"));
                    userRetrieve.setMail(resultSet.getString("mail"));
                    userRetrieve.setPhone(resultSet.getString("phone"));
                    userRetrieve.setAddress(resultSet.getString("address"));
                    //where is the DOB? we need another column.
                    userRetrieve.setDOB(resultSet.getDate("dob").toLocalDate());


                    //Add the number of book
                    this.cyBooks.addUser(userRetrieve);

                }

            }
            UserList.getItems().clear();
            UserList.setItems(cyBooks.getUserData());

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
    public void previousPage(){
        try {
            this.cyBooks=new CYBooks();
            int nbNextPage = Integer.parseInt(numberPageLabel.getText()) - 1;
            if(nbNextPage<1){
                nbNextPage=1;
            }
            numberPageLabel.setText(String.valueOf(nbNextPage));
            //make the statement
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user ORDER BY id LIMIT ? OFFSET ?");
            //execute the retrive statement
            //String retrieveQuerySQL="SELECT * FROM user ORDER BY id OFFSET "+numberPageLabel.getText()+" ROWS FETCH NEXT 12 ROWS ONLY;";

            statement.setInt(1, 10);
            statement.setInt(2, (Integer.parseInt(numberPageLabel.getText()) - 1) * 10);

            ResultSet resultSet = statement.executeQuery();


            if(resultSet.isBeforeFirst() ){
                while(resultSet.next()){
                    User userRetrieve = new User();
                    userRetrieve.setID(resultSet.getInt("id"));
                    userRetrieve.setFirstName(resultSet.getString("firstName"));
                    userRetrieve.setLastName(resultSet.getString("lastName"));
                    userRetrieve.setMail(resultSet.getString("mail"));
                    userRetrieve.setPhone(resultSet.getString("phone"));
                    userRetrieve.setAddress(resultSet.getString("address"));
                    //where is the DOB? we need another column.
                    userRetrieve.setDOB(resultSet.getDate("dob").toLocalDate());


                    //Add the number of book
                    this.cyBooks.addUser(userRetrieve);
                }

            }
            UserList.getItems().clear();
            UserList.setItems(cyBooks.getUserData());

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
