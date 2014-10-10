package com.model;
/**
  * @author Jeroen
 */
public class TherapistUser extends User {

    private String occupation;
    private String firm;

    public TherapistUser(String occupation, String firm, long id, String firstname, String lastname, String email, String password, String addres, String postalCode, String city) {
        super(id, firstname, lastname, email, password, addres, postalCode, city);
        this.occupation = occupation;
        this.firm = firm;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

}
