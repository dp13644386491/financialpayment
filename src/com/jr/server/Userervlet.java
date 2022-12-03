package com.jr.server;

import com.jr.biz.impl.UserBizImpl;
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
     * 使用sesson存储用户登录后返回的对象
     * */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String account = request.getParameter("account");
        String password =request.getParameter("password");
        System.out.println(account+".........");
        System.out.println(password+"........");
        UserBizImpl userBiz=new UserBizImpl();
        User user1=new User();
        user1.setAccount(account);
        user1.setPassword(password);
        if(userBiz.login(user1)!=null){
            request.getRequestDispatcher("ticket-open.jsp").forward(request ,response);
            HttpSession session=request.getSession();
            session.setAttribute("user",user1);
        }else {
           response.getWriter().println("1134");
        }
    }
}
