package com.example.cybooks;

import javafx.beans.property.*;

import java.time.LocalDate;


public class Book {

    private IntegerProperty Id;
    private StringProperty ISBN;
    private StringProperty Title;
    private ObjectProperty<Author> Author;
    private ObjectProperty<Genre> Genre;
    private ObjectProperty<LocalDate> PublishingDate;
    private StringProperty Edition;
    private BooleanProperty Available;

    /**
     * Constructor when all parameters are given
     * @param ISBN Book's ISBN
     * @param title Book's Title
     * @param author Book's Author
     * @param genre Book's Genre
     * @param publishingDate Book's Publishing Date
     * @param edition Book's Edition
     * @param available Book's Availability
     */

    public Book(String ISBN, String title, com.example.cybooks.Author author, com.example.cybooks.Genre genre, LocalDate publishingDate, String edition, boolean available) {
        this.ISBN = new SimpleStringProperty(ISBN);
        this.Title = new SimpleStringProperty(title);
        this.Author = new SimpleObjectProperty<Author>(author);
        this.Genre = new SimpleObjectProperty<Genre>(genre);
        this.PublishingDate = new SimpleObjectProperty<LocalDate>(publishingDate);
        this.Edition = new SimpleStringProperty(edition);
        this.Available = new SimpleBooleanProperty(available);
    }


    /**
     * Constructor when no edition is given
     * @param ISBN Book's ISBN
     * @param title Book's Title
     * @param author Book's Author
     * @param genre Book's Genre
     * @param publishingDate Book's Publishing Date
     * @param available Book's Availability
     */
    public Book(String ISBN, String title, com.example.cybooks.Author author, com.example.cybooks.Genre genre, LocalDate publishingDate, boolean available) {
        this.ISBN = new SimpleStringProperty(ISBN);
        this.Title = new SimpleStringProperty(title);
        this.Author = new SimpleObjectProperty<Author>(author);
        this.Genre = new SimpleObjectProperty<Genre>(genre);
        this.PublishingDate = new SimpleObjectProperty<LocalDate>(publishingDate);
        this.Edition = this.Edition = new SimpleStringProperty("");
        this.Available = new SimpleBooleanProperty(available);
    }

    /**
     * Constructor when availability is not given
     * By default these books will be set as available
     * @param ISBN Book's ISBN
     * @param title Book's Title
     * @param author Book's Author
     * @param genre Book's Genre
     * @param publishingDate Book's Publishing Date
     * @param edition Book's Edition
     */
    public Book(String ISBN, String title, com.example.cybooks.Author author, com.example.cybooks.Genre genre, LocalDate publishingDate, String edition) {
        this.ISBN = new SimpleStringProperty(ISBN);
        this.Title = new SimpleStringProperty(title);
        this.Author = new SimpleObjectProperty<Author>(author);
        this.Genre = new SimpleObjectProperty<Genre>(genre);
        this.PublishingDate = new SimpleObjectProperty<LocalDate>(publishingDate);
        this.Edition = new SimpleStringProperty(edition);
        this.Available = new SimpleBooleanProperty(true);
    }

    /**
     * ISBN getter
     * @return this book's ISBN
     */
    public String getISBN() {
        return this.ISBN.get();
    }

    public StringProperty ISBNProperty() {
        return this.ISBN;
    }

    public void setISBN(String ISBN){
        this.ISBN.set(ISBN);
    }


    /**
     * Title getter
     * @return this book's title
     */
    public String getTitle() {
        return this.Title.get();
    }

    public StringProperty TitleProperty() {
        return this.Title;
    }

    public void setTitle(String Title){
        this.Title.set(Title);
    }

    /**
     * Publishing date getter
     * @return this book's publishing date
     */

    public LocalDate getPublishingDate() {
        return this.PublishingDate.get();
    }

    public ObjectProperty<LocalDate> PublishingProperty() {
        return this.PublishingDate;
    }

    public void setPublishingDate(LocalDate PublishingDate) {
        this.PublishingDate.set(PublishingDate);
    }

    /**
     * Edition getter
     * @return this book's edition
     */

    public String getEdition() {
        return this.Edition.get();
    }

    public StringProperty EditionProperty() {
        return this.Edition;
    }

    public void setEdition(String Edition) {
        this.Edition.set(Edition);
    }
    /**
     * Availability getter
     * @return this book's availability
     */

    public boolean isAvailable() {
        return this.Available.get();
    }

    public BooleanProperty AvailableProperty() {
        return this.Available;
    }

    public void setAvailable(boolean Available) {
        this.Available.set(Available);
    }

    /**
     * Author getter
     * @return this book's author
     */

    public Author getAuthor() {
        return this.Author.get();
    }

    public ObjectProperty<Author> AuthorProperty() {
        return this.Author;
    }

    public void setAuthor(Author Author) {
        this.Author.set(Author);
    }

    /**
     * Genre getter
     * @return this book's genre
     */

    public Genre getGenre() {
        return this.Genre.get();
    }

    public ObjectProperty<Genre> GenreProperty() {
        return this.Genre;
    }

    public void setGenre(Genre Genre) {
        this.Genre.set(Genre);
    }


    /**
     * Function to verify if a chosen book can be borrowed and if so setting it as borrowed
     * @return true if the book is borrowable and set as borrowed or false if the book is not currently available
     */
    public boolean Borrow(){
        if (this.Available.get() == true){
            this.Available.set(false);
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
        this.Available.set(true);
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
        return "This book is " + this.Title.getName() + " written by " + this.Author.get().getFirstName() + " " + this.Author.get().getLastName() + " , its genre is " + this.Genre.get().getGenre() + " , it came out in " + this.PublishingDate.get();
    }
}
