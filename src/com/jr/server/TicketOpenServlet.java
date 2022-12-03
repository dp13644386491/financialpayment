package com.jr.server;

import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.entry.Ticketopen;
import com.jr.util.MD5Util;

import javax.lang.model.element.NestingKind;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketOpenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    /**
     * 获取所有ticketopen开单表中的信息
     */
    protected void getAllTicketopeninfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
/**
 * 获取所有符合条件的ticketopen开单表信息
 * 这里使用前台异步查询,提供了字符串拼接工具类
 * 可以直接在里边拼接所需要属性的字符串
 * */
    protected void getTicketopeninfoByconditions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    /**
     * 添加开单表信息
     */
   protected  void  insertTicketopencondition(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ParseException {
       request.setCharacterEncoding("UTF-8");
       response.setCharacterEncoding("UTF-8");
       response.setContentType("text/html;charset=UTF-8");
       String no=request.getParameter("no");
       String enterPriseId=request.getParameter(" enterPriseId");
       String acquirerEnterPriseId=request.getParameter("acquirerEnterPriseId");
       Double amount=Double.parseDouble(request.getParameter("amount"));
       int institutyId=Integer.parseInt(request.getParameter("institutyId"));
       SimpleDateFormat f1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date createTime= f1.parse(request.getParameter("createTime"));
       Date expiryTime=f1.parse(request.getParameter("expiryTime"));
       String paymentInterestType=request.getParameter("paymentInterestType");
       String ticketRemark=request.getParameter("ticketRemark");
       TicketopenBizImpl ticketopenBiz=new TicketopenBizImpl();
       Ticketopen ticketopen1=new Ticketopen();
       SimpleDateFormat f=new SimpleDateFormat("yyyyMMddHHmmss");
        String date=f.format(new Date(System.currentTimeMillis()));
        ticketopen1.setNo("N"+date);
        ticketopen1.setEnterPriseId(enterPriseId);
        ticketopen1.setNo(no);
        ticketopen1.setAcquirerEnterPriseId(acquirerEnterPriseId);
        ticketopen1.setAmount(amount);
        ticketopen1.setInstitutyId(institutyId);
        ticketopen1.setCreateTime(createTime);
        ticketopen1.setExpiryTime(expiryTime);
        ticketopen1.setPaymentInterestType(paymentInterestType);
        ticketopen1.setStatus("B");
        String uplinkAddress= MD5Util.getInstance().toHashHexStr("N"+date);
        ticketopen1.setUplinkAddress(uplinkAddress.substring(0,16));
        ticketopen1.setTicketRemark(ticketRemark);
   }
}
