package com.livremysql.livremysql.model;

import jakarta.persistence.*;

@Entity
@Table(name="auteur")
public class Auteur {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    public Auteur() {
    }

    public Auteur(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

}
