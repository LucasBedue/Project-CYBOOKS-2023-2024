package com.example.cybooks;

import java.util.Date;

public class Book {
    private int ISBN;
    private String Title;
    private Author Author;
    private Genre Genre;
    private Date PublishingDate;
    private String Edition;
    private boolean Available;

    /**
     * Constructor when all parameters are given
     * @param ISBN
     * @param title
     * @param author
     * @param genre
     * @param publishingDate
     * @param edition
     * @param available
     */

    public Book(int ISBN, String title, com.example.cybooks.Author author, com.example.cybooks.Genre genre, Date publishingDate, String edition, boolean available) {
        this.ISBN = ISBN;
        this.Title = title;
        this.Author = author;
        this.Genre = genre;
        this.PublishingDate = publishingDate;
        this.Edition = edition;
        this.Available = available;
    }

    /**
     * TEMPORARY ----------------------------------------------------------------
     * DATE NOT FUNCTIONAL
     * @param ISBN
     * @param title
     * @param author
     * @param genre
     * @param edition
     * @param available
     */
    public Book(int ISBN, String title, com.example.cybooks.Author author, com.example.cybooks.Genre genre, String edition, boolean available) {
        this.ISBN = ISBN;
        Title = title;
        Author = author;
        Genre = genre;
        Edition = edition;
        Available = available;
    }

    /**
     * Constructor when no edition is given
     * @param ISBN
     * @param title
     * @param author
     * @param genre
     * @param publishingDate
     * @param available
     */
    public Book(int ISBN, String title, com.example.cybooks.Author author, com.example.cybooks.Genre genre, Date publishingDate, boolean available) {
        this.ISBN = ISBN;
        this.Title = title;
        this.Author = author;
        this.Genre = genre;
        this.PublishingDate = publishingDate;
        this.Edition = "";
        this.Available = available;
    }

    /**
     * Constructor when availability is not given
     * By default these books will be set as available
     * @param ISBN
     * @param title
     * @param author
     * @param genre
     * @param publishingDate
     * @param edition
     */
    public Book(int ISBN, String title, com.example.cybooks.Author author, com.example.cybooks.Genre genre, Date publishingDate, String edition) {
        this.ISBN = ISBN;
        this.Title = title;
        this.Author = author;
        this.Genre = genre;
        this.PublishingDate = publishingDate;
        this.Edition = edition;
        this.Available = true;
    }

    /**
     * ISBN getter
     * @return this book's ISBN
     */
    public int getISBN() {
        return this.ISBN;
    }

    /**
     * Title getter
     * @return this book's title
     */
    public String getTitle() {
        return this.Title;
    }

    /**
     * Publishing date getter
     * @return this book's publishing date
     */
    public Date getPublishingDate() {
        return this.PublishingDate;
    }

    /**
     * Edition getter
     * @return this book's edition
     */
    public String getEdition() {
        return this.Edition;
    }

    /**
     * Availability getter
     * @return this book's availability
     */
    public boolean isAvailable() {
        return this.Available;
    }

    /**
     * Author getter
     * @return this book's author
     */
    public com.example.cybooks.Author getAuthor() {
        return this.Author.getAuthor();
    }

    /**
     * Genre getter
     * @return this book's genre
     */

    public Genre getGenre() {
        return this.Genre;
    }

    /**
     * Function to verify if a chosen book can be borrowed and if so setting it as borrowed
     * @return true if the book is borrowable and set as borrowed or false if the book is not currently available
     */
    public boolean Borrow(){
        if (this.Available == true){
            this.Available = false;
            System.out.println("This book is available ! Enjoy your reading ");
            return true;
        } else {
            System.out.println("This book isn't currently available");
            return false;
        }
    }

    /**
     * Function to set a returned book as available
     */
    public void Return(){
        this.Available = true;
    }

    /**
     * Function to return this book
     * @return this book
     */
    public Book getBook(){
        return this;
    }

    @Override
    public String toString(){
        return "This book is " + this.Title + " written by " + (Author) this.Author + " and it's genre is " + (Genre) this.getGenre();
    }
}
