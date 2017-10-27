/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expenses;

/**
 *
 * @author monty
 */
public class expensesbean {

int exp_id;
    String exp_ac;
    int userid;
    int exp_catid;
    double amount;
   String tran_date;
   String receivby;
   String remark;

    public expensesbean() {
    }

    public expensesbean(String exp_ac, int userid, int exp_catid, double amount, String tran_date, String receivby, String remark) {
        this.exp_ac = exp_ac;
        this.userid = userid;
        this.exp_catid = exp_catid;
        this.amount = amount;
        this.tran_date = tran_date;
        this.receivby = receivby;
        this.remark = remark;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getExp_ac() {
        return exp_ac;
    }

    public void setExp_ac(String exp_ac) {
        this.exp_ac = exp_ac;
    }

    public int getExp_catid() {
        return exp_catid;
    }

    public void setExp_catid(int exp_catid) {
        this.exp_catid = exp_catid;
    }

    public int getExp_id() {
        return exp_id;
    }

    public void setExp_id(int exp_id) {
        this.exp_id = exp_id;
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
