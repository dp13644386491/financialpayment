package com.jr.server;

import com.google.gson.Gson;
import com.jr.biz.impl.EnterpriseBizImpl;
import com.jr.entry.Enterprise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/eps")
public class EnterpriseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        EnterpriseBizImpl enterpriseBiz = new EnterpriseBizImpl();
        List<Enterprise> list=enterpriseBiz.getAllEnterpriseNames();
        Gson gson = new Gson();
        response.getWriter().println(gson.toJson(list));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }



}
