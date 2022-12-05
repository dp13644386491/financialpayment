package com.jr.biz.impl;

import com.jr.biz.ITicketopenBiz;
import com.jr.dao.impl.TicketOpenDaoImpl;
import com.jr.entry.Ticketopen;
import com.jr.util.PageHelper;
import com.jr.util.SqlHelper;
import com.jr.util.ViewOpenEnterprise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class TicketopenBizImpl implements ITicketopenBiz {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    TicketOpenDaoImpl todi=new TicketOpenDaoImpl();

    /**
     * 获取符合条件的所有状态的开单信息（开单）
     * @param str
     * @return
     */
    @Override
    public List<Ticketopen> getAllByConditions(String str) {
        return null;
    }

    /**
     * 获取符合条件的开单中的开单信息（复核）
     * @param sqlHelper
     * @return
     */
    @Override
    public List<Ticketopen> getAllByConditionsOnTheBill(SqlHelper sqlHelper) {

        return todi.queryAllByConditionsOnTheBill(sqlHelper);
    }

    /**
     * 添加开单信息
     * @param ticketopen
     * @return
     */
    @Override
    public int addTicket(Ticketopen ticketopen) {

        return todi.insertTicket(ticketopen);
    }

    /**
     * 更新开单状态为D：复核未通过
     * @param ticketopen
     * @return
     */
    @Override
    public int updateTicketopenStatus(Ticketopen ticketopen) {

        return todi.alertTicketStatus(ticketopen);
    }

    /**
     * 更新开单状态为A：成功
     */
    @Override
    public int updateTicketopenStatus1(Ticketopen ticketopen) {
        return todi.alertTicketStatus1(ticketopen);
    }

    /**
     * 查询全部数据条数status='B'
     */
    @Override
    public int getAllnum(SqlHelper sqlHelper) {

        return todi.queryCountNum(sqlHelper);
    }

    /**
     * 查询分页信息集合status='B'
     */
    @Override
    public List<ViewOpenEnterprise> getBypage(PageHelper pageHelper, SqlHelper sqlHelper) {
        return todi.QueryByPage(pageHelper,sqlHelper);
    }

    /**
     * 查询分页信息集合
     */
    @Override
    public List<ViewOpenEnterprise> getBypage1(PageHelper pageHelper, SqlHelper sqlHelper) {
        return todi.QueryByPage1(pageHelper,sqlHelper);
    }

    /**
     * 查询全部数据条数
     */
    @Override
    public int getAllnum1(SqlHelper sqlHelper) {
        return todi.queryCountNum1(sqlHelper);
    }

    @Override
    public Ticketopen quaryIdByNo(Ticketopen ticketopen) {
        return todi.quaryIdByNo(ticketopen);
    }
}
