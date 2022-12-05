package com.jr.biz;

import com.jr.entry.Reviewrecord;

public interface IReviewrecordBiz {
    /*
    * 添加审核记录
    * */
    public int addReviewrecord(Reviewrecord reviewrecord);

    /*
    * 根据开单no获取审核记录信息
    * */
    public Reviewrecord getReviewrecord(String no);

    /*
    * 根据开单id修改审核记录信息为C：审核未通过，修改备注
    * */
    public  int changeeviewrecord(Reviewrecord reviewrecord);

    /*
     * 根据开单id修改审核记录信息为B：审核通过；，修改备注
     * */
    public  int changeeviewrecord1(Reviewrecord reviewrecord);
}
