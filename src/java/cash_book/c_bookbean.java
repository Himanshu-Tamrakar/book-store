/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cash_book;

/**
 *
 * @author monty
 */
public class c_bookbean {
    int acid;
    String account;
    String tran_date;
    double amount;
    int userid;
    String operation;

    public c_bookbean() {
    }

    public c_bookbean(int acid, String account, double amount) {
        this.acid = acid;
        this.account = account;
        this.amount = amount;
    }

  

    public c_bookbean(int acid, String account, String tran_date, double amount, int userid, String operation) {
        this.acid = acid;
        this.account = account;
        this.tran_date = tran_date;
        this.amount = amount;
        this.userid = userid;
        this.operation = operation;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getAcid() {
        return acid;
    }

    public void setAcid(int acid) {
        this.acid = acid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTran_date() {
        return tran_date;
    }

    public void setTran_date(String tran_date) {
        this.tran_date = tran_date;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
