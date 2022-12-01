package com.jr.entry;

import java.util.Date;
//审核记录表实体类
public class Reviewrecord {
    private int id;//审核记录id
    private int ticketOpenId;//开单主键id
    private int creatorId;//创建人id
    private Date createTime;//创建时间
    private String reviewStatus;//审核状态
    private String remark;//审核备注

    public Reviewrecord(int id, int ticketOpenId, int creatorId, Date createTime, String reviewStatus, String remark) {
        this.id = id;
        this.ticketOpenId = ticketOpenId;
        this.creatorId = creatorId;
        this.createTime = createTime;
        this.reviewStatus = reviewStatus;
        this.remark = remark;
    }

    public Reviewrecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketOpenId() {
        return ticketOpenId;
    }

    public void setTicketOpenId(int ticketOpenId) {
        this.ticketOpenId = ticketOpenId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(String reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Reviewrecord{" +
                "id=" + id +
                ", ticketOpenId=" + ticketOpenId +
                ", creatorId=" + creatorId +
                ", createTime=" + createTime +
                ", reviewStatus='" + reviewStatus + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
