package com.jr.dao;


import com.jr.entry.Ticketopen;
import com.jr.util.PageHelper;
import com.jr.util.SqlHelper;

import java.util.List;

public interface ITicketOpenDao {
    /*
     * 查询符合条件的所有状态的开单信息（开单）
     * */
    public List<Ticketopen> queryAllByConditions(String str);

    /*
     * 查询符合条件的开单中的开单信息（复核）
     * */
    public List<Ticketopen> queryAllByConditionsOnTheBill(SqlHelper sqlHelper);

    /*
     * 添加开单信息
     * */
    public int insertTicket(Ticketopen ticketopen);

    /**
     * 根据开单id更改票据状态
     */
    public int alertTicketStatus(Ticketopen ticketopen);

    /**
     * 查询全部数据条数
     */
    public int queryCountNum(SqlHelper sqlHelper);

    /**
     * 查询分页信息集合
     */
    public List<Ticketopen> QueryByPage(PageHelper pageHelper,SqlHelper sqlHelper);

}
