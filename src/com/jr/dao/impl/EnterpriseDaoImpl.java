package com.jr.dao.impl;

import com.jr.dao.IEnterpriseDao;
import com.jr.entry.Enterprise;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnterpriseDaoImpl implements IEnterpriseDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Enterprise enterprise1=null;
    /*
     * 根据企业id查询企业信息
     * */
    @Override
    public Enterprise queryByid(Enterprise enterprise) {

        try {
            con = DBHelper.getConn();
            String sql = "SELECT *  FROM enterprise where id=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,enterprise.getId());
            rs = ps.executeQuery();

            while(rs.next()){
                enterprise1=new Enterprise();
                enterprise1.setId(rs.getInt(1));
                enterprise1.setName(rs.getString(2));
                enterprise1.setSocialUniformCcode(rs.getString(3));
                enterprise1.setEmail(rs.getString(4));
                enterprise1.setPhone(rs.getString(5));
                enterprise1.setAddress(rs.getString(6));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enterprise1;

    }

    /*
     *查询所有企业名称
     * */
    @Override
    public List<Enterprise> queryAllEnterpriseNames() {
        List<Enterprise> list = new ArrayList<>();
        try {
            con = DBHelper.getConn();
            String sql = "SELECT id,name ,social_uniform_code FROM enterprise";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Enterprise enterprise = new Enterprise();
                enterprise.setId(rs.getInt(1));
                enterprise.setName(rs.getString(2));
                enterprise.setSocialUniformCcode(rs.getString(3));
                list.add(enterprise);
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
    public Enterprise queryIdAndSocialUniformCodeByEnterpriseName(Enterprise enterprise) {
        try {
            con = DBHelper.getConn();
            String sql = "SELECT id,social_uniform_code FROM enterprise where name =?";
            ps = con.prepareStatement(sql);
            ps.setString(1,enterprise.getName());
            rs = ps.executeQuery();
            while(rs.next()){

                enterprise.setId(rs.getInt(1));
                enterprise.setSocialUniformCcode(rs.getString(2));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enterprise1;
    }

    @Override
    public Enterprise querydeletone(Enterprise enterprise) {
        try {
            con = DBHelper.getConn();
            String sql = "SELECT name  FROM enterprise ";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){

                enterprise1.setName(rs.getString(1));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enterprise1;
    }
}
