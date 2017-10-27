/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package incomes;

import incomes.*;

/**
 *
 * @author monty
 */
public class incomebean {
    int inc_id;
    String inc_ac;
    int userid;
    int inc_catid;
    double amount;
   String tran_date;
   String receivby;
   String remark;

    public incomebean() {
    }

    public incomebean(int inc_id, String inc_ac, int userid, int inc_catid, double amount, String tran_date, String receivby, String remark) {
        this.inc_id = inc_id;
        this.inc_ac = inc_ac;
        this.userid = userid;
        this.inc_catid = inc_catid;
        this.amount = amount;
        this.tran_date = tran_date;
        this.receivby = receivby;
        this.remark = remark;
    }

    public incomebean(int inc_id, double amount, String receivby) {
        this.inc_id = inc_id;
        this.amount = amount;
        this.receivby = receivby;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getInc_ac() {
        return inc_ac;
    }

    public void setInc_ac(String inc_ac) {
        this.inc_ac = inc_ac;
    }

    public int getInc_catid() {
        return inc_catid;
    }

    public void setInc_catid(int inc_catid) {
        this.inc_catid = inc_catid;
    }

    public int getInc_id() {
        return inc_id;
    }

    public void setInc_id(int inc_id) {
        this.inc_id = inc_id;
    }

    public String getReceivby() {
        return receivby;
    }

    public void setReceivby(String receivby) {
        this.receivby = receivby;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
