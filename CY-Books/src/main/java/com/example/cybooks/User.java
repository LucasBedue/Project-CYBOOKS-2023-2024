package com.example.cybooks;

public class User extends Person {
    
    // Constructor
    public User(int ID, String lastName, String firstName, String mail, double telephone, String address) {
        super(ID, lastName, firstName, mail, telephone, address);
    }
    
    // Method to borrow a book
    public boolean GiveBack(Book book) {
        if (!book.isAvailable()) {
            System.out.println("This book isn't currently available for borrowing.");
            return false;
        }
        
        // Book is available, borrowing it
        if (book.Borrow()) {
            System.out.println("You have successfully borrowed the book: " + book.getTitle());
            return true;
        } else {
            System.out.println("Failed to borrow the book: " + book.getTitle());
            return false;
        }
    }
    
    // Method to return a book
    public void RendreLivre(Book book) {
        book.Return();
        System.out.println("You have successfully returned the book: " + book.getTitle());
    }
}
