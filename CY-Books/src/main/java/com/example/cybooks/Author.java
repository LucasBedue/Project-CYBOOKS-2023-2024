package com.example.cybooks;

import java.time.LocalDate;
import java.util.Date;

public class Author extends Person {
    private LocalDate DOD;
    /**
     * Constructor for an Author who has passed
     * @param ID
     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     * @param DOB
     * @param DOD
     */
    public Author(int ID, String lastName, String firstName, String mail, double telephone, String address, LocalDate DOB, LocalDate DOD) {
        super(ID, lastName, firstName, mail, telephone, address, DOB);
        this.DOD = DOD;
    }

    /**
     * Constructor for an Author who is still alive
     * @param ID
     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     * @param DOB
     */
    public Author(int ID, String lastName, String firstName, String mail, double telephone, String address, LocalDate DOB) {
        super(ID, lastName, firstName, mail, telephone, address, DOB);
    }



    /**
     * Function to return this author
     * @return this author
     */
    public Author getAuthor(){
        return this;
    }
}
