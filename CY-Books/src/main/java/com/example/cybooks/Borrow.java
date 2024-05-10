package com.example.cybooks;

import java.time.LocalDate;

public class Borrow {
    private LocalDate BorrowingDate;
    private LocalDate DateToBeReturnedBy;

    private Person person;
    private Book book;


    /**
     * Constructor for borrowing a book
     * @param borrowingDate
     * @param person
     * @param book
     */
    public Borrow(LocalDate borrowingDate, Person person, Book book) {
        this.BorrowingDate = borrowingDate;
        this.person = person;
        this.book = book;
        this.DateToBeReturnedBy = borrowingDate.plusDays(20);
    }

    /**
     * Function to verify if a book was returned late
     * @param ReturnDate
     */
    public void Return(LocalDate ReturnDate){
        if(ReturnDate.isAfter(this.DateToBeReturnedBy)){
            System.out.println("This book was returned late");
        } else{
            System.out.println("Thanks for returning the book on time");
        }
    }
}
