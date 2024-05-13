package com.hank.mhl.domain;
//CREATE TABLE menu (
//        id INT PRIMARY KEY AUTO_INCREMENT, # 自增主键，作为菜单编号（唯一）
//        name VARCHAR(50) NOT NULL DEFAULT '', # 菜品名称
//type VARCHAR(50) NOT NULL DEFAULT '', # 菜品种类
//price DOUBLE NOT NULL DEFAULT 0 # 价格
//) CHARSET=utf8;
public class Menu {
    private int id;
    private String name;
    private String type;
    private double price;

    public Menu() {
    }

    public Menu(int id, String name, String type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "\t\t\t" + id +
                "\t\t" + name  +
                "\t\t" + type  +
                "\t\t" + price ;
    }
}
