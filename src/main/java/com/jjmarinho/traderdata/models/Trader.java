package com.jjmarinho.traderdata.models;

import jdk.jfr.Category;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "traders")
public class Trader {
    @Id
    @Column(name = "trader_code")
    private String code;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "trader")
    public List<Order> orders;


    public Trader(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public  Trader() {}

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
