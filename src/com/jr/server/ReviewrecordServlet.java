package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.ReviewrecordBizImpl;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.entry.Reviewrecord;
import com.jr.entry.Ticketopen;
import com.jr.util.PageHelper;
import com.jr.util.SqlHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ms")
public class ReviewrecordServlet extends HttpServlet {
    Reviewrecord reviewrecord=new Reviewrecord();
    ReviewrecordBizImpl reviewrecordBiz=new ReviewrecordBizImpl();
    TicketopenBizImpl ticketopenBiz=new TicketopenBizImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String num=request.getParameter("i");
        if(num==null){
            show(request, response);
        }else if(num.equals("2")){
            page(request,response);
        }


    }

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String no = request.getParameter("no");
        String acquirerEnterPriseId=request.getParameter("acquirerEnterPriseId");
        String enterPriseId=request.getParameter("enterPriseId");
        String createTime=request.getParameter("createTime");
        String amountMax=request.getParameter("amountMax");
        String amountMin=request.getParameter("amountMin");
        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.setNo(no);
        sqlHelper.setAcquirerEnterPriseId(acquirerEnterPriseId);
        sqlHelper.setEnterPriseId(enterPriseId);
        sqlHelper.setCreateTime(createTime);
        sqlHelper.setAmountMax(amountMax);
        sqlHelper.setAmountMin(amountMin);
        PageHelper<Ticketopen> ph=new PageHelper<>();
        ph.setTotalCount(ticketopenBiz.getAllnum(sqlHelper));
        ph.setPageSize(5);
        ph.getTotalPage();

        String str=request.getParameter("index");
        if(str==null){
            ph.setIndexPage(1);
        }else{
            int i=Integer.parseInt(str);
            ph.setIndexPage(i);
        }
        ph.setPageList(ticketopenBiz.getBypage(ph));
        Gson gson = new Gson();
        response.getWriter().println( gson.toJson(ph));
    }

    public void show (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String no = request.getParameter("no");
        String acquirerEnterPriseId=request.getParameter("acquirerEnterPriseId");
        String enterPriseId=request.getParameter("enterPriseId");
        String createTime=request.getParameter("createTime");
        String amountMax=request.getParameter("amountMax");
        String amountMin=request.getParameter("amountMin");
        SqlHelper sqlHelper = new SqlHelper();
        sqlHelper.setNo(no);
        sqlHelper.setAcquirerEnterPriseId(acquirerEnterPriseId);
        sqlHelper.setEnterPriseId(enterPriseId);
        sqlHelper.setCreateTime(createTime);
        sqlHelper.setAmountMax(amountMax);
        sqlHelper.setAmountMin(amountMin);
        PageHelper pageHelper1=new PageHelper();
        pageHelper1.setIndexPage(1);
        pageHelper1.setPageSize(5);
        pageHelper1.setTotalCount(ticketopenBiz.getAllnum(sqlHelper));
        pageHelper1.setPageList(ticketopenBiz.getAllByConditionsOnTheBill(sqlHelper));

        Gson gson=new Gson();

        response.getWriter().println(gson.toJson(pageHelper1));

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }


}
