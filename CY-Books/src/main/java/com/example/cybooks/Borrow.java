package com.example.cybooks;

import java.time.LocalDate;

public class Borrow {
    private LocalDate BorrowingDate;
    private LocalDate DateToBeReturnedBy;
    private LocalDate rendered;
    private Person person;
    private Book book;

    /**
     * Constructor for borrowing a book
     *
     * @param borrowingDate
     * @param person
     * @param book
     */
    public Borrow(LocalDate borrowingDate, Person person, Book book) {
        this.BorrowingDate = borrowingDate;
        this.person = person;
        this.book = book;
        this.DateToBeReturnedBy = borrowingDate.plusDays(20);
        this.rendered = null;
    }

    public LocalDate getDateToBeReturnedBy() {
        return this.DateToBeReturnedBy;
    }

    /**
     * Function to verify if a book was returned late with the date of today
     */
    public void Return() {
        if (LocalDate.now().isAfter(this.DateToBeReturnedBy)) {
            System.out.println("This book was returned late");
        } else {
            System.out.println("Thanks for returning the book on time");
        }
        this.rendered = LocalDate.now();
    }

    public boolean isReturned() {
        return this.rendered != null;
    }

    public Book getBook() {
        return this.book;
    }

    public LocalDate getRendered() {
        return this.rendered;
    }

    public Person getPerson() {
        return this.person;
    }

    @Override
    public String toString() {
        return "This book is " + this.book.toString() + " borrowed by " + this.person.toString() + " on " + this.BorrowingDate.toString() + " and to be returned by " + this.DateToBeReturnedBy.toString();
    }
}
