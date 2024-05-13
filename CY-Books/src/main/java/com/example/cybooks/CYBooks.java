package com.example.cybooks;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class CYBooks extends Application {

    private Stage stage;
    private BorderPane rootLayout;
    private MenuButton SearchUser;
    private MenuButton SearchBook;
    private MenuButton CheckBorrowedBooks;
    private MenuButton CheckLateReturns;
    @Override
    public void start(Stage stage) throws IOException {
        /**
         * set the root of the application
         */
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(CYBooks.class.getResource("RootLayout.fxml"));
        rootLayout = (BorderPane) fxmlLoader.load();


        Scene scene = new Scene(rootLayout);
        stage.setTitle("CY-Books");
        stage.setScene(scene);

        /**
         * Scene to show the content for the books
         */
        Scene BookOverview = showBookOverview();
        //Scene UserOverview = showUserOverview();


        stage.show();



    }

    /**
     * To regroup given books in a list
     */
    private ObservableList<Book> bookData = FXCollections.observableArrayList();


    /**
     * Constructor
     * TEMPORARILY USED TO SET DUMMY VALUES
     */
    public CYBooks(){
        Author Fontaine = new Author("de la Fontaine","Jean","ui",26579102,"France",LocalDate.of(1724,12,11),LocalDate.of(1824,12,11));
        Genre Conte = new Genre("Conte");
        bookData.add(new Book(3856226,"Corbeau & Renard", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true));
        bookData.add(new Book(3856226,"Cigalle et la Fourmi", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true));
        bookData.add(new Book(3856226,"Lapin et la Tortue", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true));
    }

    /**
     * Return the list of books
     * @return the list of books
     */
    public ObservableList<Book> getBookData() {
        return bookData;
    }

    /**
     * To create the scene used to see the list of books and their information
     */
    public Scene showBookOverview(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CYBooks.class.getResource("CYBooks.fxml"));
            AnchorPane BookOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(BookOverview);

            BookOverviewController controller = loader.getController();


            //SearchUser.setOnAction(e -> showUserOverview() );

            controller.setCYBooks(this);

            return BookOverview.getScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rootLayout.getScene();
    }

    /**
     * To create the scene used to see the list of users and their information
     * NOT FUNCTIONAL
     *
    public Scene showUserOverview(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(CYBooks.class.getResource("Users.fxml"));
            AnchorPane UserOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(UserOverview);

            UserOverviewController controller = loader.getController();
            controller.setCYBooks(this);
            return UserOverview.getScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rootLayout.getScene();
    }
     */
    /**
     * Function to switch to a given scene
     * @param scene
     */
    public void switchScene(Scene scene){
        stage.setScene(scene);
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
         * if issues arise with the display put launch in commentary
         */
        launch();
    }
}
