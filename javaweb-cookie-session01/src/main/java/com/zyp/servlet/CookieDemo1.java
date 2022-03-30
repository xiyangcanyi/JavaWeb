package com.zyp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
              out.write("你上一次访问的时间是：");
//            for (Cookie cookie:cookies){
//
//            }
            for(int i=0;i<cookies.length;i++){
                Cookie cookie=cookies[i];
                if(cookie.getName().equals("lastLoginTime")){
                    long lastLoginTime= Long.parseLong(cookie.getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());


                }
            }
        }else {
            out.write("这是你第一次访问本站");
        }


        Cookie cookie=new Cookie("lastLoginTime",System.currentTimeMillis()+"");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
