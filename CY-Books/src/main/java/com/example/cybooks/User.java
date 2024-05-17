
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
        NbBorrowedBooks = new SimpleIntegerProperty(5);
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


    @Override
    public String toString(){
    return ("The user with the ID "+getID()+" is "+ getFirstName() +" "+ getLastName()+"\nThe User live " + getAddress()+"\n" +
            getFirstName() + " mail and phone are " + getMail() +" "+ getPhone());
    }
}

