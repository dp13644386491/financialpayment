package com.jr.util;

import java.util.Date;

public class ViewOpenEnterprise {
    private String no;//凭证编号
    private String enterPriseId;//开单企业id
    private String acquirerEnterPriseId;//收单企业id
    private String amount;//凭证金额
    private String institutyId;//金融机构主键id
    private String createTime;//开单日期
    private String expiryTime;//到期日期
    private String status;//票据状态
    private String uplinkAddress;//上链地址
    private String enterPriseName;//开单企业名称
    private String acquirerEnterPriseName;//收单企业名称
    private String institutyName;//金融机构名称


    public ViewOpenEnterprise() {
    }

    public ViewOpenEnterprise(String no, String enterPriseId, String acquirerEnterPriseId, String amount, String institutyId, String createTime, String expiryTime, String status, String uplinkAddress, String enterPriseName, String acquirerEnterPriseName, String institutyName) {
        this.no = no;
        this.enterPriseId = enterPriseId;
        this.acquirerEnterPriseId = acquirerEnterPriseId;
        this.amount = amount;
        this.institutyId = institutyId;
        this.createTime = createTime;
        this.expiryTime = expiryTime;
        this.status = status;
        this.uplinkAddress = uplinkAddress;
        this.enterPriseName = enterPriseName;
        this.acquirerEnterPriseName = acquirerEnterPriseName;
        this.institutyName = institutyName;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInstitutyId() {
        return institutyId;
    }

    public void setInstitutyId(String institutyId) {
        this.institutyId = institutyId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
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

    public String getEnterPriseName() {
        return enterPriseName;
    }

    public void setEnterPriseName(String enterPriseName) {
        this.enterPriseName = enterPriseName;
    }

    public String getAcquirerEnterPriseName() {
        return acquirerEnterPriseName;
    }

    public void setAcquirerEnterPriseName(String acquirerEnterPriseName) {
        this.acquirerEnterPriseName = acquirerEnterPriseName;
    }

    public String getInstitutyName() {
        return institutyName;
    }

    public void setInstitutyName(String institutyName) {
        this.institutyName = institutyName;
    }

    @Override
    public String toString() {
        return "ViewOpenEnterprise{" +
                "no='" + no + '\'' +
                ", enterPriseId='" + enterPriseId + '\'' +
                ", acquirerEnterPriseId='" + acquirerEnterPriseId + '\'' +
                ", amount=" + amount +
                ", institutyId=" + institutyId +
                ", createTime=" + createTime +
                ", expiryTime=" + expiryTime +
                ", status='" + status + '\'' +
                ", uplinkAddress='" + uplinkAddress + '\'' +
                ", enterPriseName='" + enterPriseName + '\'' +
                ", acquirerEnterPriseName='" + acquirerEnterPriseName + '\'' +
                ", institutyName='" + institutyName + '\'' +
                '}';
    }
}
