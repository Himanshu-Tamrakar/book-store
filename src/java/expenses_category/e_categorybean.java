/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expenses_category;

/**
 *
 * @author monty
 */
public class e_categorybean {
    int exp_catid;
String exp_catname;
String exp_catdetail;
int userid;

    public e_categorybean() {
    }

    public e_categorybean(int exp_catid, String exp_catname, String exp_catdetail, int userid) {
        this.exp_catid = exp_catid;
        this.exp_catname = exp_catname;
        this.exp_catdetail = exp_catdetail;
        this.userid = userid;
    }

    public String getExp_catdetail() {
        return exp_catdetail;
    }

    public void setExp_catdetail(String exp_catdetail) {
        this.exp_catdetail = exp_catdetail;
    }

    public int getExp_catid() {
        return exp_catid;
    }

    public void setExp_catid(int exp_catid) {
        this.exp_catid = exp_catid;
    }

    public String getExp_catname() {
        return exp_catname;
    }

    public void setExp_catname(String exp_catname) {
        this.exp_catname = exp_catname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
