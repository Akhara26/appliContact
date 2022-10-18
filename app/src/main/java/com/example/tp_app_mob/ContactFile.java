package com.example.tp_app_mob;
import java.io.Serializable;

public class ContactFile implements Serializable{
    public String name;
    public String lastname;
    public String gender;
    public String dateofbirth;
    public String phonenumebr;
    public Boolean fav;

    public ContactFile (String name, String lastname, String gender, String dateofbirth, String phonenumebr, Boolean fav) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.dateofbirth = dateofbirth;
        this.phonenumebr = phonenumebr;
        this.fav = fav;
    }



    @Override
    public String toString() {
        return "ContactFile{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", phonenumebr='" + phonenumebr + '\'' +
                ", fav=" + fav +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setPhonenumebr(String phonenumebr) {
        this.phonenumebr = phonenumebr;
    }

    public void setFav(Boolean fav) {
        this.fav = fav;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public String getPhonenumebr() {
        return phonenumebr;
    }

    public Boolean getFav() {
        return fav;
    }
}
