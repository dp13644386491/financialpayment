package com.jr.dao.impl;

import com.jr.dao.IReviewrecordDao;
import com.jr.entry.Reviewrecord;
import com.jr.util.DBHelper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewrecordDaoImpl implements IReviewrecordDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    /*
     * 插入审核记录
     * */
    @Override
    public int insertReviewrecord(Reviewrecord reviewrecord) {

        return 0;
    }

    /*
     * 根据开单no查询审核记录信息
     * */
    @Override
    public Reviewrecord queryReviewrecord(int no) {
        Reviewrecord reviewrecord=null;
        try {
            con = DBHelper.getConn();
            String sql="SELECT * FROM reviewrecord WHERE ticket_open_id=(SELECT id FROM ticket_open WHERE no=?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1,no);
            rs = ps.executeQuery();
            while (rs.next()){
                reviewrecord = new Reviewrecord();
                reviewrecord.setRemark(rs.getString("remark"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviewrecord;
    }
}
