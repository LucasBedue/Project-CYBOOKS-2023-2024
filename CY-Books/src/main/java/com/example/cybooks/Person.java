package com.example.cybooks;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.Date;

public abstract class Person {
    private static int counterMember =0;
    private IntegerProperty ID = new SimpleIntegerProperty(0);
    private StringProperty LastName;
    private StringProperty FirstName;
    private StringProperty Mail;
    private StringProperty Phone;
    private StringProperty Address;
    private ObjectProperty<LocalDate> DOB;


    /**
     * Default constructor.
     */
    public Person() {
        this(null, null, null, null, null, null);
    }

    /**
     * Constructor for any person
     * @param lastName
     * @param firstName
     * @param mail
     * @param phone
     * @param address
     * @param DOB
     */
    public Person(String lastName, String firstName, String mail, String phone, String address, LocalDate DOB) {
        this.ID = new SimpleIntegerProperty(generateUserID());
        this.LastName = new SimpleStringProperty(lastName);
        this.FirstName = new SimpleStringProperty(firstName);
        this.Mail = new SimpleStringProperty(mail);
        this.Phone = new SimpleStringProperty(phone);
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
    public Person( String lastName, String firstName, String mail, String phone, String address) {

        this.ID = new SimpleIntegerProperty(generateUserID());
        this.LastName = new SimpleStringProperty(lastName);
        this.FirstName = new SimpleStringProperty(firstName);
        this.Mail = new SimpleStringProperty(mail);
        this.Phone = new SimpleStringProperty(phone);
        this.Address = new SimpleStringProperty(address);
    }

    /**
     * User ID generator
     * @return user ID
     */
    private int generateUserID(){
        counterMember++;
        return counterMember;
    }

    /**
     * ID getter
     * @return user's ID
     */
    public int getID() {
        return this.ID.get();
    }

    public IntegerProperty IDProperty(){
        return this.ID;
    }

    public void setID(Integer ID){ this.ID.set(ID);}


    /**
     * User last name getter
     * @return user's last name
     */
    public String getLastName() {
        return LastName.get();
    }

    public StringProperty LastNameProperty(){
        return this.LastName;
    }

    public void setLastName(String LastName){ this.LastName.set(LastName);}

    /**
     * User first name getter
     * @return user's first name
     */
    public String getFirstName() {
        return this.FirstName.get();
    }

    public StringProperty FirstNameProperty(){
        return this.FirstName;
    }

    public void setLastFirst(String FirstName){ this.FirstName.set(FirstName);}

    /**
     * User email getter
     * @return user's email
     */
    public String getMail() {
        return this.Mail.get();
    }


    public StringProperty MailProperty(){
        return this.Mail;
    }

    public void setMail(String Mail){ this.Mail.set(Mail);}

    /**
     * User phone number getter
     * @return user's phone number
     */
    public String getPhone() {
        return this.Phone.get();
    }

    public StringProperty PhoneProperty(){
        return this.Phone;
    }

    public void setPhone(String Phone){ this.Phone.set(Phone);}
    /**
     * User address getter
     * @return user's address
     */
    public String getAddress() {
        return this.Address.get();
    }

    public StringProperty AddressProperty(){
        return this.Address;
    }

    public void setAddress(String Address){ this.Address.set(Address);}
    /**
     * User date of birth getter
     * @return user's date of birth
     */
    public LocalDate getDOB() {
        return this.DOB.get();
    }
}