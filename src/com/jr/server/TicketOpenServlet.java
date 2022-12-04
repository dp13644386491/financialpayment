package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.EnterpriseBizImpl;
import com.jr.biz.impl.InstitutyBizImpl;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.entry.Enterprise;
import com.jr.entry.Instituty;
import com.jr.entry.Ticketopen;
import com.jr.util.MD5Util;

import javax.lang.model.element.NestingKind;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@WebServlet("/mst")
public class TicketOpenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("acquirerEnterPrisename");
        System.out.println(name);
        Enterprise enterprise2=new Enterprise();
        enterprise2.setName(name);
        EnterpriseBizImpl enterpriseBiz1=new EnterpriseBizImpl();
        Enterprise enterprise1=enterpriseBiz1.queryIdAndSocialUniformCodeByEnterpriseName(enterprise2);
        Gson gson=new Gson();
        response.getWriter().println(gson.toJson(enterprise1));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try {
            insertTicketopencondition(request ,response);
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
   protected  void  insertTicketopencondition(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException, ServletException {
       request.setCharacterEncoding("UTF-8");
       response.setCharacterEncoding("UTF-8");
       response.setContentType("text/html;charset=UTF-8");
       String enterPrisename=request.getParameter("enterPrisename");
       System.out.println(enterPrisename);
       Enterprise enterprise1=new Enterprise();
       enterprise1.setName(enterPrisename);
       System.out.println(enterprise1);
       EnterpriseBizImpl enterpriseBiz1=new EnterpriseBizImpl();
       Enterprise enterprise2=enterpriseBiz1.queryIdAndSocialUniformCodeByEnterpriseName(enterprise1);
       System.out.println(enterprise2.getId());
       String acquirerEnterPrisename=request.getParameter("acquirerEnterPrisename");
       Enterprise enterprise3=new Enterprise();
       enterprise3.setName(acquirerEnterPrisename);
       Enterprise enterprise4=enterpriseBiz1.queryIdAndSocialUniformCodeByEnterpriseName(enterprise3);
       System.out.println(enterprise4.getId());
       Double amount=Double.parseDouble(request.getParameter("amount"));
       String institutyname=request.getParameter("institutyname");
       Instituty instituty1=new Instituty();
       instituty1.setName(institutyname);
       InstitutyBizImpl institutyBiz1=new InstitutyBizImpl();
       Instituty instituty2=institutyBiz1.quaryIdByname(instituty1);
       System.out.println(instituty2.getId());
       SimpleDateFormat f1=new SimpleDateFormat("yyyy-MM-dd");
       Date createTime= f1.parse(request.getParameter("createTime"));
       Date expiryTime=f1.parse(request.getParameter("expiryTime"));
       String paymentInterestType=request.getParameter("paymentInterestType");
       String ticketRemark=request.getParameter("ticketRemark");
       System.out.println(ticketRemark+".........");
       Ticketopen ticketopen1=new Ticketopen();
       SimpleDateFormat f=new SimpleDateFormat("yyyyMMddHHmmss");
        String date=f.format(new Date(System.currentTimeMillis()));
        ticketopen1.setNo("N"+date);
        ticketopen1.setEnterPriseId(String.valueOf(enterprise2.getId()));
        ticketopen1.setAcquirerEnterPriseId(String.valueOf(enterprise4.getId()));
        ticketopen1.setAmount(amount);
        ticketopen1.setInstitutyId(instituty2.getId());
        ticketopen1.setCreateTime(createTime);
        ticketopen1.setExpiryTime(expiryTime);
        if(paymentInterestType.equals("融资方付息")){
            ticketopen1.setPaymentInterestType("A");
        }else {
            ticketopen1.setPaymentInterestType("B");
        }
        ticketopen1.setStatus("B");
        String uplinkAddress= MD5Util.getInstance().toHashHexStr("N"+date);
        ticketopen1.setUplinkAddress(uplinkAddress.substring(0,16));

        ticketopen1.setTicketRemark(ticketRemark);
        TicketopenBizImpl tt=new TicketopenBizImpl();
       int i=tt.addTicket(ticketopen1);
       Gson gson=new Gson();
       response.getWriter().println(gson.toJson(i));

   }
}
