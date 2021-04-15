package com.example.demohibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kompis {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String address;

    private String email;

    private String telefon;

    public Kompis() {
    }

    public Kompis(Long id, String name, String address, String email, String telefon) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.telefon = telefon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return "Kompis{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                '}';
    }
}
