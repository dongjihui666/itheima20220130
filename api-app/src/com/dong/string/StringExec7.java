package com.dong.string;

import java.util.Scanner;

/**
 * 需求:
 * 模拟用户登录功能,最多给三次机会.
 *
 * 分析:
 * 1 系统后台定义好正确的登录名称,密码
 * 2 使用循环控制3次,让用户输入正确的登录名和密码,判断是否登录成功,登录成功则不再进行登录,登录失败给出提示,并让用户继续登录.
 */
public class StringExec7 {
    public static void main(String[] args) {

        //1 定义正确的登录名称和密码
        String okLoginName = "admin";
        String okPassword = "123456";

        Scanner sc = new Scanner(System.in);
        //2 定义一个循环,循环3次,让用户登录
        for (int i = 1; i <= 3; i++) {
            System.out.println("请您输入登录名称");
            String loginName = sc.next();

            System.out.println("请您输入登录密码");
            String password =  sc.next();

            //3 判断登录是否成功!
            if(okLoginName.equals(loginName)){
                if(okPassword.equals(password)){
                    System.out.println("登录成功,欢迎进入系统");
                    break;
                }else{
                    //密码错误
                    System.out.println("密码不正确,您还剩余"+ (3 -i)+"次机会登录");
                }
            }else {
                System.out.println("登录名称错误");
            }
        }
    }
}
