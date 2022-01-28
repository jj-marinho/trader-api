package com.jjmarinho.traderdata.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    private Long id;

    @Column(nullable = false)
    private String ticker;

    @ManyToOne
    @JoinColumn(name = "trader_code")
    private Trader trader;

    @OneToMany(mappedBy = "order")
    public List<Trade> trades;


    public Order(long id, String ticker, Trader trader) {
        this.id = id;
        this.ticker = ticker;
        this.trader = trader;
    }

    public Order() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public void setTrades(List<Trade> trades) {
        this.trades = trades;
    }
}
