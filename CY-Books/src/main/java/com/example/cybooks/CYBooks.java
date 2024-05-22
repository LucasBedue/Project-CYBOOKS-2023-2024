package com.example.cybooks;

import com.example.cybooks.controllers.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
    private ObservableList<Borrow> BorrowData = FXCollections.observableArrayList();
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
    public Node createBookViewScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BorrowedBooks.fxml"));
            AnchorPane BookOverview = (AnchorPane) loader.load();
            BorrowedBooksController BookController = loader.getController();
            BookController.setCYBooks(this);
            return BookOverview;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Node createBookSearchScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BookSearch.fxml"));
            AnchorPane BookSearchOverview = (AnchorPane) loader.load();
            BookSearchController BookSearchController = loader.getController();
            BookSearchController.setCYBooks(this);
            return BookSearchOverview;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Node createMostBorrowedBooksScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MostBorrowed.fxml"));
            AnchorPane MostBorrowedOverview = (AnchorPane) loader.load();
            MostBorrowedController MostBorrowedController = loader.getController();
            MostBorrowedController.setCYBooks(this);
            return MostBorrowedOverview;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Node createLateReturnsBooksScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LateReturns.fxml"));
            AnchorPane LateReturnsOverview = (AnchorPane) loader.load();
            LateReturnsController LateReturnsController = loader.getController();
            LateReturnsController.setCYBooks(this);
            return LateReturnsOverview;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Node createUserViewScene(){
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
    public Node createUserSearchViewScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UserSearch.fxml"));
            AnchorPane UserSearchOverview = (AnchorPane) loader.load();
            UserSearchController UserSearchController = loader.getController();
            UserSearchController.setCYBooks(this);
            return UserSearchOverview;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Node createCheckUserScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CheckUser.fxml"));
            AnchorPane CheckUserOverview = (AnchorPane) loader.load();
            CheckUserController CheckUserController = loader.getController();
            CheckUserController.setCYBooks(this);
            return CheckUserOverview;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Node createSearchToModifyScene(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SearchToModifyUser.fxml"));
            AnchorPane SearchToModifyOverview = (AnchorPane) loader.load();
            SearchToModifyController SearchToModifyController = loader.getController();
            SearchToModifyController.setCYBooks(this);
            return SearchToModifyOverview;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Node createRegisterUserScene() throws RuntimeException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegisterUser.fxml"));
            AnchorPane RegisterUserOverview = (AnchorPane) loader.load();
            RegisterUserController RegisterUserController = loader.getController();
            RegisterUserController.setCYBooks(this);
            return RegisterUserOverview;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void switchMainMenuScene() {
        rootLayout.setCenter(createMainMenu());
    }
    @FXML
    public void switchBookViewScene() {
        rootLayout.setCenter(createBookViewScene());
    }
    @FXML
    public void switchBookSearchScene() {
        rootLayout.setCenter(createBookSearchScene());
    }
    @FXML
    public void switchMostBorrowedBooksScene() {
        rootLayout.setCenter(createMostBorrowedBooksScene());
    }
    @FXML
    public void switchLateReturnsBooksScene() {
        rootLayout.setCenter(createLateReturnsBooksScene());
    }
    @FXML
    public void switchUserViewScene() {
        rootLayout.setCenter(createUserViewScene());
    }
    @FXML
    public void switchUserSearchScene() {
        rootLayout.setCenter(createUserSearchViewScene());
    }
    @FXML
    public void switchCheckUserScene() {
        rootLayout.setCenter(createCheckUserScene());
    }
    @FXML
    public void switchSearchToModifyScene() {
        rootLayout.setCenter(createSearchToModifyScene());
    }
    @FXML
    public void switchRegisterUserScene() {
        try{
            rootLayout.setCenter(createRegisterUserScene());

        }
        catch(RuntimeException e){
            System.out.println(e.toString());
        }
    }


    /**
     * Constructor
     * TEMPORARILY USED TO SET DUMMY VALUES
     */
    public CYBooks(){

        Author Fontaine = new Author("de la Fontaine","Jean","ui","26579102","France",LocalDate.of(1724,12,11),LocalDate.of(1824,12,11));
        Genre Conte = new Genre("Conte");

        Book book1 = new Book(3856226,"Corbeau & Renard", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true);

        System.out.println(book1.toString());

        User u1 = new User("Galisson","Matthias","ui@ui.com","52202336","ui",LocalDate.of(1700, 01, 01));

        Borrow borrow1 = new Borrow(LocalDate.now(), u1, book1);
        UserData.add(u1);
        BookData.add(borrow1.getBook());
        BorrowData.add(borrow1);


    }

    /**
     * Return the list of books
     * @return the list of books
     */
    public ObservableList<Book> getBookData() {
        return BookData;
    }

    public ObservableList<Borrow> getBorrowData() {
        return BorrowData;
    }
    public ObservableList<User> getUserData() {
        return UserData;
    }

    /**
     * to make room for another page of users of books to show.
     */
    public void emptyBookData(){
        this.BookData.clear();
    }
    public void emptyUserData(){
        this.UserData.clear();
    }

    /**
     * to add a User in the list of user
     */
    public void addUser(User user){
        this.UserData.add(user);
    }
    /**
     * to add a Book in the list of book
     */
    public void addBook(Book book){
        this.BookData.add(book);
    }


    /**
     * The program starts here
     * @param args
     */
    public static void main(String[] args) {

        LocalDate Today = LocalDate.now();

        Genre Conte = new Genre("Conte");
        Author Fontaine = new Author("de la Fontaine","Jean","ui","26579102","France",LocalDate.of(1724,12,11),LocalDate.of(1824,12,11));
        Book book1 = new Book(3856226,"Corbeau & Renard", Fontaine, Conte,LocalDate.of(1700, 01, 01), "1ST",true);

        System.out.println(book1.toString());

        User u1 = new User("Galisson","Matthias","ui@ui.com","52202336","ui",LocalDate.of(1700, 01, 01));

        Borrow borrow1 = new Borrow(LocalDate.now(), u1, book1);
        
        u1.BorrowBook(borrow1);
        System.out.println("Current Borrows: " + u1.getCurrentBorrows().size());
        System.out.println("Borrow History: " + u1.getBorrowHistory().size());


        /**
         * User returns the book
         */
        u1.GiveBack(borrow1);
        System.out.println("Book returned successfully.");}

        /**
         * Print current borrows and history
         */
        System.out.println("Current Borrows: " + u1.getCurrentBorrows().size());
        System.out.println("Borrow History: " + u1.getBorrowHistory().size());

        try {
            SQLExecutor sqlExecutor = new SQLExecutor("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/Cy_Books_Database", "root", "");
            sqlExecutor.executeFile("./CY-Books/src/main/resources/com/example/cybooks/BDDCreation.sql");
          /**
             * if issues arise with the display put launch in commentary
             */
            launch();
        }
        catch(Exception e){
            e.printStackTrace();

        }
    }
}