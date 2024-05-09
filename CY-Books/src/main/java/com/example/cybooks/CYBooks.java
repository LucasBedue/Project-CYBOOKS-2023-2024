package com.example.cybooks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class CYBooks extends Application {
	
	
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CYBooks.class.getResource("CYBooks.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("CY-Books");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        LocalDate Today = LocalDate.now();
        Genre Conte = new Genre("Conte");
        Author Fontaine = new Author(01,"de la Fontaine","Jean","ui",26579102,"France",LocalDate.of(1724,12,11),LocalDate.of(1824,12,11));
        Book book1 = new Book(3856226,"Corbeau & Renard", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true);
        book1.Borrow();
        book1.Borrow();
        book1.Return();
        book1.Borrow();
        System.out.println(book1.toString());

        Borrow newborrow = new Borrow(LocalDate.of(2024,12,1));
        newborrow.Return(LocalDate.of(2024,12,11));
        newborrow.Return(LocalDate.of(2024,12,21));
        newborrow.Return(LocalDate.of(2024,12,22));
        //launch();
    }
}
