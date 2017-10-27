/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package expenses;
import exoenses.*;
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
public class expensesDAO {
     public void create(expensesbean bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Insert into expenses (exp_ac,userid,exp_catid,amount,tran_date,receivby,remark )values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bean.getExp_ac());
            pstmt.setInt(2,bean.getUserid());
pstmt.setInt(3,bean.getExp_catid());
            pstmt.setDouble(4,bean.getAmount());
            pstmt.setString(5,bean.getTran_date());
            pstmt.setString(6,bean.getReceivby());
            pstmt.setString(7,bean.getRemark());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }


 public void edit(expensesbean bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Update expenses set amount=?,receivby=? where exp_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDouble(1, bean.getAmount());
            pstmt.setString(2, bean.getReceivby());
            pstmt.setInt(3, bean.getExp_id());
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
            String sql = "delete from expenses where exp_id= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }


 public ArrayList<expensesbean> findAll() {
        ArrayList<expensesbean> al = new ArrayList<expensesbean>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            conn = c.getConnection();
            String sql = "Select * from expenses";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
          expensesbean bean=new expensesbean();
                bean.setExp_id(rs.getInt("exp_id"));
                bean.setExp_ac(rs.getString("exp_ac"));

                 bean.setExp_catid(rs.getInt("exp_catid"));
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


 public ArrayList<expensesbean> findAll(int userid) {
        ArrayList<expensesbean> al = new ArrayList<expensesbean>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            conn = c.getConnection();
            String sql = "Select * from expenses where userid=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
 pstmt.setInt(1,userid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
          expensesbean bean=new expensesbean();
                bean.setExp_id(rs.getInt("exp_id"));
                bean.setExp_ac(rs.getString("exp_ac"));

                 bean.setExp_catid(rs.getInt("exp_catid"));
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

 ArrayList<expensesbean> findAll(String sdate,String edate,int userid)
    {
            ArrayList<expensesbean> al= new ArrayList<expensesbean>();
            ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection  conn =c.getConnection();
            try
            {
 String sql="select * from expenses where userid=?";
 PreparedStatement pstm = conn.prepareStatement(sql);
 pstm.setInt(1,userid);
 ResultSet rs=pstm.executeQuery();
SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy");

 Date curDate = (Date)formatter.parse(sdate);
  Date curDate2 = (Date)formatter.parse(edate);

while(rs.next())
{
     expensesbean bean=new expensesbean();
                bean.setExp_id(rs.getInt("exp_id"));
                bean.setExp_ac(rs.getString("exp_ac"));

                 bean.setExp_catid(rs.getInt("exp_catid"));
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












}
