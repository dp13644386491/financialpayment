package com.jr.biz;

import com.jr.entry.Ticketopen;
import com.jr.entry.User;
import com.jr.util.PageHelper;
import com.jr.util.SqlHelper;
import com.jr.util.ViewOpenEnterprise;

import java.util.List;

public interface ITicketopenBiz {
    /*
    * 获取符合条件的所有状态的开单信息（开单）
    * */
    public List<Ticketopen> getAllByConditions(String str);

    /*
    * 获取符合条件的开单中的开单信息（复核）
    * */
    public List<Ticketopen> getAllByConditionsOnTheBill(SqlHelper sqlHelper);

    /*
    * 添加开单信息
    * */
    public int addTicket(Ticketopen ticketopen);

    /**
     * 更新开单状态
     */
    public int updateTicketopenStatus(Ticketopen ticketopen);

    /*
     * 分页查询总页数方法
     * */
    public int getAllnum(SqlHelper sqlHelper);

    /*
     * 分页根据页数查询方法
     * */
    public List<ViewOpenEnterprise> getBypage(PageHelper pageHelper, SqlHelper sqlHelper);
    /*
    根据凭证编号查开单id
     */
    public Ticketopen quaryIdByNo(Ticketopen ticketopen);
}
