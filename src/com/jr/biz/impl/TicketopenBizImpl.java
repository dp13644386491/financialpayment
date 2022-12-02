package com.jr.biz.impl;

import com.jr.biz.ITicketopenBiz;
import com.jr.dao.impl.TicketOpenDaoImpl;
import com.jr.entry.Ticketopen;
import com.jr.util.DBHelper;
import com.jr.util.PageHelper;
import com.jr.util.SqlHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        return 0;
    }

    /**
     * 更新开单状态
     * @param ticketopen
     * @return
     */
    @Override
    public int updateTicketopenStatus(Ticketopen ticketopen) {
        return 0;
    }

    @Override
    public int getAllnum(SqlHelper sqlHelper) {

        return todi.queryCountNum(sqlHelper);
    }

    @Override
    public List<Ticketopen> getBypage(PageHelper pageHelper,SqlHelper sqlHelper) {
        return todi.QueryByPage(pageHelper,sqlHelper);
    }
}
