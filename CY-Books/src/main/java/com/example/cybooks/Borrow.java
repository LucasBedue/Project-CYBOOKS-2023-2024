package com.example.cybooks;

import java.time.LocalDate;

public class Borrow {
    private LocalDate BorrowingDate;
    private LocalDate DateToBeReturnedBy;

    /**
     * Constructor for borrowing a book
     * @param borrowingDate
     */
    public Borrow(LocalDate borrowingDate) {
        BorrowingDate = borrowingDate;
        DateToBeReturnedBy = borrowingDate.plusDays(20);
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
