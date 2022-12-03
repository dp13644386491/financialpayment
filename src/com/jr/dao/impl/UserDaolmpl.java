package com.jr.dao.impl;

import com.jr.dao.IUserDao;
import com.jr.entry.User;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaolmpl implements IUserDao {
    /**
     * 通过用户账号和用户密码查询指定用户
     */

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    User user1;

    @Override
    public User queryByAccountAndPassword(User user) {
        try {
            String sql="select *  from  user where account=? and password=?";
            con= DBHelper.getConn();
            ps=con.prepareStatement(sql);
           ps.setString(1,user.getAccount());
           ps.setString(2,user.getPassword());
            rs=ps.executeQuery();
            while(rs.next()){
                user1=new User();
           user1.setId(rs.getInt(1));
           user1.setName(rs.getNString(2));
           user1.setEnterPriseId(rs.getString(3));
           user1.setPhone(rs.getNString(4));
           user1.setAccount(rs.getString(5));
           user1.setPassword(rs.getString(6));
           user1.setIdcardName(rs.getString(7));
           user1.setIdcardNo(rs.getString(8));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(rs,ps,con);
        }
        return user1;
    }
}
