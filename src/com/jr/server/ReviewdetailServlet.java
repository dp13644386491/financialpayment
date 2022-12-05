package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.ReviewrecordBizImpl;
import com.jr.biz.impl.TicketopenBizImpl;
import com.jr.entry.Reviewrecord;
import com.jr.entry.Ticketopen;
import com.jr.util.ViewUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/rds")
public class ReviewdetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String str=request.getParameter("i");
        if(str==null){
            String no=request.getParameter("no");
            ViewUtility viewUtility=ViewUtility.sleectInfoView(no);
            int day=0;
            try {
                day= (int) ((new SimpleDateFormat("yyyy-MM-dd").parse(viewUtility.getExpriyTime()).getTime()-new Date().getTime())/(1000*3600*24));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            HttpSession session = request.getSession();
            session.setAttribute("viewUtility",viewUtility);
            session.setAttribute("day",day);

            request.getRequestDispatcher("check-detail.jsp").forward(request,response);
        }
        if (str.equals("1")) {
            String no = request.getParameter("no");
            int id = Integer.parseInt(request.getParameter("ticket_id"));
            String remark = request.getParameter("remark");
            System.out.println(remark);
            System.out.println(id);
            System.out.println(no);
            Ticketopen ticketopen = new Ticketopen();
            ticketopen.setNo(no);
            TicketopenBizImpl tbi = new TicketopenBizImpl();
            int num = tbi.updateTicketopenStatus(ticketopen);
            if (num == 1) {
                System.out.println("修改成功");
                Reviewrecord reviewrecord = new Reviewrecord();
                reviewrecord.setTicketOpenId(id);
                reviewrecord.setRemark(remark);
                ReviewrecordBizImpl rbi=new ReviewrecordBizImpl();
                int num1=rbi.changeeviewrecord(reviewrecord);
                if(num1==1){
                    System.out.println("修改成功");
                    Gson gson=new Gson();
                    response.getWriter().println(gson.toJson(num1));
                }
            }
        }
        if(str.equals("2")){
            String no=request.getParameter("no");
            int id=Integer.parseInt(request.getParameter("ticket_id"));
            String remark=request.getParameter("remark");
            System.out.println(remark);
            System.out.println(id);
            System.out.println(no);
            Ticketopen ticketopen=new Ticketopen();
            ticketopen.setNo(no);
            TicketopenBizImpl tbi=new TicketopenBizImpl();
            int num = tbi.updateTicketopenStatus1(ticketopen);
            if(num==1){
                System.out.println("修改成功");
                Reviewrecord reviewrecord=new Reviewrecord();
                reviewrecord.setTicketOpenId(id);
                reviewrecord.setRemark(remark);
                ReviewrecordBizImpl rbi=new ReviewrecordBizImpl();
                int num1=rbi.changeeviewrecord1(reviewrecord);
                if(num1==1){
                    System.out.println("修改成功");
                    Gson gson=new Gson();
                    response.getWriter().println(gson.toJson(num1));
                }

            }
        }


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
