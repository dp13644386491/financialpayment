package com.jr.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewUtility {

    private String ticket_id;
    private String no;
    private String status;
    private String openename;//开单企业
    private String openescu;//开单企业统一社会信用码
    private String receiptename;//收单企业
    private String receiptescu;//
    private String amount;
    private String institutyname;//金融机构
    private String createTime;
    private String expriyTime;
    private String paymentInterestItype;
    private String ticketRemark;


    public String getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(String ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOpenename() {
        return openename;
    }

    public void setOpenename(String openename) {
        this.openename = openename;
    }

    public String getOpenescu() {
        return openescu;
    }

    public void setOpenescu(String openescu) {
        this.openescu = openescu;
    }

    public String getReceiptename() {
        return receiptename;
    }

    public void setReceiptename(String receiptename) {
        this.receiptename = receiptename;
    }

    public String getReceiptescu() {
        return receiptescu;
    }

    public void setReceiptescu(String receiptescu) {
        this.receiptescu = receiptescu;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getInstitutyname() {
        return institutyname;
    }

    public void setInstitutyname(String institutyname) {
        this.institutyname = institutyname;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getExpriyTime() {
        return expriyTime;
    }

    public void setExpriyTime(String expriyTime) {
        this.expriyTime = expriyTime;
    }

    public String getPaymentInterestItype() {
        return paymentInterestItype;
    }

    public void setPaymentInterestItype(String paymentInterestItype) {
        this.paymentInterestItype = paymentInterestItype;
    }

    public String getTicketRemark() {
        return ticketRemark;
    }

    public void setTicketRemark(String ticketRemark) {
        this.ticketRemark = ticketRemark;
    }

    public ViewUtility() {
    }
    public ViewUtility(String ticket_id, String no, String status,
                       String openename, String openescu, String receiptename,
                       String receiptescu, String amount, String institutyname,
                       String createTime, String expriyTime, String paymentInterestItype,
                       String ticketRemark) {
        this.ticket_id = ticket_id;
        this.no = no;
        this.status = status;
        this.openename = openename;
        this.openescu = openescu;
        this.receiptename = receiptename;
        this.receiptescu = receiptescu;
        this.amount = amount;
        this.institutyname = institutyname;
        this.createTime = createTime;
        this.expriyTime = expriyTime;
        this.paymentInterestItype = paymentInterestItype;
        this.ticketRemark = ticketRemark;
    }

    @Override
    public String toString() {
        return "ViewUtility{" +
                "ticket_id='" + ticket_id + '\'' +
                ", no='" + no + '\'' +
                ", status='" + status + '\'' +
                ", openename='" + openename + '\'' +
                ", openescu='" + openescu + '\'' +
                ", receiptename='" + receiptename + '\'' +
                ", receiptescu='" + receiptescu + '\'' +
                ", amount='" + amount + '\'' +
                ", institutyname='" + institutyname + '\'' +
                ", createTime='" + createTime + '\'' +
                ", expriyTime='" + expriyTime + '\'' +
                ", paymentInterestItype='" + paymentInterestItype + '\'' +
                ", ticketRemark='" + ticketRemark + '\'' +
                '}';
    }

    public static ViewUtility sleectInfoView(String no) {
        ViewUtility viewUtility1 = null;
        Connection getconn=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
             getconn = DBHelper.getConn();
            String sql = "select * from infoview where  no=?";
            preparedStatement = getconn.prepareStatement(sql);
            preparedStatement.setString(1, no);
             resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                viewUtility1 = new ViewUtility();
                viewUtility1.setTicket_id(resultSet.getString("ticket_id"));
                viewUtility1.setNo(resultSet.getString("no"));
                String status=resultSet.getString("status");
                if(status.equals("A")){
                    viewUtility1.setStatus("成功");
                }else if(status.equals("B")){
                    viewUtility1.setStatus("开单中");
                }else if(status.equals("C")){
                    viewUtility1.setStatus("已撤销");
                }else if(status.equals("D")){
                    viewUtility1.setStatus("复核未通过");
                }
                viewUtility1.setOpenename(resultSet.getString("openename"));
                viewUtility1.setOpenescu(resultSet.getString("openesuc"));
                viewUtility1.setReceiptename(resultSet.getString("receiptename"));
                viewUtility1.setReceiptescu(resultSet.getString("receiptesuc"));
                viewUtility1.setAmount(resultSet.getString("amount"));
                viewUtility1.setInstitutyname(resultSet.getString("institutyname"));
                viewUtility1.setCreateTime(resultSet.getString("create_time"));
                viewUtility1.setExpriyTime(resultSet.getString("expiry_time"));
                String pit = resultSet.getString("payment_interest_type");
                if(pit.equals("A")){
                    viewUtility1.setPaymentInterestItype("融资方付息");
                }else if(pit.equals("B")){
                    viewUtility1.setPaymentInterestItype("核心企业付息");
                }
                viewUtility1.setTicketRemark(resultSet.getString("ticket_remark"));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBHelper.closeAll(resultSet,preparedStatement,getconn);
        }
        return viewUtility1;
    }
}
