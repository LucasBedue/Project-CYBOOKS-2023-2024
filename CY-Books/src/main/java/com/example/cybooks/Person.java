package com.example.cybooks;

import java.time.LocalDate;
import java.util.Date;

public abstract class Person {
    private int ID;
    private String LastName;
    private String FirstName;
    private String Mail;
    private double Phone;
    private String Address;
    private LocalDate DOB;

    /**
     * Constructor for any person
     * @param ID
     * @param lastName
     * @param firstName
     * @param mail
     * @param phone
     * @param address
     * @param DOB
     */
    public Person(int ID, String lastName, String firstName, String mail, double phone, String address, LocalDate DOB) {
        this.ID = generateUserID();
        this.LastName=lastName;
        this.FirstName=firstName;
        this.Mail = mail;
        this.Phone = phone;
        this.Address = address;
        this.DOB = DOB;
    }

    /**
     * Constructor with no date of birth
     * @param ID
     * @param lastName
     * @param firstName
     * @param mail
     * @param phone
     * @param address
     */
    public Person(int ID, String lastName, String firstName, String mail, double phone, String address) {
        this.ID = generateUserID();
        this.LastName=lastName;
        this.FirstName=firstName;
        this.Mail = mail;
        this.Phone = phone;
        this.Address = address;
    }

    /**
     * User ID generator
     * @return user ID
     */
    private int generateUserID() {
        return ++ID;
    }

    /**
     * ID getter
     * @return
     */
    public int getID() {
		return this.ID;
	}

    /**
     * User last name getter
     * @return user's last name
     */
	public String getLastName() {
		return this.LastName;
	}
    /**
     * User first name getter
     * @return user's first name
     */
	public String getFirstName() {
		return this.FirstName;
	}
    /**
     * User email getter
     * @return user's email
     */
	public String getMail() {
		return this.Mail;
	}
    /**
     * User phone number getter
     * @return user's phone number
     */
	public double getphone() {
		return this.Phone;
	}

    /**
     * User address getter
     * @return user's address
     */
	public String getAdress() {
		return this.Address;
	}
    /**
     * User date of birth getter
     * @return user's date of birth
     */
	public LocalDate getDOB() {
		return this.DOB;
	}
}
