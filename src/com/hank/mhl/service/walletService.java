package com.hank.mhl.service;
import com.hank.mhl.DAO.walletDAO;
import com.hank.mhl.domain.wallet;

public class walletService {
    walletDAO walletDAO = new walletDAO();
    public int payTheBill(double money) throws Exception {
        return walletDAO.update("update mybalance set total = total -?",money);
    }
    public wallet getBalance(int id) throws Exception {
        return walletDAO.querySingle("select total from mybalance where id = ?", wallet.class,id);
    }
}
