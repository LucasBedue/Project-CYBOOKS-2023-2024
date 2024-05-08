package com.example.cybooks;

import java.util.Date;

public class Author extends Person {
    private Date DOD;

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
    public Author(int ID, String lastName, String firstName, String mail, double telephone, String address, Date DOB, Date DOD) {
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
    public Author(int ID, String lastName, String firstName, String mail, double telephone, String address, Date DOB) {
        super(ID, lastName, firstName, mail, telephone, address, DOB);
    }

    /**
     * TEMPORARY ---------------------------------------------------------
     *
     * DATE NOT FIGURED OUT YET
     * @param ID
     * @param lastName
     * @param firstName
     * @param mail
     * @param telephone
     * @param address
     */
    public Author(int ID, String lastName, String firstName, String mail, double telephone, String address) {
        super(ID, lastName, firstName, mail, telephone, address);
    }

    /**
     * Function to return this author
     * @return this author
     */
    public Author getAuthor(){
        return this;
    }
}
