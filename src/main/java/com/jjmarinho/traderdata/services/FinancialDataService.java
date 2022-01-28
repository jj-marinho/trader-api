package com.jjmarinho.traderdata.services;

import com.jjmarinho.traderdata.models.Order;
import com.jjmarinho.traderdata.models.Trade;
import com.jjmarinho.traderdata.models.Trader;
import com.jjmarinho.traderdata.repositories.TraderRepository;
import com.jjmarinho.traderdata.responses.TraderTotalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FinancialDataService {

    @Autowired
    private TraderRepository repository;

    public ArrayList<TraderTotalResponse> getFinancialDataByTrader() {
        ArrayList<Trader> traders = (ArrayList<Trader>) repository.findAll();

        // Calculating each trader result, then adding it's result to our traderData payload
        ArrayList<TraderTotalResponse> traderData = new ArrayList<TraderTotalResponse>();
        for (Trader t : traders) {
            TraderTotalResponse traderTotal = new TraderTotalResponse(t.getCode(), 0);
            for (Order ord : t.orders) {
                for (Trade trade : ord.trades) {
                    traderTotal.addValue(trade.getTradeValue());
                }
            }
            traderData.add(traderTotal);
        }
        return traderData;
    }

    public FinancialDataService() {
    }
}
