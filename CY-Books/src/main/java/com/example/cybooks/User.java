package com.example.cybooks;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User extends Person {

    private IntegerProperty NbBorrowedBooks;
    private List<Borrow> borrowedBooks;
    private List<Borrow> borrowHistory;


    /**
     * Empty constructor for user
     */

    public User() {
        super();
        this.borrowedBooks = new ArrayList<>();
        this.borrowHistory = new ArrayList<>();
        this.NbBorrowedBooks = new SimpleIntegerProperty(0);
    }

    /**
     * Constructor for User
     *
     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     * @param DOB User's Date of Birth
     */
    public User(String lastName, String firstName, String mail, String telephone, String address,LocalDate DOB) {
        super(lastName, firstName, mail, telephone, address, DOB);
        this.borrowedBooks = new ArrayList<>();
        this.borrowHistory = new ArrayList<>();
        this.NbBorrowedBooks = new SimpleIntegerProperty(0);
    }


    /**
     * Method to borrow a book by checking its availability
     *
     * @param borrow book, the book you are trying to borrow
     * @return a boolean which indicates if you succeeded in borrowing the book
     */
    public boolean BorrowBook(Borrow borrow) {
        if (!borrow.getBook().isAvailable()) {
            System.out.println("This book isn't currently available for borrowing.");
            return false;
        }
        System.out.println("You have successfully borrowed the book: " + borrow.getBook().getTitle());
        borrowedBooks.add(borrow);
        borrowHistory.add(borrow);
        borrow.getBook().setAvailable(false);
        NbBorrowedBooks.set(borrowedBooks.size());
        return true;
    }

    /**
     * Method to return a book by calling another function Return() of the class
     * Book
     *
     * @param borrow, the borrow you are trying to return
     */
    public void GiveBack(Borrow borrow) {
        if (!borrow.isReturned()) {
            borrow.Return();
            borrow.getBook().Return();
            borrowedBooks.remove(borrow);
            NbBorrowedBooks.set(borrowedBooks.size());
            System.out.println("You have successfully returned the book: " + borrow.getBook().getTitle());
        } else {
            System.out.println("This book has already been returned.");
        }
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

    // Other change methods omitted for brevity...

    @Override
    public String toString() {
        return ("The user with the ID " + getID() + " is " + getFirstName() + " " + getLastName() + "\nThe User lives at " + getAddress() + "\n"
                + getFirstName() + "'s email and phone are " + getMail() + " and " + getPhone() + "\n");
    }

    /**
     * Function to get the list of all borrowed books
     *
     * @return list of borrowed books
     */
    public List<Borrow> getBorrowHistory() {
        return borrowHistory;
    }

    /**
     * Function to get the list of currently borrowed books
     *
     * @return list of currently borrowed books
     */
    public List<Borrow> getCurrentBorrows() {
        return borrowedBooks;
    }

    /**
     * Function to get the list of currently borrowed books which are not yet returned
     *
     * @return list of not yet returned borrowed books
     */
    public List<Borrow> Actual() {
        List<Borrow> notReturnedBooks = new ArrayList<>();
        for (Borrow borrow : borrowedBooks) {
            if (!borrow.isReturned()) {
                notReturnedBooks.add(borrow);
            }
        }
        return notReturnedBooks;
    }
}
