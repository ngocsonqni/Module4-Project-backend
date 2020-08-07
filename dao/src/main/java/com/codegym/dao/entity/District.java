package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "district")
public class District {

    @Id
    String maqh;
    String name;
    String type;
    String matp;
    @ManyToOne(optional=false)
    @JoinColumn(name="matp",referencedColumnName="matp",insertable=false, updatable=false)
            @JsonIgnore
    Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getMatp() {
        return matp;
    }

    public void setMatp(String matp) {
        this.matp = matp;
    }

    public District() {
    }

    public String getMaqh() {
        return maqh;
    }

    public void setMaqh(String maqh) {
        this.maqh = maqh;
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
