package com.jr.dao.impl;

import com.jr.dao.IEnterpriseDao;
import com.jr.entry.Enterprise;
import com.jr.entry.Ticketopen;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public Enterprise queryByid(int id) {
        return null;
    }

    /*
     *查询所有企业名称
     * */
    @Override
    public List<Enterprise> queryAllEnterpriseNames() {
        return null;
    }

    @Override
    public Enterprise queryIdAndSocialUniformCodeByEnterpriseName(Enterprise enterprise) {

        try {
            con= DBHelper.getConn();
            String sql="select * from province limit ?,?";
            ps=con.prepareStatement(sql);
//            ps.setInt(1,pageHelper.getStartNum());
//            ps.setInt(2,pageHelper.getPageSize());
            rs=ps.executeQuery();
            while(rs.next()){
                Ticketopen ticketopen = new Ticketopen();
                ticketopen.setNo(rs.getString("no"));
                ticketopen.setAcquirerEnterPriseId(rs.getString("acquirer_enterprise_id"));
                ticketopen.setAmount(rs.getDouble("amount"));
                ticketopen.setEnterPriseId(rs.getString("enterprise_id"));
                ticketopen.setInstitutyId(rs.getInt("instituty_id"));
                ticketopen.setCreateTime(rs.getDate("create_time"));
                ticketopen.setExpiryTime(rs.getDate("expiry_time"));
                ticketopen.setUplinkAddress(rs.getString("uplink_address"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,con);
        }

        return enterprise1;
    }


}
