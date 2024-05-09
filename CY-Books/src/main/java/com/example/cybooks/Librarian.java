package com.example.cybooks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Librarian extends Person {

    private List<User> users;

    /**
     * Constructor for a librarian with all fields given
     * @param ID
     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     * @param DOB
     */
    public Librarian(int ID, String lastName, String firstName, String mail, double telephone, String address, LocalDate DOB) {
        super(ID, lastName, firstName, mail, telephone, address, DOB);
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
}
