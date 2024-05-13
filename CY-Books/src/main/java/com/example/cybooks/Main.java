package com.example.cybooks;

public class Main {

    public static void main(String[] args) {
     
        Request request = new Request();
        
        // exemple recherche title
        String title = "Java Programming";
        String responseByTitle = request.searchByTitle(title);
        System.out.println("Search by title '" + title + "':");
        System.out.println(responseByTitle);

        // exemple recherche ISBN
        String isbn = "9780134685991"; 
        String responseByISBN = request.searchByISBN(isbn);
        System.out.println("\nSearch by ISBN '" + isbn + "':");
        System.out.println(responseByISBN);

        // exemple recherche genre
        String genre = "Fiction";
        String responseByGenre = request.searchByGenre(genre);
        System.out.println("\nSearch by genre '" + genre + "':");
        System.out.println(responseByGenre);

        // exemple recherche edition
        String publisher = "Penguin Books";
        String responseByPublisher = request.searchByPublisher(publisher);
        System.out.println("\nSearch by publisher '" + publisher + "':");
        System.out.println(responseByPublisher);

        // exemple recherche date parution
        int date = 2020; // Change to a valid publishing date
        String responseByDatePublishing = request.searchByDatePublishing(date);
        System.out.println("\nSearch by publishing date '" + date + "':");
        System.out.println(responseByDatePublishing);

        // exemple recherche auteur         
        String author = "Mark Twain";
        String responseByAuthor = request.searchByAuthor(author);
        System.out.println("\nSearch by author '" + author + "':");
        System.out.println(responseByAuthor);

        // exemple du multi search multi 
        Search query = new Search.Builder()
                .setAuthor("Hugo")
                .build();
        String responseByQuery = request.search(query);
        System.out.println("\nSearch by query:");
        System.out.println(responseByQuery);
    }
}