package com.jjmarinho.traderdata.dataloader;

import com.jjmarinho.traderdata.models.Order;
import com.jjmarinho.traderdata.models.Trade;
import com.jjmarinho.traderdata.models.Trader;
import com.jjmarinho.traderdata.repositories.OrderRepository;
import com.jjmarinho.traderdata.repositories.TradeRepository;
import com.jjmarinho.traderdata.repositories.TraderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    TraderRepository traders;

    @Autowired
    OrderRepository orders;

    @Autowired
    TradeRepository trades;

    @Autowired
    public DataLoader(TraderRepository traders, OrderRepository orders, TradeRepository trades) {
        this.traders = traders;
        this.orders = orders;
        this.trades = trades;
    }

    @Override
    public void run(ApplicationArguments args) {
        Trader t1 = new Trader("JDO", "John Doe");
        Trader t2 = new Trader("JSM", "John Smith");
        traders.save(t1);
        traders.save(t2);

        Order o1 = new Order(1, "PETR4", t1);
        Order o2 = new Order(2, "ITUB4", t2);
        orders.save(o1);
        orders.save(o2);

        Trade tr1 = new Trade(1, Instant.now(), 1000, 25.123456, o1);
        Trade tr2 = new Trade(2, Instant.now(), 2000, 40.000000, o2);
        trades.save(tr1);
        trades.save(tr2);
    }
}