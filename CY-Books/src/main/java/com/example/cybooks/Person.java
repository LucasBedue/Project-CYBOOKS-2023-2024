package com.example.cybooks;

import java.util.Date;

public abstract class Person {
    private int ID;
    private String LastName;
    private String FirstName;
    private String Mail;
    private double Telephone;
    private String Address;
    private Date DOB;

    /**
     * Constructor for any person
     * @param ID
     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     * @param DOB
     */
    public Person(int ID, String lastName, String firstName, String mail, double telephone, String address, Date DOB) {
        this.ID = ID;
        this.LastName = lastName;
        this.FirstName = firstName;
        this.Mail = mail;
        this.Telephone = telephone;
        this.Address = address;
        this.DOB = DOB;
    }

    /**
     * TEMPORARY ---------------------------------------------------------------------------------
     * DATE NOT FIGURED OUT YET
     * @param ID
     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     */
    public Person(int ID, String lastName, String firstName, String mail, double telephone, String address) {
        this.ID = ID;
        LastName = lastName;
        FirstName = firstName;
        Mail = mail;
        Telephone = telephone;
        Address = address;
    }
}
