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
    /*
     * 根据企业id查询企业信息
     * */
    @Override
    public Enterprise queryByid(int id) {
        return null;
    }

    /*
     *查询所有企业名称
     * */
    @Override
    public List<Enterprise> queryAllEnterpriseNames() {
        List<Enterprise> list = new ArrayList<>();
        try {
            con = DBHelper.getConn();
            String sql = "SELECT id,name FROM enterprise";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Enterprise enterprise = new Enterprise();
                enterprise.setId(rs.getInt(1));
                enterprise.setName(rs.getString(2));
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
}
