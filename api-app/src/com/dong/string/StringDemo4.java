package com.dong.string;

import java.util.Scanner;

/**
 * 结论:字符串的内容比较不适用于 "==" 比较
 *
 * 字符串的内容比较:
 * 推荐使用String类提供的"equals" 比较:只关心内容一样即可
 */
public class StringDemo4 {
    public static void main(String[] args) {
        //1 正确登录名和密码

        String okName = "itheima";
        String okPassword = "123456";

        Scanner s = new Scanner(System.in);
        System.out.println("请您输入登入名");
        String name = s.next();
        System.out.println("登录密码");
        String password = s.next();
        if (okName.equals(name)  && password.equals(okPassword)){
            System.out.println("登录成功");
        }else {
            System.out.println("用户名密码错误");
        }

        //4 忽略大小写比较内容的API:一般用于比较验证码这样的业务逻辑
        String syscode = "23AdFh";
        String code1 = "23adfh";
        boolean b = code1.equals(syscode);
        System.out.println(b);

        System.out.println(code1.equalsIgnoreCase(syscode));
    }
}
