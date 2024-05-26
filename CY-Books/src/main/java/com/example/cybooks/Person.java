package com.example.cybooks;

import javafx.beans.property.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        this.ID = new SimpleIntegerProperty(generateUserID());
        this.LastName = setLastNameConstruct("");
        this.FirstName = setFirstNameConstruct("");
        this.Mail = setMailConstruct("");
        this.Phone = setPhoneConstruct("");
        this.Address = new SimpleStringProperty("");
        this.DOB = new SimpleObjectProperty<LocalDate>();    }

    /**
     * Constructor for any person
     * @param lastName Person's Last Name
     * @param firstName Person's First Name
     * @param mail Person's Email
     * @param phone Person's Phone Number
     * @param address Person's Address
     * @param DOB Person's Date of Birth
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
     * Constructor for any person to recreate the person without incrementing the ID
     * @param ID Person's ID
     * @param lastName Person's Last Name
     * @param firstName Person's First Name
     * @param mail Person's Email
     * @param phone Person's Phone Number
     * @param address Person's Address
     * @param DOB Person's Date of Birth
     */
    public Person(Integer ID, String lastName, String firstName, String mail, String phone, String address, LocalDate DOB) {
        this.ID = new SimpleIntegerProperty(ID);
        this.LastName = new SimpleStringProperty(lastName);
        this.FirstName = new SimpleStringProperty(firstName);
        this.Mail = new SimpleStringProperty(mail);
        this.Phone = new SimpleStringProperty(phone);
        this.Address = new SimpleStringProperty(address);
        this.DOB = new SimpleObjectProperty<LocalDate>(DOB);
    }



    /**
     * Constructor with no date of birth
     * @param lastName Person's Last Name
     * @param firstName Person's First Name
     * @param mail Person's Email
     * @param phone Person's Phone Number
     * @param address Person's Address
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

    /**
     * User ID getter as IntegerProperty
     * @return user's ID as IntegerProperty
     */
    public IntegerProperty IDProperty(){
        return this.ID;
    }

    /**
     * User ID setter
     */
    public void setID(Integer ID){ this.ID.set(ID);}

    public Person getPerson(){
        return this;
    }

    /**
     * User last name getter
     * @return user's last name
     */
    public String getLastName() {
        return LastName.get();
    }

    /**
     * User first name getter as StringProperty
     * @return user's first name as StringProperty
     */
    public StringProperty LastNameProperty(){
        return this.LastName;
    }

    /**
     * User last name setter
     */
    public void setLastName(String LastName){ this.LastName.set(LastName);}

    /**
     * It check if the inserted lastname is correct
     * @param Name
     * @return
     */
    public StringProperty setLastNameConstruct(String Name){
        String regex = "([a-zA-Zéèîûïüæøåíñóúőűð&ýçąćęłńśżõã]+\s?)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Name);
        if (matcher.matches()){
            StringProperty name = new SimpleStringProperty(Name);
            return name;
        }else {
           System.out.println("Invalid Last Name");
           return new SimpleStringProperty("");
        }
    }

    /**
     * User first name getter
     * @return user's first name
     */
    public String getFirstName() {
        return this.FirstName.get();
    }

    /**
     * User first name getter as StringProperty
     * @return user's first name as StringProperty
     */
    public StringProperty FirstNameProperty(){
        return this.FirstName;
    }


    /**
     * User first name setter
     */
    public void setFirstName(String FirstName){ this.FirstName.set(FirstName);}

    /**
     * It check if the inserted firstname is correct
     * @param Name
     * @return
     */
    public StringProperty setFirstNameConstruct(String Name){
        String regex = "([a-zA-Zéèîûïüæøåíñóúőűð&ýçąćęłńśżõã]+\s?)*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Name);
        if (matcher.matches()){
            StringProperty name = new SimpleStringProperty(Name);
            return name;
        }else {
          System.out.println("Invalid First Name");
          return new SimpleStringProperty("");
        }
    }

    /**
     * User email getter
     * @return user's email
     */
    public String getMail() {
        return this.Mail.get();
    }

    /**
     * User email getter as StringProperty
     * @return user's email as StringProperty
     */
    public StringProperty MailProperty(){
        return this.Mail;
    }

    /**
     * User email setter
     */
    public void setMail(String Mail){ this.Mail.set(Mail);}

    /**
     * It check if the inserted mail is correct
     * @param Mail
     * @return
     */
    public StringProperty setMailConstruct(String Mail){
        String regex = "(.+@.+)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Mail);
        if (matcher.matches()){
            StringProperty Email = new SimpleStringProperty(Mail);
            return Email;
        }else {
            System.out.println("Invalid mail");
            return new SimpleStringProperty("");
        }
    }

    /**
     * User phone number getter
     * @return user's phone number
     */
    public String getPhone() {
        return this.Phone.get();
    }

    /**
     * User phone number getter as StringProperty
     * @return user's phone number as StringProperty
     */
    public StringProperty PhoneProperty(){
        return this.Phone;
    }

    /**
     * User phone number setter
     */
    public void setPhone(String Phone){ this.Phone.set(Phone);}


    /**
     * It check if the inserted phone is correct
     * @param Phone
     * @return
     */
    public StringProperty setPhoneConstruct(String Phone){

        String regex = "^((?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$)?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Phone);
        if (matcher.matches()){
            StringProperty phoneNumber = new SimpleStringProperty(Phone);
            return phoneNumber;}
        else {
            System.out.println("Invalid phone number");
            return new SimpleStringProperty("");
        }
    }

    /**
     * User address getter
     * @return user's address
     */
    public String getAddress() {
        return this.Address.get();
    }

    /**
     * User address getter as StringProperty
     * @return user's address as StringProperty
     */
    public StringProperty AddressProperty(){
        return this.Address;
    }

    /**
     * User address setter
     */
    public void setAddress(String Address){ this.Address.set(Address);}

    /**
     * User date of birth getter
     * @return user's date of birth
     */
    public LocalDate getDOB() {
        return this.DOB.get();
    }

    /**
     * User date of birth getter as ObjectProperty<LocalDate>
     * @return user's date of birth as ObjectProperty<LocalDate>
     */
    public ObjectProperty<LocalDate> DOBProperty() {
        return this.DOB;
    }

    /**
     * User date of birth setter
     */
    public void setDOB(LocalDate DOB) {
            this.DOB.set(DOB);
    }


}

