package com.jr.dao.impl;

import com.jr.dao.ITicketOpenDao;
import com.jr.entry.Ticketopen;
import com.jr.util.DBHelper;
import com.jr.util.PageHelper;
import com.jr.util.SqlHelper;
import com.jr.util.ViewOpenEnterprise;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
     String sql="insert into ticket_open values(null,?,?,?,?,?,?,?,?,?,?,?)";
     int i=upd(sql,ticketopen.getNo(),ticketopen.getEnterPriseId(),ticketopen.getAcquirerEnterPriseId(),ticketopen.getAmount(), ticketopen.getInstitutyId(),ticketopen.getCreateTime(),ticketopen.getExpiryTime(),ticketopen.getPaymentInterestType(),ticketopen.getStatus(),ticketopen.getUplinkAddress(),ticketopen.getTicketRemark());
       return i ;
    }

    /**
     * 根据开单no更改票据状态为D：复核未通过
     */
    @Override
    public int alertTicketStatus(Ticketopen ticketopen) {
        String sql="UPDATE ticket_open SET status='D' WHERE no=?";
        int num=upd(sql,ticketopen.getNo());
        return num;
    }

    /**
     * 更新开单状态为A：成功
     */
    @Override
    public int alertTicketStatus1(Ticketopen ticketopen) {
        String sql="UPDATE ticket_open SET status='A' WHERE no=?";
        int num=upd(sql,ticketopen.getNo());
        return num;
    }

    /**
     * 查询全部数据条数status='B'
     */
    @Override
    public int queryCountNum(SqlHelper sqlHelper) {
        int num=0;
        try {
            con=DBHelper.getConn();
            String sql = "SELECT COUNT(no) FROM v_open_enterpise WHERE status='B'" + sqlHelper.sqlConcat();
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
     * 查询分页信息集合status='B'
     */
    @Override
    public List<ViewOpenEnterprise> QueryByPage(PageHelper pageHelper, SqlHelper sqlHelper) {
        List<ViewOpenEnterprise> list=new ArrayList<>();
        try {
            con=DBHelper.getConn();
            String sql="select * from v_open_enterpise WHERE status='B'" + sqlHelper.sqlConcat()+" limit ?,?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,pageHelper.getStartNum());
            ps.setInt(2,pageHelper.getPageSize());
            rs=ps.executeQuery();
            while(rs.next()){
                ViewOpenEnterprise viewOpenEnterprise = new ViewOpenEnterprise();
                viewOpenEnterprise.setNo(rs.getString("no"));
                viewOpenEnterprise.setAcquirerEnterPriseId(rs.getString("acquirer_enterprise_id"));
                viewOpenEnterprise.setAmount(rs.getString("amount"));
                viewOpenEnterprise.setEnterPriseId(rs.getString("enterprise_id"));
                viewOpenEnterprise.setInstitutyId(rs.getString("instituty_id"));
                viewOpenEnterprise.setCreateTime(rs.getString("create_time"));
                viewOpenEnterprise.setExpiryTime(rs.getString("expiry_time"));
                viewOpenEnterprise.setUplinkAddress(rs.getString("uplink_address"));
                viewOpenEnterprise.setEnterPriseName(rs.getString("enterprise_name"));
                viewOpenEnterprise.setAcquirerEnterPriseName(rs.getString("acquirer_enterprise_name"));
                viewOpenEnterprise.setInstitutyName(rs.getString("instituty_name"));
                list.add(viewOpenEnterprise);
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
     * 查询全部数据条数
     */
    @Override
    public int queryCountNum1(SqlHelper sqlHelper) {
        int num=0;
        try {
            con=DBHelper.getConn();
            String sql = "SELECT COUNT(no) FROM v_open_enterpise WHERE no IS NOT NULL" + sqlHelper.sqlConcat();
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
    public List<ViewOpenEnterprise> QueryByPage1(PageHelper pageHelper, SqlHelper sqlHelper) {
        List<ViewOpenEnterprise> list=new ArrayList<>();
        try {
            con=DBHelper.getConn();
            String sql="select * from v_open_enterpise WHERE no IS NOT NULL" + sqlHelper.sqlConcat()+" limit ?,?";
            ps=con.prepareStatement(sql);
            ps.setInt(1,pageHelper.getStartNum());
            ps.setInt(2,pageHelper.getPageSize());
            rs=ps.executeQuery();
            while(rs.next()){
                ViewOpenEnterprise viewOpenEnterprise = new ViewOpenEnterprise();
                viewOpenEnterprise.setNo(rs.getString("no"));
                viewOpenEnterprise.setAcquirerEnterPriseId(rs.getString("acquirer_enterprise_id"));
                viewOpenEnterprise.setAmount(rs.getString("amount"));
                String status=rs.getString("status");
                if(status.equals("A")){
                    viewOpenEnterprise.setStatus("成功");
                }
                if(status.equals("B")){
                    viewOpenEnterprise.setStatus("开单中");
                }
                if(status.equals("C")){
                    viewOpenEnterprise.setStatus("已撤销");
                }
                if(status.equals("D")){
                    viewOpenEnterprise.setStatus("复核未成功");
                }
                viewOpenEnterprise.setEnterPriseId(rs.getString("enterprise_id"));
                viewOpenEnterprise.setInstitutyId(rs.getString("instituty_id"));
                viewOpenEnterprise.setCreateTime(rs.getString("create_time"));
                viewOpenEnterprise.setExpiryTime(rs.getString("expiry_time"));
                viewOpenEnterprise.setUplinkAddress(rs.getString("uplink_address"));
                viewOpenEnterprise.setEnterPriseName(rs.getString("enterprise_name"));
                viewOpenEnterprise.setAcquirerEnterPriseName(rs.getString("acquirer_enterprise_name"));
                viewOpenEnterprise.setInstitutyName(rs.getString("instituty_name"));
                list.add(viewOpenEnterprise);
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

//根据编号查询id
    @Override
    public Ticketopen quaryIdByNo(Ticketopen ticketopen) {
          Ticketopen ticketopen1=new Ticketopen();
        try {
            con = DBHelper.getConn();
            String sql = "SELECT id FROM ticket_open where  no=?";
            ps = con.prepareStatement(sql);
            ps.setString(1,ticketopen.getNo());
            rs = ps.executeQuery();
            if (rs.next()){

                ticketopen1=new Ticketopen();
                ticketopen1.setId(rs.getInt(1));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticketopen1;
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
