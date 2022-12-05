package com.jr.dao;


import com.jr.entry.Ticketopen;
import com.jr.entry.User;
import com.jr.util.PageHelper;
import com.jr.util.SqlHelper;
import com.jr.util.ViewOpenEnterprise;

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
     * 根据开单no更改票据状态为D：复核未通过
     */
    public int alertTicketStatus(Ticketopen ticketopen);

    /**
     * 更新开单状态为A：成功
     */
    public int alertTicketStatus1(Ticketopen ticketopen);

    /**
     * 查询全部数据条数status='B'
     */
    public int queryCountNum(SqlHelper sqlHelper);

    /**
     * 查询分页信息集合status='B'
     */
    public List<ViewOpenEnterprise> QueryByPage(PageHelper pageHelper, SqlHelper sqlHelper);

    /**
     * 查询分页信息集合
     */
    public List<ViewOpenEnterprise> QueryByPage1(PageHelper pageHelper, SqlHelper sqlHelper);

    /**
     * 查询全部数据条数
     */
    public int queryCountNum1(SqlHelper sqlHelper);
    /*
   根据凭证编号查开单所有
    */
    public Ticketopen quaryAllByNo(Ticketopen ticketopen);
}
