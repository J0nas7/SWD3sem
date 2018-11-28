package com.crm.demo.model;

import javax.persistence.*;

@Entity(name="CRM_Customer")
@Table(name="CRM_Customer", schema = "crmsystemdb")
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CRM_Customer_Id")
    private int Id;

    @Column(name="CRM_Customer_FirstName")
    private String FirstName;

    @Column(name="CRM_Customer_LastName")
    private String LastName;

    @Column(name="CRM_Customer_NickName")
    private String NickName;

    @Column(name="CRM_Customer_Email")
    private String Email;

    @Column(name="CRM_Customer_Phone")
    private String Phone;

    @Column(name="CRM_Customer_CVR")
    private String CVR;

    @Column(name="CRM_Customer_DOB")
    private String DOB;

    @Column(name="CRM_Customer_Adress1")
    private String Adress1;

    @Column(name="CRM_Customer_Adress2")
    private String Adress2;

    @Column(name="CRM_Customer_City")
    private String City;

    @Column(name="CRM_Customer_PostalCode")
    private String PostalCode;

    @Column(name="CRM_Customer_Country")
    private String Country;

    @Column(name="CRM_Customer_Website")
    private String Website;

    @Column(name="CRM_Customer_Facebook")
    private String Facebook;

    @Column(name="CRM_Customer_Trello")
    private String Trello;

    @Column(name="CRM_Customer_GitHub")
    private String GitHub;

    @Column(name="CRM_Customer_Gmail")
    private String Gmail;

    public Contact() {
    }

    public Contact(String firstName, String lastName, String nickName, String email, String phone, String CVR, String DOB, String adress1, String adress2, String city, String postalCode, String country, String website, String facebook, String trello, String gitHub, String gmail) {
        FirstName = firstName;
        LastName = lastName;
        NickName = nickName;
        Email = email;
        Phone = phone;
        this.CVR = CVR;
        this.DOB = DOB;
        Adress1 = adress1;
        Adress2 = adress2;
        City = city;
        PostalCode = postalCode;
        Country = country;
        Website = website;
        Facebook = facebook;
        Trello = trello;
        GitHub = gitHub;
        Gmail = gmail;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getCVR() {
        return CVR;
    }

    public void setCVR(String CVR) {
        this.CVR = CVR;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAdress1() {
        return Adress1;
    }

    public void setAdress1(String adress1) {
        Adress1 = adress1;
    }

    public String getAdress2() {
        return Adress2;
    }

    public void setAdress2(String adress2) {
        Adress2 = adress2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getFacebook() {
        return Facebook;
    }

    public void setFacebook(String facebook) {
        Facebook = facebook;
    }

    public String getTrello() {
        return Trello;
    }

    public void setTrello(String trello) {
        Trello = trello;
    }

    public String getGitHub() {
        return GitHub;
    }

    public void setGitHub(String gitHub) {
        GitHub = gitHub;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }
}
