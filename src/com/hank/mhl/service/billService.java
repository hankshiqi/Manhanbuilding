package com.hank.mhl.service;
import com.hank.mhl.DAO.*;
import com.hank.mhl.domain.bill;

import java.util.List;
import java.util.UUID;

public class billService {
    public billDAO billDAO = new billDAO();

    public dinningTableService dinningTableService = new dinningTableService();
    public MenuService menuService = new MenuService();
    public int addBill(int dishid,int nums, int tableid) throws Exception {
        return billDAO.update("insert bill(billId,menuId,nums,money,diningTableId,billDate,state) values(?,?,?,?,?,NOW(),?)",
                UUID.randomUUID().toString(), dishid, nums, menuService.getMenuById(dishid).getPrice()*nums, tableid,"未结账");
    }
    public List<bill> getBillBySeatid(int seatid) throws Exception{
        return billDAO.queryMulti("select menuId,nums,money,diningTableId,billDate from bill where diningTableId=?", bill.class,seatid);
    }
    public void changeBillState(int seatid,String state) throws Exception {
        billDAO.update("update bill set state=? where diningTableId=?", state, seatid);
    }
}
