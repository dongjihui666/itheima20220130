package com.dong.jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBEDemo {
    /**
     * JDCB快速入门
     *
     */
    public static void main(String[] args) throws Exception {
        //1 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2 获取连接
        String url = "jdbc:mysql://localhost:3306/db1?characterEncoding=utf8";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3 定义sql
        String sql = "update account set money=2000 where id=1";

        //4 获取sql的对象Statement
        Statement stmt = conn.createStatement();
        //5执行sql
        int count = stmt.executeUpdate(sql);//受影响的行数

        //6处理结果
        System.out.println(count);

        //7释放资源
        stmt.close();
        conn.close();


    }
}
