package com.example.cybooks;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            Analyze(response.toString());
            return response.toString();
        } else {
            System.out.println("HTTP Error: " + responseCode);
            return null;
        }
    }


    private List<Book> Analyze(String text) {
        List<Book> books = new ArrayList<>();
        List<Integer> separator = new ArrayList<>();
        String text1 = text.replaceAll("[<>]", "\n");
        String[] tab = text1.split("\n");
        int i;
        for (i = 0; i < tab.length; i++) {
            if (tab[i].trim().equals("srw:recordData")) {
                separator.add(i);
                while (i < tab.length && !tab[i].trim().equals("/srw:recordData")) {
                    i++;
                }
                if (i < tab.length) {
                    separator.add(i);
                }
            }
        }


        for (i = 0; i < separator.size(); i += 2) {
            String record = extractText(text1, separator.get(i), separator.get(i + 1));
            
            Book book = transfobook(record);

            if (book != null) {
                books.add(book);
            }

        }
        System.out.println(books);
        return books;
    }

    private Book transfobook(String text) {

        String[] tab = text.split("\n");
        boolean book = false;
        boolean Bisbn = false;
        String ISBN = null;
        String title = null;
        String edit = "/";
        String lastName = null;
        String firstName = null;
        int publishingDate = 9999;
        int dateOfBirth = 9999;

        for (int i = 0; i < tab.length; i++) {

            if (tab[i].trim().equals("mxc:datafield tag=\"010\" ind1=\" \" ind2=\" \"")) {
                if (tab[i + 2].trim().equals("mxc:subfield code=\"a\"")) {
                    ISBN = tab[i + 3].trim();
                    Bisbn = true;
                }
            }

            if (tab[i].trim().equals("mxc:datafield tag=\"200\" ind1=\"1\" ind2=\" \"")) {
                book = false;
                while (!tab[i].trim().equals("/mxc:datafield")) {
                    i++;
                    if (tab[i].trim().equals("mxc:subfield code=\"b\"")) {
                        if (tab[i + 1].trim().equals("Texte imprimé") && Bisbn) {
                            book = true;
                        }
                    } else if (tab[i].trim().equals("mxc:subfield code=\"a\"")) {
                        title = tab[i + 1].trim();
                    }
                }
            } else if (tab[i].trim().equals("mxc:datafield tag=\"210\" ind1=\" \" ind2=\" \"")) {
                while (!tab[i].trim().equals("/mxc:datafield")) {
                    i++;
                    if (tab[i].trim().equals("mxc:subfield code=\"c\"")) {
                        edit = tab[i + 1].trim();
                        lastName = edit;
                        firstName = "/";
                    } else if (tab[i].trim().equals("mxc:subfield code=\"d\"")) {
                        String date = tab[i + 1].trim();
                        String regex = "[0-9]+";
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(date);
                        if (matcher.matches()) {
                            publishingDate = Integer.parseInt(date);
                        }
                    }
                }
            } else if (tab[i].trim().equals("mxc:datafield tag=\"700\" ind1=\" \" ind2=\"|\"")) {
                while (!tab[i].trim().equals("/mxc:datafield")) {
                    i++;
                    if (tab[i].trim().equals("mxc:subfield code=\"a\"")) {
                        lastName = tab[i + 1].trim();
                    } else if (tab[i].trim().equals("mxc:subfield code=\"b\"")) {
                        firstName = tab[i + 1].trim();
                    } else if (tab[i].trim().equals("mxc:subfield code=\"f\"")) {
                        String dobString = tab[i + 1].trim();
                        String[] dobParts = dobString.split("-");
                        if (dobParts.length > 0) {
                            dateOfBirth = Integer.parseInt(dobParts[0]);
                        }
                    }
                }
            }
        }

        if (book && Bisbn && ISBN != null && title != null && edit != null && lastName != null && firstName != null) {
            Genre genre = new Genre("DefaultGenre");
            Author author = new Author(lastName, firstName, "", "", " ", LocalDate.of(dateOfBirth, 1, 1));
            return new Book(ISBN, title, author, genre, LocalDate.of(publishingDate, 1, 1), edit, true);
        } else {
            return null;
        }
    }

    public static String extractText(String text, int startLine, int endLine) {
        String[] lines = text.split("\n");
        StringBuilder extractedText = new StringBuilder();

        if (startLine < 0 || endLine >= lines.length || startLine > endLine) {
            throw new IllegalArgumentException("Invalid line numbers.");
        }

        for (int i = startLine; i <= endLine; i++) {
            extractedText.append(lines[i]).append("\n");
        }

        return extractedText.toString();
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

            String finalQuery = fullQuery.toString().trim();
            if (finalQuery.startsWith("and")) {
                finalQuery = finalQuery.substring(4); // 4 char avec " and"
            }

            String encodedQuery = URLEncoder.encode(finalQuery, "UTF-8");

            return executeQuery(encodedQuery);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}