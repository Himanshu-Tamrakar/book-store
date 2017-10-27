/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package users;


import connection.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author monty
 */
public class userDAO {
    public void create(userbean bean)
                      {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Insert into users(username,password,name,address,mobile,email )values(?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bean.getUsername());
                pstmt.setString(2, bean.getPassword());
                pstmt.setString(3, bean.getName());
pstmt.setString(4, bean.getAddress());
pstmt.setString(5, bean.getMobile());
pstmt.setString(6, bean.getEmail());
                pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }


  public void edit(userbean bean) {
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Update users set address=?,mobile=?,email=? where username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getAddress());
            pstmt.setString(2, bean.getMobile());
            pstmt.setString(3, bean.getEmail());
            pstmt.setString(4, bean.getUsername());
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
            String sql = "delete from users where uid= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            c.putConnection(conn);
        }
    }



 public ArrayList<userbean> findAll() {
        ArrayList<userbean> al = new ArrayList<userbean>();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            conn = c.getConnection();
            String sql = "Select * from users";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                userbean bean = new userbean();
                bean.setUid(rs.getInt("uid"));
                bean.setUsername(rs.getString("username"));
                bean.setPassword(rs.getString("password"));
                bean.setName(rs.getString("name"));
 bean.setAddress(rs.getString("addres"));
 bean.setMobile(rs.getString("mobile"));
bean.setEmail(rs.getString("email"));
 al.add(bean);
            }
        } catch (Exception e) {
            System.out.println("Exception " + e);
        } finally {
            c.putConnection(conn);
        }
        return al;
    }
public userbean find(int id) {
        userbean bean = new userbean();
        ConnectionPool c = ConnectionPool.getInstance();
        c.initialize();
        Connection conn = c.getConnection();
        try {
            String sql = "Select * from users where  uid = ? ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {


    bean.setUid(rs.getInt("uid"));
    bean.setUsername(rs.getString("username"));
    bean.setPassword(rs.getString("password"));
    bean.setName(rs.getString("name"));
    bean.setAddress(rs.getString("address"));
    bean.setEmail(rs.getString("email"));
    bean.setMobile(rs.getString("mobile"));


            }
        } catch (Exception ex) {
           System.out.println(ex);
        } finally {
            c.putConnection(conn);
        }
        return bean;
    }

public int checkAvailable(String uname)
    {
    int id=0;
  ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection  conn =c.getConnection();

  try {
          String sql="select * from users where username=?";
          PreparedStatement pstm = conn.prepareStatement(sql);
          pstm.setString(1,uname);
          ResultSet rs=pstm.executeQuery();
          while(rs.next()){
          id=rs.getInt("uid");

          }
        }
         catch (Exception ex) {
           System.out.println(ex);
        } finally {
            c.putConnection(conn);
        }
return(id);
}

public userbean authentication(String uname,String pass)
    {
 userbean bean=new userbean();
  ConnectionPool c=ConnectionPool.getInstance();
            c.initialize();
            Connection  conn =c.getConnection();

  try {
          String sql="select * from users where username=? and password=?";
          PreparedStatement pstm = conn.prepareStatement(sql);
          pstm.setString(1,uname);
          pstm.setString(2,pass);
          ResultSet rs=pstm.executeQuery();

          while(rs.next()){

          bean.setUid(rs.getInt("uid"));
         bean.setUsername(rs.getString("username"));
bean.setPassword(rs.getString("password"));
bean.setName(rs.getString("name"));
bean.setAddress(rs.getString("address"));
          bean.setMobile(rs.getString("mobile"));
          bean.setEmail(rs.getString("email"));
          }
        }
         catch (Exception ex) {
           System.out.println(ex);
        } finally {
            c.putConnection(conn);
        }
return bean;
}
//
//public static void main(String []args)
  //  {
    //userDAO ud=new userDAO();
    //ud.remove(1);
//}









}
