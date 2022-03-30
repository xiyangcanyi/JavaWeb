package com.zyp.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如何让浏览器每5秒刷新一次；
        resp.setHeader("refresh","3");
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D)image.getGraphics();
        //设置图片的背景颜色
        g.setColor(Color.WHITE);
        g.fillRect(0,0,80,20);
        g.setColor(Color.blue);
        g.setFont(new Font(null,Font.BOLD,20));
        g.drawString(makenum(),0,20);
        //告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpeg");
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        //把图片写给浏览器
        ImageIO.write(image,"jpg",resp.getOutputStream());


    }
    public String makenum(){
        Random random = new Random();
         String num = random.nextInt(99999999)+"";
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<7-num.length();i++){
            buffer.append("0");
        }
        num = buffer.toString() + num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
