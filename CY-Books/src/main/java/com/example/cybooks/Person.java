package com.example.cybooks;

import java.util.Date;

public abstract class Person {
    private int ID;
    private String LastName;
    private String FirstName;
    private String Mail;
    private double Phone;
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
    public Person(int ID, String lastName, String firstName, String mail, double phone, String address, Date DOB) {
        this.ID = generateUserID();
        this.LastName=lastName;
        this.FirstName=firstName;
        this.Mail = mail;
        this.Phone = phone;
        this.Address = address;
        this.DOB = DOB;
    }
    
    public Person(int ID, String lastName, String firstName, String mail, double phone, String address) {
        this.ID = generateUserID();
        this.LastName=lastName;
        this.FirstName=firstName;
        this.Mail = mail;
        this.Phone = phone;
        this.Address = address;
    }

    private int generateUserID() {
        return ++ID;
    }
    public int getID() {
		return ID;
	}
	public String getLastName() {
		return LastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public String getMail() {
		return Mail;
	}
	public double getphone() {
		return Phone;
	}
	public String getAdress() {
		return Address;
	}
	public Date getDOB() {	
		return DOB;
	}
}
