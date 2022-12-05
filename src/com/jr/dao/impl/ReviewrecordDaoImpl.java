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
      String sql="insert into review_record values(null,?,?,?,?,null)";
        return upd(sql,reviewrecord.getTicketOpenId(),reviewrecord.getCreatorId(),reviewrecord.getCreateTime(),reviewrecord.getReviewStatus());
    }

    /*
     * 根据开单no查询审核记录信息
     * */
    @Override
    public Reviewrecord queryReviewrecord(String no) {
        Reviewrecord reviewrecord=null;
        try {
            con = DBHelper.getConn();
            String sql="SELECT * FROM review_record WHERE ticket_open_id=(SELECT id FROM ticket_open WHERE no=?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,no);
            rs = ps.executeQuery();
            while (rs.next()){
                reviewrecord = new Reviewrecord();
                reviewrecord.setRemark(rs.getString("remark"));
                String status=rs.getString("review_status");
                if(status.equals("A")){
                    reviewrecord.setReviewStatus("审核中");
                }
                if(status.equals("B")){
                    reviewrecord.setReviewStatus("审核通过");
                }
                if(status.equals("C")){
                    reviewrecord.setReviewStatus("审核未通过");
                }
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
    /**
     *增删改通用方法
     */
    public int upd(String sql, Object... objs) {

        int num = 0;
        try {
            con = DBHelper.getConn();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
            num = ps.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeAll(rs, ps, con);
        }
        return num;
    }

    /*
     * 根据开单id修改审核记录信息为C：审核未通过，修改备注
     * */
    @Override
    public int updateReviewrecord(Reviewrecord reviewrecord) {
        String sql="UPDATE review_record SET review_status='C',remark=? WHERE ticket_open_id=?";
        int num=upd(sql,reviewrecord.getRemark(),reviewrecord.getTicketOpenId());
        return num;
    }

    /*
     * 根据开单id修改审核记录信息为B：审核通过；，修改备注
     * */
    @Override
    public int updateReviewrecord1(Reviewrecord reviewrecord) {
        String sql="UPDATE review_record SET review_status='B',remark=? WHERE ticket_open_id=?";
        int num=upd(sql,reviewrecord.getRemark(),reviewrecord.getTicketOpenId());
        return num;
    }

}
