/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package income_category;

/**
 *
 * @author monty
 */
public class i_categorybean {
    int inc_catid;
    String inc_catnme;
    String inc_catdetail;
    int userid;

    public i_categorybean() {
    }

    public i_categorybean(int inc_catid, String inc_catnme, String inc_catdetail, int userid) {
        this.inc_catid = inc_catid;
        this.inc_catnme = inc_catnme;
        this.inc_catdetail = inc_catdetail;
        this.userid = userid;
    }

    public String getInc_catdetail() {
        return inc_catdetail;
    }

    public void setInc_catdetail(String inc_catdetail) {
        this.inc_catdetail = inc_catdetail;
    }

    public int getInc_catid() {
        return inc_catid;
    }

    public void setInc_catid(int inc_catid) {
        this.inc_catid = inc_catid;
    }

    public String getInc_catnme() {
        return inc_catnme;
    }

    public void setInc_catnme(String inc_catnme) {
        this.inc_catnme = inc_catnme;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    

}
