package com.jjmarinho.traderdata.responses;

public class TraderTotalResponse {
    public String traderCode;
    public double total;

    public TraderTotalResponse(String traderCode, double total) {
        this.traderCode = traderCode;
        this.total = total;
    }

    public void addValue(double value) {
        this.total += value;
    }
}
