package com.example.cybooks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Request {

    /** Base URL of the BNF API. */
    private final String baseUrl = "http://catalogue.bnf.fr/api/SRU?version=1.2&operation=searchRetrieve&query=";

    /** Default constructor for the Request class. */
    public Request() {

    }

    /**
     * Searches for a book by title in the BNF catalogue.
     * 
     * @param title The title of the book to search for.
     * @return The HTTP response.
     */
    public String searchByTitle(String title) {
        try {
            String query = "(bib.title all \"" + title + "\")";
            return executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Searches for a book by ISBN in the BNF catalogue.
     * 
     * @param isbn The ISBN of the book to search for.
     * @return The HTTP response.
     */
    public String searchByISBN(String isbn) {
        try {
            String query = "(bib.isbn all \"" + isbn + "\")";
            return executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Searches for a book by genre in the BNF catalogue.
     *
     * @param genre The genre of the book to search for.
     * @return The HTTP response.
     */
    public String searchByGenre(String genre) {
        try {
            String query = "(bib.genre all \"" + genre + "\")";
            return executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }	
    
    /**
     * Searches for a book by publisher in the BNF catalogue.
     *
     * @param publisher The publisher of the book to search for.
     * @return The HTTP response.
     */
    public String searchByPublisher(String publisher) {
        try {
            String query = "(bib.publisher all \"" + publisher + "\")";
            return executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Searches for a book by publishing date in the BNF catalogue.
     *
     * @param date The publishing date of the book to search for.
     * @return The HTTP response.
     */
    public String searchByDatePublishing(int date) {
        try {
            String query = "(bib.date all \"" + date + "\")";
            return executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Searches for a book by author in the BNF catalogue.
     * 
     * @param author The author of the book to search for.
     * @return The HTTP response.
     */
    public String searchByAuthor(String author) {
        try {
            String query = "(bib.author all \"" + author + "\")";
            return executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Executes an HTTP request to the BNF API and retrieves the response.
     * 
     * @param query The query to execute.
     * @return The HTTP response.
     * @throws Exception If an error occurs during the request execution.
     */
    private String executeQuery(String query) throws Exception {
        String encodedQuery = URLEncoder.encode(query, "UTF-8");
        String apiUrl = baseUrl + encodedQuery;

        System.out.println("\n" + apiUrl);
        
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            System.out.println("HTTP Error: " + responseCode);
            return null;
        }
    }
    
    public String search(Search query) {
        try {
            StringBuilder fullQuery = new StringBuilder();

            // Build the full query based on the provided search criteria
            if (query.getTitle() != null) {
                fullQuery.append("bib.title adj \"").append(query.getTitle()).append("\" ");
            }
            if (query.getIsbn() != null) {
                fullQuery.append("and bib.isbn adj \"").append(query.getIsbn()).append("\" ");
            }
            if (query.getGenre() != null) {
                fullQuery.append("and bib.genre adj \"").append(query.getGenre()).append("\" ");
            }
            if (query.getPublisher() != null) {
                fullQuery.append("and bib.publisher adj \"").append(query.getPublisher()).append("\" ");
            }
            if (query.getDatePublishing() != 0) {
                fullQuery.append("and bib.date adj \"").append(query.getDatePublishing()).append("\" ");
            }
            if (query.getAuthor() != null) {
                fullQuery.append("and bib.author adj \"").append(query.getAuthor()).append("\" ");
            }

            // Remove leading "and" if present
            String finalQuery = fullQuery.toString().trim();
            if (finalQuery.startsWith("and")) {
                finalQuery = finalQuery.substring(4); // 4 char avec " and"
            }

            // Encode the query part
            String encodedQuery = URLEncoder.encode(finalQuery, "UTF-8");


            // Execute the combined query
            return executeQuery(encodedQuery);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}


