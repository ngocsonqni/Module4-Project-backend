package com.codegym.dao.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commune {

    @Id
    String xaid;
    String name;
    String type;
    String maqh;


    public String getMaqh() {
        return maqh;
    }

    public void setMaqh(String maqh) {
        this.maqh = maqh;
    }

    public Commune() {
    }

    public Commune(String xaid, String name, String type, String maqh) {
        this.xaid = xaid;
        this.name = name;
        this.type = type;
        this.maqh = maqh;
    }

    public String getXaid() {
        return xaid;
    }

    public void setXaid(String xaid) {
        this.xaid = xaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
