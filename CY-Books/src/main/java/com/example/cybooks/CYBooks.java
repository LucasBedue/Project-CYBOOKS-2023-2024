package com.example.cybooks;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.cert.CRLException;
import java.time.LocalDate;
import java.time.Month;

public class CYBooks extends Application {


    @FXML
    private Stage stage;
    @FXML
    private BorderPane rootLayout = new BorderPane();

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        /**
         * set the root of the application
         */
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(CYBooks.class.getResource("RootLayout.fxml"));
        rootLayout = (BorderPane) fxmlLoader.load();
        rootLayout.setCenter(createMainMenu());

        Scene scene = new Scene(rootLayout);
        stage.setTitle("CY-Books");
        stage.setScene(scene);
        stage.show();


    }

    /**
     * ²To regroup given books in a list
     */
    private ObservableList<Book> BookData = FXCollections.observableArrayList();
    private ObservableList<User> UserData = FXCollections.observableArrayList();

    public Node createMainMenu(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
            AnchorPane MainMenu = (AnchorPane) loader.load();
            MainMenuController MainController = loader.getController();
            MainController.setCYBooks(this);

            return MainMenu;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Node createBookScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CYBooks.fxml"));
            AnchorPane BookOverview = (AnchorPane) loader.load();
            BookOverviewController BookController = loader.getController();
            BookController.setCYBooks(this);
            return BookOverview;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Node createUserScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Users.fxml"));
            AnchorPane UserOverview = (AnchorPane) loader.load();
            UserOverviewController UserController = loader.getController();
            UserController.setCYBooks(this);
            return UserOverview;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void switchMainMenuScene() {
        rootLayout.setCenter(createMainMenu());
    }
    @FXML
    public void switchBookScene() {
        rootLayout.setCenter(createBookScene());
    }

    @FXML
    public void switchUserScene() {
        rootLayout.setCenter(createUserScene());
    }


    /**
     * Constructor
     * TEMPORARILY USED TO SET DUMMY VALUES
     */
    public CYBooks(){
        Author Fontaine = new Author("de la Fontaine","Jean","ui",26579102,"France",LocalDate.of(1724,12,11),LocalDate.of(1824,12,11));
        Genre Conte = new Genre("Conte");
        BookData.add(new Book(3856226,"Corbeau & Renard", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true));
        BookData.add(new Book(3856226,"Cigalle et la Fourmi", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true));
        BookData.add(new Book(3856226,"Lapin et la Tortue", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true));
    }

    /**
     * Return the list of books
     * @return the list of books
     */
    public ObservableList<Book> getBookData() {
        return BookData;
    }
    public ObservableList<User> getUserData() {
        return UserData;
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
