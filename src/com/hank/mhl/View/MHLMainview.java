package com.hank.mhl.View;

import com.hank.mhl.DAO.EmployeeDAO;
import com.hank.mhl.domain.Employee;
import com.hank.mhl.domain.Menu;
import com.hank.mhl.domain.bill;
import com.hank.mhl.domain.dinningTable;
import com.hank.mhl.service.EmployeeService;
import com.hank.mhl.service.MenuService;
import com.hank.mhl.service.dinningTableService;
import com.hank.mhl.service.*;
import com.hank.mhl.utils.Utility;

import java.util.List;

public class MHLMainview {
    public static void main(String[] args) throws Exception {
        new Mainview().mainview();
    }
}
class Mainview{
    private boolean loop = true;
    private String key;
    private EmployeeService employeeService = new EmployeeService();
    private dinningTableService dTableService= new dinningTableService();
    private MenuService menuService = new MenuService();
    private billService billService = new billService();
    private walletService walleService = new walletService();
    public void gettableStatus() throws Exception {
        System.out.println("餐桌状态：");
        List<dinningTable> dTables = dTableService.getAllDinningTables();

        for (dinningTable dTable : dTables) {
            System.out.println(dTable.toString());
        }
    }
    public void pointTargetTable() throws Exception {
        System.out.println("请输入餐桌号：");
        int tableNo = Utility.readInt();
        if (!dTableService.checkBookorEating(tableNo)){
            System.out.println("餐桌号不存在或已被占用！");
        }else {
            System.out.println("餐桌未被占用，请问需要预订吗?(y/n)");
            String isBook = Utility.readString(1);
            if (isBook.equals("y")) {
                System.out.println("请输入您的姓名:");
                String name = Utility.readString(16);
                System.out.println("请输入您的电话号码:");
                String phone = Utility.readString(16);
                dTableService.bookTable(tableNo,name,phone);
                System.out.println("餐桌预定成功！");
            }
        }
    }
    public void showallMenu() throws Exception {
        System.out.println("\t\t\t编号\t\t菜名\t\t\t种类\t\t价格");
        List<Menu> menus = menuService.showMenu();
        for (Menu menu : menus) {
            System.out.println(menu.toString());
        }
    }
    public void makeOrder() throws Exception {
        System.out.println("请输入餐桌号：");
        int tabid = Utility.readInt();
        if(dTableService.checkBookorEating(tabid)){
            System.out.println("请输入菜品编号");
            int dishid = Utility.readInt();
            if(menuService.checkMenuIsExist(dishid)==null){
                System.out.println("很抱歉您选择的菜品不存在！");
            }else {
                System.out.println("请输入你想点的份数:");
                int num = Utility.readInt();
                if(num<=0){
                    System.out.println("份数不能为0！");
                }else {
                    String ans=billService.addBill(dishid,num,tabid)==1?"下单成功！":"下单失败！";
                    System.out.println(ans);
                    if(ans.equals("下单成功！"))
                        dTableService.changeTableState(tabid,3);
                }
            }
        }else {
            System.out.println("餐桌未被预定");
        }
    }
    public Double checkMyBill() throws Exception {
        Double tatalPrice = 0.0;
        System.out.println("请输入您的座位号:");
        int seatid = Utility.readInt();
        if(dTableService.checkBookorEating(seatid))
        {
            List<bill> bills = billService.getBillBySeatid(seatid);
            for(bill bill:bills){
                System.out.println(bill.toString());
                tatalPrice+=bill.getMoney()*bill.getNums();
            }
        }else {
            System.out.println("状态非法");
        }
        return tatalPrice;
    }
    public void checkout() throws Exception {
        Double totalPrice = checkMyBill();
        if(totalPrice>0){
            System.out.println("再次确认您的桌号:");
            int seatid = Utility.readInt();
            System.out.println("请输入您的支付方式(1.现金 2.微信 3.支付宝):");
            int payType = Utility.readInt();
            double money =walleService.getBalance(1).gettotal();
            if(money>=totalPrice){
                walleService.payTheBill(totalPrice);
                System.out.println("支付成功！");
                billService.changeBillState(seatid,"已支付"+payType);
                dTableService.changeTableState(seatid,1);
            }else {
                System.out.println("支付金额不足！");
            }
        }else {
            System.out.println("无订单！");
        }
    }
    public void mainview() throws Exception {
        while (loop) {
            System.out.println("============满汉楼============");
            System.out.println("\t\t1.登录满汉楼");
            System.out.println("\t\t2.退出满汉楼");
            System.out.println("请输入你的选择:");
            key= Utility.readString(1);
            if (key.equals("1")) {
                System.out.println("请输入员工号：");
                String empNo = Utility.readString(16);
                System.out.println("请输入密码：");
                String password = Utility.readString(16);
                Employee employee = employeeService.getEmployee(empNo,password);
                if (employee!= null) {
                    System.out.println("登录成功！"+"["+employee.getName()+"]");
                    while (loop){
                        System.out.println("============满汉楼二级菜单============");
                        System.out.println("\t\t1.显示餐桌状态");
                        System.out.println("\t\t2.指定餐桌");
                        System.out.println("\t\t3.显示所有餐品");
                        System.out.println("\t\t4.点餐服务");
                        System.out.println("\t\t5.查看账单");
                        System.out.println("\t\t6.结账");
                        System.out.println("\t\t9.退出满汉楼");
                        System.out.println("请输入你的选择:");
                        key= Utility.readString(1);
                        switch (key) {
                            case "1":
                                gettableStatus();
                                break;
                            case "2":
                                pointTargetTable();
                                break;
                            case "3":
                                showallMenu();
                                break;
                            case "4":
                                makeOrder();
                                break;
                            case "5":
                                System.out.println("总价："+checkMyBill());
                                break;
                            case "6":
                                checkout();
                                break;
                            case "9":
                                loop = false;
                                System.out.println("退出满汉楼");
                                System.out.println("欢迎下次光临！");
                                break;
                            default:
                                System.out.println("输入错误，请重新输入！");
                                break;
                        }
                    }
                } else {
                    System.out.println("登录失败！");
                }
            } else if (key.equals("2")) {
                loop = false;
                System.out.println("退出满汉楼");
            }
        }
    }
}


