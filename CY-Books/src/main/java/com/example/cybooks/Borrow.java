package com.example.cybooks;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class Borrow {
    private ObjectProperty<LocalDate> BorrowingDate;
    private ObjectProperty<LocalDate> DateToBeReturnedBy;
    private ObjectProperty<LocalDate> returned;
    private ObjectProperty<Person> person;
    private ObjectProperty<Book> book;

    /**
     * Constructor for borrowing a book
     *
     * @param borrowingDate
     * @param person
     * @param book
     */
    public Borrow(LocalDate borrowingDate, Person person, Book book) {
        this.BorrowingDate = new SimpleObjectProperty<LocalDate>(borrowingDate);
        this.person = new SimpleObjectProperty<Person>(person);
        this.book = new SimpleObjectProperty<Book>(book);
        this.DateToBeReturnedBy = new SimpleObjectProperty<LocalDate>(borrowingDate.plusDays(20));
        this.returned = null;
    }


    /**
     * Function to verify if a book was returned late with the date of today
     */
    public void Return() {
        if (LocalDate.now().isAfter(this.DateToBeReturnedBy.getValue())) {
            System.out.println("This book was returned late");
        } else {
            System.out.println("Thanks for returning the book on time");
        }
        this.returned.set(LocalDate.now());
    }

    public boolean isReturned() {
        return this.returned != null;
    }

    public Book getBook() {
        return this.book.get();
    }

    public LocalDate getReturned() {
        return this.returned.get();
    }

    public ObjectProperty<LocalDate> ReturnByProperty() {
        return this.DateToBeReturnedBy;
    }

    public LocalDate getDateToBeReturnedBy() {
        return this.DateToBeReturnedBy.get();
    }

    public Person getPerson() {
        return this.person.get();
    }


    @Override
    public String toString() {
        return "This book is " + this.book.toString() + " borrowed by " + this.person.toString() + " on " + this.BorrowingDate.toString() + " and to be returned by " + this.DateToBeReturnedBy.toString();
    }
}
