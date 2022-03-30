package com.zyp.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class TestJdbc2 {
    public static void main(String[] args) throws Exception {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String username = "root";
        String password = "123456";

        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接数据库,代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.编写SQL
        //String sql = "insert into  users(id, name1, password1, email, birthday) values (?,?,?,?,?);";
        String sql = "delete from users where id=6";
        //4.预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

//        preparedStatement.setInt(1,7);//给第一个占位符？ 的值赋值为1；
//        preparedStatement.setString(2,"狂神说Java");//给第二个占位符？ 的值赋值为狂神说Java；
//        preparedStatement.setString(3,"123456");//给第三个占位符？ 的值赋值为123456；
//        preparedStatement.setString(4,"24736743@qq.com");//给第四个占位符？ 的值赋值为1；
//        preparedStatement.setDate(5,  new Date(new java.util.Date().getTime()));//给第五个占位符？ 的值赋值为new Date(new java.util.Date().getTime())；

        //5.执行SQL
        int i = preparedStatement.executeUpdate();

        if (i>0){
            System.out.println("删除成功");
        }else {System.out.println("未找到");
        }

        //6.关闭连接，释放资源（一定要做） 先开后关
        preparedStatement.close();
        connection.close();
    }
}

