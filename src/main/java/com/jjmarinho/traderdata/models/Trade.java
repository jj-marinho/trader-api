package com.jjmarinho.traderdata.models;

import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "trades")
public class Trade {
    @Id
    @Column(name = "trade_id")
    private long id;

    @Column
    private Instant timeStamp;

    @Column(nullable = false)
    private long quantity;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    public Trade(long id, Instant timeStamp, long quantity, double price, Order order) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
    }

    public Trade() {}

    public double getTradeValue() {
        return this.price * this.quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
