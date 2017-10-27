/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package incomes;

import incomes.*;
import incomes.incomebean;
import connection.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;



/**
 *
 * @author monty
 */
public class incomesDAO {
     public void create(incomebean bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Insert into incomes (inc_id,inc_ac,userid,inc_catid,amount,tran_date,receivby,remark )values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bean.getInc_id());
            pstmt.setString(2, bean.getInc_ac());
            pstmt.setInt(3,bean.getUserid());
            pstmt.setInt(4,bean.getInc_catid());
            pstmt.setDouble(5,bean.getAmount());
            pstmt.setString(6,bean.getTran_date());
            pstmt.setString(7,bean.getReceivby());
            pstmt.setString(8,bean.getRemark());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }

 public void edit(incomebean bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Update incomes set amount=?,receivby=? where inc_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, bean.getAmount());
            pstmt.setString(2, bean.getReceivby());
            pstmt.setInt(3, bean.getInc_id());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }




 public void remove(int id) {

        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();

        try {
            String sql = "delete from incomes where inc_id= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }



 public ArrayList<incomebean> findAll() {
        ArrayList<incomebean> al = new ArrayList<incomebean>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            conn = c.getConnection();
            String sql = "Select * from incomes";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
          incomebean bean=new incomebean();
                bean.setInc_id(rs.getInt("inc_id"));
                bean.setInc_ac(rs.getString("inc_ac"));

                 bean.setInc_catid(rs.getInt("inc_catid"));
                  bean.setAmount(rs.getDouble("amount"));
              bean.setTran_date(rs.getString("tran_date"));
              bean.setReceivby(rs.getString("receivby"));
              bean.setRemark(rs.getString("remark"));
                al.add(bean);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);
        }
        return al;
    }



 public ArrayList<incomebean> findAll(int userid) {
        ArrayList<incomebean> al = new ArrayList<incomebean>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            conn = c.getConnection();
            String sql = "Select * from incomes where userid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
 pstmt.setInt(1,userid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
          incomebean bean=new incomebean();
                bean.setInc_id(rs.getInt("inc_id"));
                bean.setInc_ac(rs.getString("inc_ac"));

                 bean.setInc_catid(rs.getInt("inc_catid"));
                  bean.setAmount(rs.getDouble("amount"));
              bean.setTran_date(rs.getString("tran_date"));
              bean.setReceivby(rs.getString("receivby"));
              bean.setRemark(rs.getString("remark"));
                al.add(bean);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);
        }
        return al;
    }



  ArrayList<incomebean> findAll(String sdate,String edate,int userid)
    {
            ArrayList<incomebean> al= new ArrayList<incomebean>();
            ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection  conn =c.getConnection();
            try
            {
 String sql="select * from incomes where userid=?";
 PreparedStatement pstm = conn.prepareStatement(sql);
 pstm.setInt(1,userid);
 ResultSet rs=pstm.executeQuery();
SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy");

 Date curDate = (Date)formatter.parse(sdate);
  Date curDate2 = (Date)formatter.parse(edate);

while(rs.next())
{
     incomebean bean=new incomebean();
                bean.setInc_id(rs.getInt("inc_id"));
                bean.setInc_ac(rs.getString("inc_ac"));

                 bean.setInc_catid(rs.getInt("inc_catid"));
                  bean.setAmount(rs.getDouble("amount"));
              bean.setTran_date(rs.getString("tran_date"));
              bean.setReceivby(rs.getString("receivby"));
              bean.setRemark(rs.getString("remark"));


  Date curDate3 = (Date)formatter.parse(rs.getString("tran_date"));
   if((curDate.compareTo(curDate3)<0||curDate.compareTo(curDate3)==0)&&(curDate2.compareTo(curDate3)>0))
   {
                    al.add(bean);
   }
}
            }

            catch(Exception ex)
            {
System.out.println(ex);
            }
            finally
            {
                c.putConnection(conn);
            }
            return al;

    }



























public static void main(String []args)
    {
    incomesDAO bd=new incomesDAO();

 /*ArrayList<b_bookbean> cb = bd.findAll("1-8-2013","4-8-2013",1);
        for (b_bookbean c : cb) {
       System.out.println(c.getTran_date());
        }
 */
//System.out.println(bd.closingBalance());
// incomebean bn=new  incomebean(4,"1111",2,3,100000,"03-08-2013","fdjhfjdhjf","dfdfdfdf");
  // bd.create(bn);

//incomebean bn=new incomebean(1,3333,"himanshu");

//bd.edit(bn);

  //  bd.remove(1);

 /* ArrayList<incomebean> cb = bd.findAll();
 for (incomebean c : cb) {
       System.out.println(c.getInc_id());
        }
*/
    ArrayList<incomebean> cb = bd.findAll("2-8-2013","4-8-2013",2);
        for (incomebean c : cb) {
       System.out.println(c.getTran_date());
        }
        
}




}
