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

    // Private constructor to prevent direct instantiation
    Search() {}

    // Builder class for fluent construction
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

        public Search build() {
            return search;
        }
    }

    // Getters for each field
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
}
