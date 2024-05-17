package com.example.cybooks;

import java.time.LocalDate;
import java.util.Date;

public class Author extends Person {
    private LocalDate DOD;
    /**
     * Constructor for an Author who has passed

     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     * @param DOB
     * @param DOD
     */
    public Author( String lastName, String firstName, String mail, String telephone, String address, LocalDate DOB, LocalDate DOD) {
        super(lastName, firstName, mail, telephone, address, DOB);
        this.DOD = DOD;
    }

    /**
     * Constructor for an Author who is still alive

     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     * @param DOB
     */
    public Author(String lastName, String firstName, String mail, String telephone, String address, LocalDate DOB) {
        super(lastName, firstName, mail, telephone, address, DOB);
    }



    /**
     * Function to return this author
     * @return this author
     */
    public Author getAuthor(){
        return this;
    }

    /**
     * Function to return this author as a string
     * @return this author as a string
     */
    @Override
    public String toString(){
        return this.getFirstName() + " " + this.getLastName();
    }
}
