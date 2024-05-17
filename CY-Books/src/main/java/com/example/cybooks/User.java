package com.example.cybooks;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class User extends Person {

    private IntegerProperty NbBorrowedBooks;

    /**
     * Constructor for User

     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     */

    public User(String lastName, String firstName, String mail, String telephone, String address) {
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


    public int getNbBorrowedBooks() {
        return NbBorrowedBooks.get();
    }

    public IntegerProperty nbBorrowedBooksProperty() {
        return NbBorrowedBooks;
    }

    public void setNbBorrowedBooks(int nbBorrowedBooks) {
        this.NbBorrowedBooks.set(nbBorrowedBooks);
    }

    /**
     * Function to change the last name of a user
     * @param the new last name
     */
    public void changeLastName(String LastName){
        setLastName(LastName);
    }

    /**
     * Function to change the first name of a user
     * @param the new first name
     */
    public void changeFirstName(String FirstName){
        setLastName(FirstName);
    }

    /**
     * Function to change the address of a user
     * @param the new address
     */
    public void changeAddress(String address){
        setAddress(address);
    }

    /**
     * Function to change the phone number of a user
     * @param the new phone number
     */
    public void changePhone(String phone){
        setPhone(phone);
    }

    /**
     * Function to change the mail of a user
     * @param the new mail
     */
    public void changeMail(String mail){
        setMail(mail);
    }

    @Override
    public String toString(){
    return ("The user with the ID "+getID()+" is "+ getFirstName() +" "+ getLastName()+"\nThe User live " + getAddress()+"\n" +
            getFirstName() + " mail and phone are " + getMail() +" and "+ getPhone()+"\n");
    }
}
