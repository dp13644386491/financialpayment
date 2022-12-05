package com.jr.biz.impl;
import com.jr.biz.IReviewrecordBiz;
import com.jr.dao.impl.ReviewrecordDaoImpl;
import com.jr.entry.Reviewrecord;

public class ReviewrecordBizImpl implements IReviewrecordBiz {

    ReviewrecordDaoImpl rrdi = new ReviewrecordDaoImpl();
    /**
     * 添加审核记录
     * @param reviewrecord
     * @return
     */
    @Override
    public int addReviewrecord(Reviewrecord reviewrecord) {

        return rrdi.insertReviewrecord(reviewrecord);
    }

    /**
     * 根据开单no获取审核记录信息
     * @return
     */
    @Override
    public Reviewrecord getReviewrecord(String no) {

        return rrdi.queryReviewrecord(no);
    }

    /*
     * 根据开单id修改审核记录信息为C：审核未通过，修改备注
     * */
    @Override
    public int changeeviewrecord(Reviewrecord reviewrecord) {
        return rrdi.updateReviewrecord(reviewrecord);
    }

    /*
     * 根据开单id修改审核记录信息为B：审核通过；，修改备注
     * */
    @Override
    public int changeeviewrecord1(Reviewrecord reviewrecord) {
        return 0;
    }
}
