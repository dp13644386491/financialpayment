package com.jr.biz.impl;
import com.jr.biz.IReviewrecordBiz;
import com.jr.dao.impl.ReviewrecordDaoImpl;
import com.jr.entry.Reviewrecord;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public Reviewrecord getReviewrecord(int no) {

        return rrdi.queryReviewrecord(no);
    }
}
