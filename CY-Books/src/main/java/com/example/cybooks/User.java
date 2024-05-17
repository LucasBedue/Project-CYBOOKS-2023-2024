package com.example.cybooks;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.security.SecureRandom;

public class User extends Person {

    /**
     * Constructor for User

     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     */

    public User(String lastName, String firstName, String mail, double telephone, String address) {
        super(lastName, firstName, mail, telephone, address);
    }

    /**
     * Method to borrow a book by checking is availability
     * @param book, the book you are trying to borrow
     * @return a boolean which indicates if you succeeded in borrowing the book
     */

    public boolean BorrowBook(Book book) {
        if (!book.isAvailable()) {
            System.out.println("This book isn't currently available for borrowing.");
            return false;
        }

        if (book.Borrow()) {
            System.out.println("You have successfully borrowed the book: " + book.getTitle());
            return true;
        } else {
            System.out.println("Failed to borrow the book: " + book.getTitle());
            return false;
        }
    }

    /**
     * Method to return a book by calling another function Return() of the class Book
     * @param book, the book you are trying to return
     */
    public void GiveBack(Book book) {
        book.Return();
        System.out.println("You have successfully returned the book: " + book.getTitle());
    }

    /**
     * Function to change the last name of a user
     * @param the new last name
     */
    public void changeLastName(String LastName){
        StringProperty name = new SimpleStringProperty((String) LastName);
        setLastName(name);
    }

    /**
     * Function to change the first name of a user
     * @param the new first name
     */
    public void changeFirstName(String FirstName){
        StringProperty name = new SimpleStringProperty((String) FirstName);
        setLastName(name);
    }

    /**
     * Function to change the address of a user
     * @param the new address
     */
    public void changeAddress(String address){
        StringProperty location = new SimpleStringProperty((String) address);
        setAddress(location);
    }

    /**
     * Function to change the phone number of a user
     * @param the new phone number
     */
    public void changePhone(Double phone){
        DoubleProperty number = new SimpleDoubleProperty((double) phone);
        setPhone(number);
    }

    /**
     * Function to change the mail of a user
     * @param the new mail
     */
    public void changeMail(String mail){
        StringProperty email = new SimpleStringProperty((String) mail);
        setMail(email);
    }

    @Override
    public String toString(){
    return ("The user with the ID "+getID()+" is "+ getFirstName() +" "+ getLastName()+"\nThe User live " + getAdress()+"\n" +
            getFirstName() + " mail and phone are " + getMail() +" "+ getphone());
    }
}
