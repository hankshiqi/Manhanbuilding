package com.hank.mhl.service;

import com.hank.mhl.DAO.MenuDAO;
import com.hank.mhl.domain.Menu;

import java.util.List;

public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();
    public List<Menu> showMenu() throws Exception {
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }
    public Menu getMenuById(int id) throws Exception {
        return menuDAO.querySingle("select * from menu where id =?",Menu.class,id);
    }
    public Menu checkMenuIsExist(int id) throws Exception {
        return menuDAO.querySingle("select * from menu where id =?",Menu.class,id);
    }
}
