package com.example.cybooks;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Librarian extends Person {

    private List<User> users;

    /**
     * Constructor for a librarian with all fields given

     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     * @param DOB
     */
    public Librarian(String lastName, String firstName, String mail, double telephone, String address, LocalDate DOB) {
        super(lastName, firstName, mail, telephone, address, DOB);
        this.users = new ArrayList<>();
    }

    /**
     * Function to register an user to the list
     * @param user
     */
    public void UserRegistration(User user) {
        users.add(user);
        System.out.println("New user registered: " + user.getFirstName() + " " + user.getLastName());
    }

    /**
     * Function to print out the list of users
     */
    public void UserList() {

        System.out.println("List of Users:");
        for (User user : users) {
            System.out.println(user.getFirstName() + " " + user.getLastName());
        }
    }
    /**
     * Function search and print out a User thanks to is ID
     * @param ID of the user
    */
    public void lookForUserByID(int id){
        for (User user : users){
            if(user.getID()==id ){
                System.out.println(user);
            }
        }
    }

    /**
     * Function search and print out a User thanks to is First Name
     * @param first name of the user
    */
    public void lookForUserByFirstName(String FirstName){
        List<User> LookByName = null;
        for (User user : users) {
            if (FirstName.equalsIgnoreCase(user.getFirstName())) {
                System.out.println(user);
            }
        }
        System.out.println("There is no more people with the name "+ FirstName);
    }

    /**
     * Function search and print out a User thanks to is Last Name
     * @param last name of the user
    */
    public void lookForUserByLastName(String lastName) {
        for (User user : users) {
            if (lastName.equalsIgnoreCase(user.getLastName())) {
                System.out.println(user);
                System.out.println();
            }
        }
        System.out.println("There is no more people with the name "+ lastName);
    }
}