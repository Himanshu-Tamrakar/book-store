/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cash_book;


import bank_book.*;
import connection.*;
//import java.sql.Connection;
//^import java.sql.PreparedStatement;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author monty
 */
public class c_bookDAO {
public void create(c_bookbean bean)
    {
ConnectionPool c=ConnectionPool.getInstance();
c.initialize();
  Connection conn = c.getConnection();/*connection comes from sql package*/
  try
  {
      String sql="insert into cash_book(acid,account,tran_date,amount,userid,operation)values(?,?,?,?,?,?)";
      PreparedStatement pstm=conn.prepareStatement(sql);
      pstm.setInt(1, bean.getAcid());
      pstm.setString(2, bean.getAccount());
  pstm.setString(3, bean.getTran_date());
  pstm.setDouble(4, bean.getAmount());
  pstm.setInt(5, bean.getUserid());
pstm.setString(6, bean.getOperation());
pstm.executeUpdate();
  }
  catch(Exception ex)
  {
    System.out.println(ex);
  }
  finally

  {
c.putConnection(conn);
  }

}

public void edit(c_bookbean bean)
    {
    ConnectionPool c = ConnectionPool.getInstance();
    c.initialize();
    Connection conn = c.getConnection();
    try
    {
        String sql="Update cash_book set account=?,amount=? where acid=?";

PreparedStatement pstm = conn.prepareStatement(sql);
   
      pstm.setString(1, bean.getAccount());

  pstm.setDouble(2, bean.getAmount());


 pstm.setInt(3, bean.getAcid());
pstm.executeUpdate();
    }
    catch(Exception ex)
    {
        System.out.println(ex);
    }
    finally
    {
        c.putConnection(conn);
    }
}

public void remove(int id)
    {
    ConnectionPool c = ConnectionPool.getInstance();
    c.initialize();
    Connection conn = c.getConnection();
    try{
String sql="delete from cash_book where acid=?";
PreparedStatement pstm = conn.prepareStatement(sql);
pstm.setInt(1,id);
pstm.executeUpdate();
        }
    catch(Exception ex)
    {
        System.out.println(ex);
    }
       finally
    {
        c.putConnection(conn);
    }
}

public ArrayList<c_bookbean> findAll()
    {
            ArrayList<c_bookbean> al= new ArrayList<c_bookbean>();
            ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection  conn =c.getConnection();
            try
            {
 String sql="select from * cash_book";
 PreparedStatement pstm = conn.prepareStatement(sql);
ResultSet rs=pstm.executeQuery();
while(rs.next())
{
    c_bookbean bean =new c_bookbean();

    bean.setAcid(rs.getInt("acid"));
    bean.setAccount(rs.getString("account"));
    bean.setTran_date(rs.getString("tran_date"));
    bean.setAmount(rs.getDouble("amount"));
    bean.setUserid(rs.getInt("userid"));
    bean.setOperation(rs.getString("operation"));
al.add(bean);
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

 public b_bookbean find(int id) {
        b_bookbean bean = new b_bookbean();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from cash_book where  acid = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {


    bean.setAcid(rs.getInt("acid"));
    bean.setAccount(rs.getString("account"));
    bean.setTran_date(rs.getString("tran_date"));
    bean.setAmount(rs.getDouble("amount"));
    bean.setUserid(rs.getInt("userid"));
    bean.setOperation(rs.getString("operation"));

            }
        } catch (Exception ex) {
           System.out.println(ex);
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }


 public ArrayList<c_bookbean> findAll(String sdate,String edate,int userid)
    {
            ArrayList<c_bookbean> al= new ArrayList<c_bookbean>();
            ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection  conn =c.getConnection();
            try
            {
 String sql="select * from cash_book where userid=?";
 PreparedStatement pstm = conn.prepareStatement(sql);
 pstm.setInt(1,userid);
 ResultSet rs=pstm.executeQuery();
SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy");

 Date curDate = (Date)formatter.parse(sdate);
  Date curDate2 = (Date)formatter.parse(edate);
 
while(rs.next())
{
    c_bookbean bean=new c_bookbean();

    bean.setAcid(rs.getInt("acid"));
    bean.setAccount(rs.getString("account"));
    bean.setTran_date(rs.getString("tran_date"));
    bean.setAmount(rs.getDouble("amount"));
    bean.setUserid(rs.getInt("userid"));
    bean.setOperation(rs.getString("operation"));
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





public double closingBalance()
    {
double sum=0.0,sum1=0.0;
 ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection  conn =c.getConnection();
            try
            {
                String sql ="select amount from cash_book where userid=1 and operation='receiv'";
                PreparedStatement pstm = conn.prepareStatement(sql);
                ResultSet rs=pstm.executeQuery();
 while(rs.next())
 {
     sum=sum+rs.getDouble("amount");
 }
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
             try
            {
                String sql ="select amount from cash_book where userid=1 and operation='pay'";
                PreparedStatement pstm = conn.prepareStatement(sql);
                ResultSet rs=pstm.executeQuery();
 while(rs.next())
 {
     sum1=sum1+rs.getDouble("amount");
 }
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
            finally{
                c.putConnection(conn);
                
            }
return (sum-sum1);
}


















public static void main(String []args)
    {
    c_bookDAO bd=new c_bookDAO();
  
 /*ArrayList<b_bookbean> cb = bd.findAll("1-8-2013","4-8-2013",1);
        for (b_bookbean c : cb) {
       System.out.println(c.getTran_date());
        }
 */
//System.out.println(bd.closingBalance());
// c_bookbean bn=new c_bookbean(6,"1111","06-08-2013",100000,1,"pay");
   // bd.create(bn);

c_bookbean bn=new c_bookbean(4,"3333",5000);

bd.edit(bn);
}
}
