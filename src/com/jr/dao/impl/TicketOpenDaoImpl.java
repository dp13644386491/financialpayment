package com.jr.dao.impl;

import com.jr.dao.ITicketOpenDao;
import com.jr.entry.Ticketopen;
import com.jr.util.DBHelper;
import com.jr.util.PageHelper;
import com.jr.util.SqlHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TicketOpenDaoImpl implements ITicketOpenDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /*
     * 查询符合条件的所有状态的开单信息（开单）
     * 这里利用SqlHelper工具类返回的字符串进行查询
     * where后面需要加上一个 id is not null
     * */
    @Override
    public List<Ticketopen> queryAllByConditions(String str) {
        return null;
    }

    /*
     * 查询符合条件的开单中的开单信息（复核）
     * 这里利用SqlHelper工具类返回的字符串进行查询
     * where后面加上status='开单中'
     * */
    @Override
    public List<Ticketopen> queryAllByConditionsOnTheBill(SqlHelper sqlHelper) {
        List<Ticketopen> list = new ArrayList<>();
        try {
            con= DBHelper.getConn();
            String sql="SELECT * FROM ticket_open WHERE status='B' " +sqlHelper.sqlConcat();
            System.out.println(sql);
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Ticketopen ticketopen = new Ticketopen();
                ticketopen.setNo(rs.getString("no"));
                ticketopen.setAcquirerEnterPriseId(rs.getString("acquirer_enterprise_id"));
                ticketopen.setAmount(rs.getDouble("amount"));
                ticketopen.setEnterPriseId(rs.getString("enterprise_id"));
                ticketopen.setInstitutyId(rs.getInt("instituty_id"));
                ticketopen.setCreateTime((rs.getDate("create_time")));
                ticketopen.setExpiryTime(rs.getDate("expiry_time"));
                ticketopen.setUplinkAddress(rs.getString("uplink_address"));
                list.add(ticketopen);
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

        return list;
    }

    /*
     * 添加开单信息
     * */
    @Override
    public int insertTicket(Ticketopen ticketopen) {
     String sql="insert into ticket_open values(null,?,?,?,?,?,?,?,?,?,?)";
       int i=upd(sql);
       return  i;
    }

    /**
     * 根据开单id更改票据状态
     */
    @Override
    public int alertTicketStatus(Ticketopen ticketopen) {
        return 0;
    }

    /**
     * 查询全部数据条数
     */
    @Override
    public int queryCountNum(SqlHelper sqlHelper) {
        int num=0;
        try {
            con=DBHelper.getConn();
            String sql = "SELECT COUNT(id) FROM ticket_open WHERE status='B'" + sqlHelper.sqlConcat();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
                num=rs.getInt(1);
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
        return num;
    }

    /**
     * 查询分页信息集合
     */
    @Override
    public List<Ticketopen> QueryByPage(PageHelper pageHelper,SqlHelper sqlHelper) {
        List<Ticketopen> list=new ArrayList<>();
        try {
            con=DBHelper.getConn();
            String sql="select * from ticket_open WHERE status='B'" + sqlHelper.sqlConcat()+" limit ?,?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,pageHelper.getStartNum());
            ps.setInt(2,pageHelper.getPageSize());
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
                list.add(ticketopen);
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

        return list;
    }

    /**
     *增删改通用方法
     */
    public int upd(String sql, Object... objs) {

        int num = 0;
        try {
            con = DBHelper.getConn();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
            num = ps.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }
        return num;
    }



}
