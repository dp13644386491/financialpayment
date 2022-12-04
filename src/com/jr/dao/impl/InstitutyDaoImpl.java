package com.jr.dao.impl;

import com.jr.dao.IInstitutyDao;
import com.jr.entry.Enterprise;
import com.jr.entry.Instituty;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstitutyDaoImpl implements IInstitutyDao {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;


    /*
     *查询所有金融机构名称
     * */
    @Override
    public List<Instituty> queryAllNames() {
        Instituty instituty1=null;
        List<Instituty> list = new ArrayList<>();
        try {
            con = DBHelper.getConn();
            String sql = "SELECT * FROM instituty";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
               instituty1=new Instituty();
              instituty1.setId(rs.getInt(1));
              instituty1.setName(rs.getString(2));
                list.add(instituty1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Instituty quaryIdByname(Instituty instituty) {
        Instituty instituty1=null;

        try {
            con = DBHelper.getConn();
            String sql = "SELECT id FROM instituty where name =?";
            ps = con.prepareStatement(sql);
            ps.setString(1,instituty.getName());
            rs = ps.executeQuery();
            if (rs.next()){
                instituty1=new Instituty();
                instituty1.setId(rs.getInt(1));


            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instituty1;
    }
}
