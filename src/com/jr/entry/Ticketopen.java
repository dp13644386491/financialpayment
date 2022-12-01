package com.jr.entry;

import java.util.Date;
//开单表对应的实体类
public class Ticketopen {
    private int id;//开单表的id
    private String no;//凭证编号
    private String enterPriseId;//开单企业id
    private String acquirerEnterPriseId;//收单企业id
    private double amount;//凭证金额
    private int institutyId;//金融机构主键id
    private Date createTime;//开单日期
    private Date expiryTime;//到期日期
    private String paymentInterestType;//付息方式
    private String status;//票据状态
    private String uplinkAddress;//上链地址
    private String ticketRemark;//开单备注

    public Ticketopen() {
    }

    public Ticketopen(int id, String no, String enterPriseId,
                      String acquirerEnterPriseId, double amount, int institutyId, Date createTime, Date expiryTime,
                      String paymentInterestType, String status, String uplinkAddress, String ticketRemark) {
        this.id = id;
        this.no = no;
        this.enterPriseId = enterPriseId;
        this.acquirerEnterPriseId = acquirerEnterPriseId;
        this.amount = amount;
        this.institutyId = institutyId;
        this.createTime = createTime;
        this.expiryTime = expiryTime;
        this.paymentInterestType = paymentInterestType;
        this.status = status;
        this.uplinkAddress = uplinkAddress;
        this.ticketRemark = ticketRemark;
    }

    public String getTicketRemark() {
        return ticketRemark;
    }

    public void setTicketRemark(String ticketRemark) {
        this.ticketRemark = ticketRemark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEnterPriseId() {
        return enterPriseId;
    }

    public void setEnterPriseId(String enterPriseId) {
        this.enterPriseId = enterPriseId;
    }

    public String getAcquirerEnterPriseId() {
        return acquirerEnterPriseId;
    }

    public void setAcquirerEnterPriseId(String acquirerEnterPriseId) {
        this.acquirerEnterPriseId = acquirerEnterPriseId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getInstitutyId() {
        return institutyId;
    }

    public void setInstitutyId(int institutyId) {
        this.institutyId = institutyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getPaymentInterestType() {
        return paymentInterestType;
    }

    public void setPaymentInterestType(String paymentInterestType) {
        this.paymentInterestType = paymentInterestType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUplinkAddress() {
        return uplinkAddress;
    }

    public void setUplinkAddress(String uplinkAddress) {
        this.uplinkAddress = uplinkAddress;
    }

    @Override
    public String toString() {
        return "Ticketopen{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", enterPriseId='" + enterPriseId + '\'' +
                ", acquirerEnterPriseId='" + acquirerEnterPriseId + '\'' +
                ", amount=" + amount +
                ", institutyId=" + institutyId +
                ", createTime=" + createTime +
                ", expiryTime=" + expiryTime +
                ", paymentInterestType='" + paymentInterestType + '\'' +
                ", status='" + status + '\'' +
                ", uplinkAddress='" + uplinkAddress + '\'' +
                ", ticketRemark='" + ticketRemark + '\'' +
                '}';
    }
}
