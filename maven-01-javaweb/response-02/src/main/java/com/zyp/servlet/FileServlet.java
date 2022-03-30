package com.zyp.servlet;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取文件下载文件路径
        String realPath ="E:\\maven-01-javaweb\\response-02\\target\\classes\\1.jpg";

        System.out.println("下载文件的路径：" + realPath);
        //下载的文件名叫？
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        //设置想办法让浏览器能支持（content-Disposition）
        resp.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(fileName,"UTF-8"));//注意attachmen和filename之间的分号
        //获取下载文件的输入流
        FileInputStream in = new FileInputStream(realPath);
        //创建缓冲区
        int len=0;
        byte[] buffer=new byte[1024];
        //获取outputstream对象
        ServletOutputStream out = resp.getOutputStream();
        //将FileoutputStream流写入到buffer缓冲区
        while ((len=in.read(buffer))>0){
            out.write(buffer,0,len);

        }
        in.close();
        out.close();

        //使用outputStream将缓冲区数据输出到客户端


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
