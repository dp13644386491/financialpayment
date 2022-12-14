package com.jr.server;

import com.jr.biz.impl.EnterpriseBizImpl;
import com.jr.biz.impl.UserBizImpl;
import com.jr.entry.Enterprise;
import com.jr.entry.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/asd")
public class Userervlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request,response);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    /**
     * 使用sesson存储用户登录后返回的对象，实现登入功能
     * */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String account = request.getParameter("account");
        String password =request.getParameter("password");
        UserBizImpl userBiz=new UserBizImpl();
        User user1=new User();
        user1.setAccount(account);
        user1.setPassword(password);
        User user2=userBiz.login(user1);
        if (user2!=null){
        Enterprise enterprise2=new Enterprise();
        enterprise2.setId(Integer.parseInt(user2.getEnterPriseId()));
        EnterpriseBizImpl enterpriseBiz1=new EnterpriseBizImpl();
        Enterprise enterprise1=  enterpriseBiz1.getEnterpriseInfo(enterprise2);
            HttpSession session=request.getSession();
            session.setAttribute("user",user2);
            session.setAttribute("sss",enterprise1);
            request.getRequestDispatcher("ticket-open.jsp").forward(request ,response);

        }else {
            response.getWriter().write("<script language='javascript'>alert('账号或密码错误，登录失败！');" +
                    "window.location.href='login.jsp';</script>");

        }
    }
}
