package com.zyp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.sendRedirect("/response_02_war/image");
        System.out.println("进入了重定向页面");
        String usename = req.getParameter("usename");
        String password = req.getParameter("password");
        System.out.println(usename+":"+password);
        resp.sendRedirect("/response_02_war/success.jsp");


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
