package com.example.cybooks;

public class User extends Person {
    
    /**
     * Constructor for User
     * @param ID
     * @param lastName
     * @param firstName
     * @param mail
     * @param phone
     * @param address
     */

    public User(int ID, String lastName, String firstName, String mail, double telephone, String address) {
        super(ID, lastName, firstName, mail, telephone, address);
    }
    
    /**
     * Method to borrow a book by checking is availability 
     * @param Book book, the book you are trying to borrow
     * @return a boolean wich indicate if you succed to borrow the book
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
     * Method to return a book by calling an other fonction Return() of the class Book
     * @param Book book, the book you are trying to give back
     */
    public void GiveBack(Book book) {
        book.Return();
        System.out.println("You have successfully returned the book: " + book.getTitle());
    }
}

