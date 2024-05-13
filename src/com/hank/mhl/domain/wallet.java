package com.hank.mhl.domain;

public class wallet{
    private Double total;

    public wallet() {
    }

    public wallet(Double total) {
        this.total = total;
    }

    public Double gettotal() {
        return total;
    }

    public void settotal(Double total) {
        this.total = total;
    }
}
