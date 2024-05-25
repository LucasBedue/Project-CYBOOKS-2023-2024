package com.example.cybooks;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Request request = new Request();

        Search query = new Search.Builder()
                .setAuthor("Victor")
                .setStartRecord(20)
                .build();
        List<Book> booksToTreat=new ArrayList<Book>();
        booksToTreat = request.search(query);
        //System.out.println(booksToTreat);
        System.out.println("\nSearch by query:");

    }

}