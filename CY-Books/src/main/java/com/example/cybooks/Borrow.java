package com.example.cybooks;

import java.time.LocalDate;

public class Borrow {
    private LocalDate BorrowingDate;
    private LocalDate DateToBeReturnedBy;
    private boolean rendered;
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
        this.rendered=false;
    }



    public LocalDate getDateToBeReturnedBy() {
        return this.DateToBeReturnedBy;
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
        this.rendered=true;
    }
    public Book getBook(){
        return this.book;
    }

    public boolean getA() {
        return this.rendered;
    }

    public Person getPerson(){
        return this.person;
    }

    @Override
    public String toString(){
        return "This book is " + this.book.toString() + " borrow by " + this.person.toString() + " the " + this.BorrowingDate.toString() +"and return it the" +this.DateToBeReturnedBy.toString();
    }
}
