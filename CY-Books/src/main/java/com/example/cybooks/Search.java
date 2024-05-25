package com.example.cybooks;

/**
 * Represents a search query for books in the BNF catalogue.
 */
public class Search {
    private String title;
    private String isbn;
    private String genre;
    private String publisher;
    private int datePublishing;
    private String author;
    private int maximumRecords;
    private int startRecord;

    /**
     * Private constructor to prevent direct instantiation
     */
    Search() {}

    public static class Builder {
        private Search search;

        public Builder() {
            this.search = new Search();
        }

        public Builder setTitle(String title) {
            search.title = title;
            return this;
        }

        public Builder setIsbn(String isbn) {
            search.isbn = isbn;
            return this;
        }

        public Builder setGenre(String genre) {
            search.genre = genre;
            return this;
        }

        public Builder setPublisher(String publisher) {
            search.publisher = publisher;
            return this;
        }

        public Builder setDatePublishing(int datePublishing) {
            search.datePublishing = datePublishing;
            return this;
        }

        public Builder setAuthor(String author) {
            search.author = author;
            return this;
        }

        public Builder setMaximumRecords(int maximumRecords) {
            search.maximumRecords = maximumRecords;
            return this;
        }

        public Builder setStartRecord(int startRecord) {
            search.startRecord = startRecord;
            return this;
        }

        public Search build() {
            return search;
        }
    }

    /**
     * Getters for each field
     */
    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getDatePublishing() {
        return datePublishing;
    }

    public String getAuthor() {
        return author;
    }

    public int getMaximumRecords() {
        return maximumRecords;
    }

    public int getStartRecord() {
        return startRecord;
    }

    public void changeTitle(String s){
        this.title=s;
    }

    public void changeIsbn(String s) {
        this.isbn=s;
    }

    public void changeGenre(String s) {
        this.genre=s;    }

    public void changePublisher(String s) {
        this.publisher=s;    }

    public void changeDatePublishing(int s) {
        this.datePublishing=s;    }

    public void changeAuthor(String s) {
        this.author=s;    }

    public void changeMaximumRecords(int s) {
        this.maximumRecords=s;    }

    public void changeStartRecord(int s) {
        this.startRecord=s;
    }

}
