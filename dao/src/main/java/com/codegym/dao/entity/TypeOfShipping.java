package com.codegym.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_of_shipping")
public class TypeOfShipping {
    @Id
    @Column(name = "type_of_shipping_id")
    private int id;
    @Column(name = "type_of_shipping_name")
    private  String name;
    @Column(name = "type_of_shipping_cost")
    private double cost;

    public TypeOfShipping() {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
