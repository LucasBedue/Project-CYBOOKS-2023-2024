package com.example.cybooks;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class CYBooks extends Application {

    private BorderPane rootLayout;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(CYBooks.class.getResource("RootLayout.fxml"));
        rootLayout = (BorderPane) fxmlLoader.load();


        Scene scene = new Scene(rootLayout);
        stage.setTitle("CY-Books");
        stage.setScene(scene);
        stage.show();
        showBookOverview();
    }

    private ObservableList<Book> bookData = FXCollections.observableArrayList();

    public CYBooks(){
        Author Fontaine = new Author("de la Fontaine","Jean","ui",26579102,"France",LocalDate.of(1724,12,11),LocalDate.of(1824,12,11));
        Genre Conte = new Genre("Conte");
        bookData.add(new Book(3856226,"Corbeau & Renard", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true));
        bookData.add(new Book(3856226,"Cigalle et la Fourmi", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true));
        bookData.add(new Book(3856226,"Lapin et la Tortue", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true));
    }

    public ObservableList<Book> getBookData() {
        return bookData;
    }

    public void showBookOverview(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CYBooks.class.getResource("CYBooks.fxml"));
            AnchorPane BookOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(BookOverview);

            BookOverviewController controller = loader.getController();
            controller.setCYBooks(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        LocalDate Today = LocalDate.now();
        Genre Conte = new Genre("Conte");
        Author Fontaine = new Author("de la Fontaine","Jean","ui",26579102,"France",LocalDate.of(1724,12,11),LocalDate.of(1824,12,11));
        Book book1 = new Book(3856226,"Corbeau & Renard", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true);
        book1.Borrow();
        book1.Borrow();
        book1.Return();
        book1.Borrow();
        System.out.println(book1.toString());

        Borrow newborrow = new Borrow(LocalDate.of(2024,12,1),Fontaine, book1);
        newborrow.Return(LocalDate.of(2024,12,11));
        newborrow.Return(LocalDate.of(2024,12,21));
        newborrow.Return(LocalDate.of(2024,12,22));


        /**
         * if issues arise with fxml put launch in commentary
         */
        launch();
    }
}
