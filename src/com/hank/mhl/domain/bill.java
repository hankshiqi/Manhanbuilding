package com.hank.mhl.domain;

import java.time.LocalDateTime;
import java.util.Date;

//CREATE TABLE bill (
//        id INT PRIMARY KEY AUTO_INCREMENT, -- 自增主键
//        billId VARCHAR(50) NOT NULL DEFAULT '', -- 账单号可以按照自己规则
//menuId INT NOT NULL DEFAULT 0, -- 菜品的编号，也可以使用外键
//nums INT NOT NULL DEFAULT 0, -- 份数
//money DOUBLE NOT NULL DEFAULT 0, -- 金额
//diningTableId INT NOT NULL DEFAULT 0, -- 餐桌
//billDate DATETIME NOT NULL, -- 订单日期
//state VARCHAR(50) NOT NULL DEFAULT '' -- 状态 '未结账'， '已经结账'
//        ) CHARSET=utf8;
public class bill {
    private int id;
    private String billId;
    private int menuId;
    private int nums;
    private double money;
    private int diningTableId;
    private LocalDateTime billDate;
    private String state;

    public bill() { }

    public bill(int id, String billId, int menuId, int nums, double money, int diningTableId, LocalDateTime billDate, String state) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billDate = billDate;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(int diningTableId) {
        this.diningTableId = diningTableId;
    }

    public LocalDateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDateTime billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "\t\t\t菜品编号" + menuId +
                "\t\t份数" + nums +
                "\t\t金额" + money +
                "\t\t桌号" + diningTableId +
                "\t\t日期" + billDate;
    }
}
