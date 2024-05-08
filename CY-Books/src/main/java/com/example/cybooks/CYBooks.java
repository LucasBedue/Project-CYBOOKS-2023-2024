package com.example.cybooks;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

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
        Genre Conte = new Genre("Conte");
        Author Fontaine = new Author(01,"de la Fontaine","Jean","ui",26579102,"France");
        Book book1 = new Book(3856226,"Corbeau & Renard", Fontaine, Conte, "1ST",true);
        book1.Borrow();
        book1.Borrow();
        book1.Return();
        book1.Borrow();
        System.out.println(book1.toString());
        //launch();
    }
}