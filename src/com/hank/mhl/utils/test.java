package com.hank.mhl.utils;

import java.sql.Connection;

public class test {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入一个整数");
        int i = Utility.readInt();
        System.out.println(i);
        Connection connection = UtilsBydruid.getConnection();
        System.out.println(connection);
    }
}
