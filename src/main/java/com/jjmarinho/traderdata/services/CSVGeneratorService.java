package com.jjmarinho.traderdata.services;

import com.jjmarinho.traderdata.models.Order;
import com.jjmarinho.traderdata.models.Trade;
import com.jjmarinho.traderdata.models.Trader;
import com.jjmarinho.traderdata.repositories.TraderRepository;
import com.jjmarinho.traderdata.responses.TraderTotalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

class CSVLine {
    private String traderCode;
    private String traderName;
    private long orderID;
    private String ticker;
    private String timeStamp;
    private long quantity;
    private double price;

    @Override
    public String toString() {
        return traderCode + "," + traderName + "," + orderID + "," + ticker + "," + quantity + "," + price;
    }

    public CSVLine() {}

    public CSVLine(Trader t, Order o, long quantity, double price) {
        this.traderCode = t.getCode();
        this.traderName = t.getName();
        this.orderID = o.getId();
        this.ticker = o.getTicker();
        this.quantity = quantity;
        this.price = price;
    }
}

@Service
public class CSVGeneratorService {

    @Autowired
    private TraderRepository repository;

    public Path generateCSV() throws java.io.IOException {
        // Creating a new temporary file, then setting up a writer
        Path path = Files.createTempFile(Path.of("C:\\Temp"), "csv_data", ".csv");
        File file = path.toFile();
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("TraderCode,TraderName,OrderID,Ticker,Qty,AVGPrice");

        ArrayList<Trader> traders = (ArrayList<Trader>) repository.findAll();

        // Calculating average result for each trader
        for (Trader t : traders) {
            TraderTotalResponse traderTotal = new TraderTotalResponse(t.getCode(), 0);
            for (Order ord : t.orders) {
                // Calculating quantity and average price of order
                long quantity = 0;
                double avgPrice = 0;
                for (Trade trade : ord.trades) {
                    avgPrice += trade.getPrice() * trade.getQuantity();
                    quantity += trade.getQuantity();
                }
                avgPrice = avgPrice / quantity;

                // Sending result to file as a CSV Line
                CSVLine line = new CSVLine(t, ord, quantity, avgPrice);
                pw.println(line.toString());
            }
        }

        // Closing file so that the contents are written
        pw.close();
        return path;
    }

    public CSVGeneratorService() {
    }
}
