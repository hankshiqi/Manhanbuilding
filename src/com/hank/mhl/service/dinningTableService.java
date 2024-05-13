package com.hank.mhl.service;

import com.hank.mhl.DAO.*;
import com.hank.mhl.DAO.diningTableDAO;
import com.hank.mhl.domain.dinningTable;

import java.util.List;

public class dinningTableService {
    public diningTableDAO diningtableDAO = new diningTableDAO();
    public billDAO billDAO = new billDAO();
    public MenuDAO menuDAO = new MenuDAO();
    public List<dinningTable> getAllDinningTables() throws Exception {
        return diningtableDAO.queryMulti("select id,state from diningTable",dinningTable.class);
    }
    public boolean checkTableIsBooked(int id) throws Exception {
        dinningTable table = diningtableDAO.querySingle("select * from diningTable where id =?",dinningTable.class,id);
        return table!= null && table.getState().equals("空");
    }
    public int bookTable(int id,String orderName,String orderTel) throws Exception {
        return diningtableDAO.update("update diningTable set state = '已预订',orderName =?,orderTel =? where id =?",orderName,orderTel,id);
    }
    public boolean checkBookorEating(int id)throws Exception{
        return diningtableDAO.querySingle("select state from diningTable where id =?",dinningTable.class,id).getState().equals("已预订")||
                diningtableDAO.querySingle("select state from diningTable where id =?",dinningTable.class,id).getState().equals("用餐中");
    }
    public void changeTableState(int tableid,int statenum)throws Exception{
        switch (statenum){
            case 1:
                int res=diningtableDAO.update("update diningTable set state = '空' where id =?",tableid);
                if(res==1)
                    System.out.println(tableid+"已经空闲");
                else
                    System.out.println(tableid+"状态更新失败");
                break;
            case 2:
                int res1=diningtableDAO.update("update diningTable set state = '已预订' where id =?",tableid);
                if(res1==1)
                    System.out.println(tableid+"已经预订");
                else
                    System.out.println(tableid+"状态更新失败");
                break;
            case 3:
                int res2=diningtableDAO.update("update diningTable set state = '用餐中' where id =?",tableid);
                if(res2==1)
                    System.out.println(tableid+"已经用餐");
                else
                    System.out.println(tableid+"状态更新失败");
                break;
        }
    }
}
