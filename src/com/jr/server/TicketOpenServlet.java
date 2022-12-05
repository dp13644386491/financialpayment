package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.EnterpriseBizImpl;
import com.jr.biz.impl.InstitutyBizImpl;
import com.jr.biz.impl.ReviewrecordBizImpl;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.entry.Enterprise;
import com.jr.entry.Instituty;
import com.jr.entry.Reviewrecord;
import com.jr.entry.Ticketopen;
import com.jr.util.*;

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
        System.out.println("到达doget方法");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String num=request.getParameter("i");
        if(num==null){
            String name=request.getParameter("acquirerEnterPrisename");
            Enterprise enterprise2=new Enterprise();
            enterprise2.setName(name);
            EnterpriseBizImpl enterpriseBiz1=new EnterpriseBizImpl();
            Enterprise enterprise1=enterpriseBiz1.queryIdAndSocialUniformCodeByEnterpriseName(enterprise2);
            Gson gson=new Gson();
            response.getWriter().println(gson.toJson(enterprise1));
        }
        if(num.equals("1")||num.equals("2")){
            page(request,response);
        }else if (num.equals("3")){
            System.out.println("到达3");
            selectALLByViewUtility(request,response);
        }

    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String no = request.getParameter("no");
        String acquirerEnterPriseId=request.getParameter("acquirerEnterPriseId");
        String enterPriseId=request.getParameter("enterPriseId");
        String status=request.getParameter("status");
        String createTime=request.getParameter("createtime");
        String amountMax=request.getParameter("amountMax");
        String amountMin=request.getParameter("amountMin");
        SqlHelper sqlHelper = new SqlHelper();
        TicketopenBizImpl ticketopenBiz=new TicketopenBizImpl();
        sqlHelper.setNo(no);
        sqlHelper.setAcquirerEnterPriseId(acquirerEnterPriseId);
        sqlHelper.setEnterPriseId(enterPriseId);
        sqlHelper.setCreateTime(createTime);
        sqlHelper.setAmountMax(amountMax);
        sqlHelper.setAmountMin(amountMin);
        sqlHelper.setStatus(status);
        PageHelper<ViewOpenEnterprise> ph=new PageHelper<>();
        ph.setTotalCount(ticketopenBiz.getAllnum1(sqlHelper));
        ph.setPageSize(5);
        ph.getTotalPage();

        String str=request.getParameter("index");
        if(str==null){
            ph.setIndexPage(1);
        }else{
            int i=Integer.parseInt(str);
            ph.setIndexPage(i);
        }
        ph.setPageList(ticketopenBiz.getBypage1(ph,sqlHelper));
        Gson gson = new Gson();
        response.getWriter().println( gson.toJson(ph));
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
       /*
       获取前端页面传过来的值
        */
       String enterPrisename=request.getParameter("enterPrisename");
       Enterprise enterprise1=new Enterprise();
       enterprise1.setName(enterPrisename);
       EnterpriseBizImpl enterpriseBiz1=new EnterpriseBizImpl();
       //将前端传过来的值转成id存进数据库
       Enterprise enterprise2=enterpriseBiz1.queryIdAndSocialUniformCodeByEnterpriseName(enterprise1);
       String acquirerEnterPrisename=request.getParameter("acquirerEnterPrisename");
       Enterprise enterprise3=new Enterprise();
       enterprise3.setName(acquirerEnterPrisename);
       Enterprise enterprise4=enterpriseBiz1.queryIdAndSocialUniformCodeByEnterpriseName(enterprise3);
       Double amount=Double.parseDouble(request.getParameter("amount"));
       String institutyname=request.getParameter("institutyname");
       Instituty instituty1=new Instituty();
       instituty1.setName(institutyname);
       InstitutyBizImpl institutyBiz1=new InstitutyBizImpl();
       Instituty instituty2=institutyBiz1.quaryIdByname(instituty1);
       SimpleDateFormat f1=new SimpleDateFormat("yyyy-MM-dd");
       Date createTime= f1.parse(request.getParameter("createTime"));
       Date expiryTime=f1.parse(request.getParameter("expiryTime"));
       String paymentInterestType=request.getParameter("paymentInterestType");
       String ticketRemark=request.getParameter("ticketRemark");
       Ticketopen ticketopen1=new Ticketopen();
       //自动生成凭证编号和将所有值存进数据库
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
       if (i!=0){
          Ticketopen ticketopen3=new Ticketopen();
          ticketopen3.setNo(ticketopen1.getNo());
          TicketopenBizImpl ticketopenBiz3=new TicketopenBizImpl();
          Ticketopen ticketopen4=ticketopenBiz3.quaryAllByNo(ticketopen3);
           int userid=Integer.parseInt(request.getParameter("userid"));
           Reviewrecord reviewrecord1=new Reviewrecord();
           reviewrecord1.setTicketOpenId(ticketopen4.getId());
           reviewrecord1.setCreatorId(userid);
           reviewrecord1.setReviewStatus("A");
           reviewrecord1.setCreateTime(createTime);
           ReviewrecordBizImpl reviewrecordBiz1=new ReviewrecordBizImpl();
           int i1=reviewrecordBiz1.addReviewrecord(reviewrecord1);
           if (i1==1){
               System.out.println("添加成功");
           }else {
               System.out.println("添加失败");
           }



       }

       Gson gson=new Gson();
       response.getWriter().println(gson.toJson(i));

   }
   //通过视图查询所有信息
   public void  selectALLByViewUtility(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("到达selectALLByViewUtility");
        String no=request.getParameter("N20220328000001");
       ViewUtility viewUtility2=ViewUtility.sleectInfoView(no);
       ReviewrecordBizImpl reviewrecordBiz1=new ReviewrecordBizImpl();
       Reviewrecord reviewrecord1=reviewrecordBiz1.getReviewrecord(Integer.parseInt(no));
       int day=0;
       try {
           day= (int) ((new SimpleDateFormat("yyyy-MM-dd").parse(viewUtility2.getExpriyTime()).getTime()-new Date().getTime())/(1000*3600*24));
       } catch (ParseException e) {
           e.printStackTrace();
       }
       System.out.println(viewUtility2);
       HttpSession session1=request.getSession();
       session1.setAttribute("xcv",viewUtility2);
       session1.setAttribute("dfg",reviewrecord1);
       session1.setAttribute("day1",day);
       request.getRequestDispatcher("open-detail").forward(request,response);
   }
}
