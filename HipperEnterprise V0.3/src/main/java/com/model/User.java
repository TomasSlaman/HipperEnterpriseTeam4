package com.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "User")
@Inheritance(strategy=InheritanceType.JOINED)
public class User implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "firstName", nullable = false)    
    private String firstName;
    @Column(name = "lastName", nullable = false) 
    private String lastName;
    @Column(name = "email", nullable = false) 
    private String email;
    @Column(name = "password", nullable = false) 
    private String password;
    @Column(name = "address", nullable = true) 
    private String address;
    @Column(name = "postalCode", nullable = true) 
    private String postalCode;
    @Column(name = "city", nullable = true) 
    private String city;

    public User() {
    }

    public User(long id, String firstname, String lastname, String email, String password, String addres, String postalCode, String city) {
        this.id = id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
        this.address = addres;
        this.postalCode = postalCode;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new NullPointerException("firstname field may not be empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new NullPointerException("lastname field may not be empty");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new NullPointerException("Emailadress field may not be empty");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            throw new NullPointerException("Password field may not be empty");
        }
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addres) {
        this.address = addres;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
