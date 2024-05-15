package com.example.cybooks;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.Date;

public abstract class Person {
    private IntegerProperty ID = new SimpleIntegerProperty(0);
    private StringProperty LastName;
    private StringProperty FirstName;
    private StringProperty Mail;
    private DoubleProperty Phone;
    private StringProperty Address;
    private ObjectProperty<LocalDate> DOB;

    /**
     * Constructor for any person
     * @param lastName
     * @param firstName
     * @param mail
     * @param phone
     * @param address
     * @param DOB
     */
    public Person(String lastName, String firstName, String mail, double phone, String address, LocalDate DOB) {
        this.ID = new SimpleIntegerProperty(generateUserID());
        this.LastName = new SimpleStringProperty(lastName);
        this.FirstName = new SimpleStringProperty(firstName);
        this.Mail = new SimpleStringProperty(mail);
        this.Phone = new SimpleDoubleProperty(phone);
        this.Address = new SimpleStringProperty(address);
        this.DOB = new SimpleObjectProperty<LocalDate>(DOB);
    }

    /**
     * Constructor with no date of birth
     * @param lastName
     * @param firstName
     * @param mail
     * @param phone
     * @param address
     */
    public Person( String lastName, String firstName, String mail, double phone, String address) {

        this.ID = new SimpleIntegerProperty(generateUserID());
        this.LastName = new SimpleStringProperty(lastName);
        this.FirstName = new SimpleStringProperty(firstName);
        this.Mail = new SimpleStringProperty(mail);
        this.Phone = new SimpleDoubleProperty(phone);
        this.Address = new SimpleStringProperty(address);
    }

    /**
     * User ID generator
     * @return user ID
     */
    private int generateUserID(){
        int currentID = ID.get();

        ID.set(currentID + 1);

        return currentID;
    }

    /**
     * ID getter
     * @return
     */
    public int getID() {
        return this.ID.get();
    }

    /**
     * User last name getter
     * @return user's last name
     */
    public String getLastName() {
        return this.LastName.get();
    }
    /**
     * User first name getter
     * @return user's first name
     */
    public String getFirstName() {
        return this.FirstName.get();
    }
    /**
     * User email getter
     * @return user's email
     */
    public String getMail() {
        return this.Mail.get();
    }
    /**
     * User phone number getter
     * @return user's phone number
     */
    public double getphone() {
        return this.Phone.get();
    }

    /**
     * User address getter
     * @return user's address
     */
    public String getAdress() {
        return this.Address.get();
    }
    /**
     * User date of birth getter
     * @return user's date of birth
     */
    public LocalDate getDOB() {
        return this.DOB.get();
    }

    public void setLastName(StringProperty LastName){ this.LastName=LastName;}

    public void setLastFirst(StringProperty FirstName){ this.FirstName=FirstName;}

    public void setMail(StringProperty Mail){ this.Mail=Mail;}

    public void setPhone(DoubleProperty Phone){ this.Phone=Phone;}

    public void setAddress(StringProperty Address){ this.Address=Address;}
}