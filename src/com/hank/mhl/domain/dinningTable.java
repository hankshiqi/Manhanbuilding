package com.hank.mhl.domain;

public class dinningTable {
    private int id;
    private String state;
    private String orderName;
    private boolean orderTel;
    public dinningTable(){
    }

    public dinningTable(int id, String state, String orderName, boolean orderTel) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderTel = orderTel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public boolean isOrderTel() {
        return orderTel;
    }

    public void setOrderTel(boolean orderTel) {
        this.orderTel = orderTel;
    }

    @Override
    public String toString() {
        return "dinningTable{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
