package com.jr.dao;

import com.jr.entry.Reviewrecord;
import com.jr.entry.Ticketopen;

public interface IReviewrecordDao {
    /*
     * 插入审核记录
     * */
    public int insertReviewrecord(Reviewrecord reviewrecord);

    /*
     * 根据开单no查询审核记录信息
     * */
    public Reviewrecord queryReviewrecord(String no);

    /*
     * 根据开单id修改审核记录信息为C：审核未通过，修改备注
     * */
    public int updateReviewrecord(Reviewrecord reviewrecord);

    /*
     * 根据开单id修改审核记录信息为B：审核通过；，修改备注
     * */
    public int updateReviewrecord1(Reviewrecord reviewrecord);
}
