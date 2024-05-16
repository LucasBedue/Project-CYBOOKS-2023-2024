package com.example.cybooks;

public class Main {

    public static void main(String[] args) {

        Request request = new Request();

        // exemple du multi search multi
        Search query = new Search.Builder()
                .setAuthor("Hugo")
                .build();
        String responseByQuery = request.search(query);
        System.out.println("\nSearch by query:");
        System.out.println(responseByQuery);

    }

}