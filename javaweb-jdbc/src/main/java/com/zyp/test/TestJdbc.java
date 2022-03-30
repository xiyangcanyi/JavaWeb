package com.zyp.test;

import java.sql.*;


public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8解决中文乱码
        String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false";
        String username="root";
        String password="123456";
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.向数据库发送sql的对象Statement：CRUD
        Statement statement = connection.createStatement();
        //4.编写SQL
        String sql="select * from users;";
        //5.执行SQL,返回结果集ResultSet
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name1"));
            System.out.println("password="+resultSet.getObject("password1"));
            System.out.println("email="+resultSet.getObject("email"));
            System.out.println("birthday="+resultSet.getObject("birthday"));
        }
        //6关闭连接。释放资源，先开后关原则
        resultSet.close();
        statement.close();
        connection.close();





    }
}
