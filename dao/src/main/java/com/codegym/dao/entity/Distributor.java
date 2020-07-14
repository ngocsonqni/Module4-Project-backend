package com.codegym.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "distributor")
public class Distributor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_distributor")
    int id;
    String name;
    String address;
    String email;
    String phone;
    String fax;
    String website;
    String img;
    boolean deleted;
    @ManyToOne(targetEntity = TypeOfDistributor.class)
    TypeOfDistributor typeOfDistributor;
    public Distributor(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Distributor() {
    }

    public Distributor(String name, String address, String email, String phone, String fax, String website, String img, boolean deleted, TypeOfDistributor typeOfDistributor) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
        this.website = website;
        this.img = img;
        this.deleted = deleted;
        this.typeOfDistributor = typeOfDistributor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public TypeOfDistributor getTypeOfDistributor() {
        return typeOfDistributor;
    }

    public void setTypeOfDistributor(TypeOfDistributor typeOfDistributor) {
        this.typeOfDistributor = typeOfDistributor;
    }
}
