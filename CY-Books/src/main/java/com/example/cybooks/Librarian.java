package com.example.cybooks;

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
     */
    public void lookForUserByID(int id){
        for (User user : users){
            if( user.getID()==id ){
                System.out.println(user);
            }
        }
    }

    /**
     * Function search and print out a User thanks to is First Name
     */
    public void lookForUserByFirstName(String FirstName){
        List<User> LookByName = null;
        for (User user : users){
            if (user.getFirstName()==FirstName){
                LookByName.add(user);
            }
        }
        for (User user : LookByName) {
            System.out.println(user);
        }
    }

    /**
     * Function search and print out a User thanks to is Last Name
     */
    public void lookForUserByLastName(String LastName){
        List<User> LookByName = null;
        for (User user : users){
            if (user.getLastName()==LastName){
                LookByName.add(user);
            }
        }
        for (User user : LookByName) {
            System.out.println(user);
        }
    }

    /**
     * Function to change the last name of a user
     */
    public void changeLastName(User client, StringProperty LastName){
        client.setLastName(LastName);
    }

    /**
     * Function to change the first name of a user
     */
    public void changeLastName(User client, StringProperty FirstName){
        client.setLastName(FirstName);
    }

    /**
     * Function to change the address of a user
     */
    public void changeAddress(User client, StringProperty Address){
        client.setAddress(Address);
    }

    /**
     * Function to change the phone number of a user
     */
    public void changePhone(User client, DoubleProperty Phone){
        client.setPhone(Phone);
    }

    /**
     * Function to change the mail of a user
     */
    public void changeMail(User client, DoubleProperty Mail){
        client.setMail(Mail);
    }
}