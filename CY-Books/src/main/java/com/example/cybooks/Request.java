package com.example.cybooks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Request {

    /** Base URL of the BNF API. */
    private final String baseUrl = "http://catalogue.bnf.fr/api/SRU?version=1.2&operation=searchRetrieve&query=";

    /** Default constructor for the Request class. */
    public Request() {

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
            // prends ce fichier et transforme en nombre de livre nécessaire
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

    /**
     * Separates a string into a list of strings based on a separator.
     *
     * @param inputString The input string to be separated.
     * @param separator   The separator used for splitting the input string.
     * @return A list of strings after splitting the input string.
     */
    private List<String> separateString(String inputString, String separator) {
        List<String> separatedList = new ArrayList<>();

        if (inputString != null && !inputString.isEmpty() && separator != null) {
            String[] parts = inputString.split(separator);
            for (String part : parts) {
                separatedList.add(part.trim());
            }
        }

        return separatedList;
    }

    /* il faut faire la crea booking en fct de ce que t'as dans le fichier*/

    /**
     * Separates a string into a list of strings based on a separator.
     *
     * @param inputString The input string to be separated.
     * @param separator   The separator used for splitting the input string.
     * @return A list of strings after splitting the input string.
     */
    private List<String> separateRecords(String inputString, String separator) {
        List<String> separatedList = new ArrayList<>();

        if (inputString != null && !inputString.isEmpty() && separator != null) {
            String[] parts = inputString.split(separator);
            for (String part : parts) {
                separatedList.add(part.trim());
            }
        }

        return separatedList;
    }

    /**
     * Extracts a value from a source string between start and end tags.
     *
     * @param source  The input string to extract value from.
     * @param startTag The start tag marking the beginning of the value.
     * @param endTag   The end tag marking the end of the value.
     * @return The extracted value from the source string.
     */
    private String extractValue(String source, String startTag, String endTag) {
        int startIndex = source.indexOf(startTag);
        int endIndex = source.indexOf(endTag, startIndex + startTag.length());
        if (startIndex != -1 && endIndex != -1) {
            return source.substring(startIndex + startTag.length(), endIndex);
        }
        return "";
    }



}


